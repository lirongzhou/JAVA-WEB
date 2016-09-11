package com.mantoto.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 正则表达式的验证
 * @author li rong zhou
 *创建时间  2016年8月2日 上午10:31:40
 */
public class JavaREG {


	
//	public static void main(String[] args) {
////        testID_Card();
//      System.out.println(getBirthDay("371525198912145372" ));
//    }

    
    /**
     * 根据身份正获取出生年月日
     * @param identityCard
     * @return
     */
    public static String getBirthDay(String identityCard ){
    	
    	  Pattern BirthDayRegular = Pattern.compile("(\\d{6})(\\d{8})(.*)");
//    	  Pattern YearMonthDayRegular = Pattern
//                  .compile("(\\d{4})(\\d{2})(\\d{2})");
    	  
    	  Matcher matcher = BirthDayRegular.matcher(identityCard);

          if (regIdentityCard(identityCard)) {
        	  if(matcher.matches()){
        		  return matcher.group(2);
        	  }
        	
//              Matcher matcher2 = YearMonthDayRegular
//                      .matcher(matcher.group(2));
                 
//              if (matcher2.matches()) {
//            	  return  matcher2.group(1)+"年"+matcher2.group(2) +"月"+matcher2.group(3)+"日";
//              }
          }
    	return "";
    }
    
    private static Pattern p ;
    /**
     * 邮箱验证
     * @return
     */
    public  static  boolean regEmail(String email){
    	 p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    	
    	return  matcher(p,email);
    }
    
    private static  boolean matcher(Pattern p,String str){
    	Matcher matcher = p.matcher(str);
    	return matcher.matches();
    }
    /**
     * 身份证号验证
     * @return
     */
    public  static  boolean regIdentityCard(String identityCard ){
    	 p = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
    	 Pattern p2 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$");
    	if( matcher(p,identityCard)|| matcher(p2,identityCard))return true;
    	
    	return   false;
    }
    /**
     * 验证手机号码
     * @param phone
     * @return
     */
    public static boolean regPhone(String phone){
    	 p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"); 
    	return  matcher(p,phone);
    }
    /**
     * 验证固定电话
     * @param landline
     * @return
     */
    public  static boolean regLandline(String landline){
    	
    	
    	String regex1 = "\\(?(010|021|022|023|024|025|026|027|028|029|852)?\\)?-?\\d{8}";//3位区号,8位号码
    	String regex2 = "\\(?(0[3-9][0-9]{2})?\\)?-?\\d{7,8}";//4位区号
    	String regex3 = "(\\(?(010|021|022|023|024|025|026|027|028|029|852)?\\)?-?\\d{8})|(\\(?(0[3-9][0-9]{2})?\\)?-?\\d{7,8})";
//    	--------------- 加上分机号 (\\-?[0-9]{1,4})? ------- 区号-号码-分机号 ---------------
    	String regex4 = "\\(?(010|021|022|023|024|025|026|027|028|029|852|)\\)?-?\\d{8}(\\-?[0-9]{1,4})?";//3位区号
    	String regex5 = "\\(?(0[3-9][0-9]{2})\\)?-?\\d{7,8}(\\-?[0-9]{1,4})?";//4位区号
    	String regex6 = "(\\(?(010|021|022|023|024|025|026|027|028|029|852|)\\)?-?\\d{8}(\\-?[0-9]{1,4})?)|(\\(?(0[3-9][0-9]{2})\\)?-?\\d{7,8}(\\-?[0-9]{1,4})?)";

    	if(	matcher(Pattern.compile(regex1),landline)||
    			matcher(Pattern.compile(regex2),landline)||
    			matcher(Pattern.compile(regex3),landline)||
    			matcher(Pattern.compile(regex4),landline)||
    			matcher(Pattern.compile(regex5),landline)||
    			matcher(Pattern.compile(regex6),landline)){
    		return true;
    	}
    	return false;
    }

    /**
     * 过滤特殊字符 [`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？
     * @param str
     * @return
     */
 	public   static   String StringFilter(String   str)  {   
                 // 只允许字母和数字		
                 // String   regEx  =  "[^a-zA-Z0-9]";                   
                    // 清除掉所有特殊字符
 		  String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
 		  Pattern   p   =   Pattern.compile(regEx);   
 		  Matcher   m   =   p.matcher(str);   
 		  return   m.replaceAll("").trim();   
 	}   
    
 	
 	
//    4. 邮箱:
//    	\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*
//    	forJava:  p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    
//    1. 身份证号码:
//    	1) 身份证正则表达式(15位) 
//    	^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$
//    	forJava:  Pattern p = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
//    	------ ------ ------ 说明 start ------ ------ ------
//    	15位身份证号码各位的含义: 
//    	1-2位省、自治区、直辖市代码； 
//    	3-4位地级市、盟、自治州代码； 
//    	5-6位县、县级市、区代码； 
//    	7-12位出生年月日,比如670401代表1967年4月1日,与18位的第一个区别； 
//    	13-15位为顺序号，其中15位男为单数，女为双数；
//    	------ ------ ------ 说明 end ------ ------ ------
//    	2) 身份证正则表达式(18位)^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$
//    	forJava:  Pattern p = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$");
//    	------ ------ ------ 说明 start ------ ------ ------
//    	18位身份证号码各位的含义: 
//    	1-2位省、自治区、直辖市代码； 
//    	3-4位地级市、盟、自治州代码； 
//    	5-6位县、县级市、区代码； 
//    	7-14位出生年月日，比如19670401代表1967年4月1日； 
//    	15-17位为顺序号，其中17位（倒数第二位）男为单数，女为双数； 
//    	18位为校验码，0-9和X。作为尾号的校验码，是由把前十七位数字带入统一的公式计算出来的，计算的结果是0-10，
//    	如果某人的尾号是0－9，都不会出现X，但如果尾号是10，那么就得用X来代替，因为如果用10做尾号，那么此人的身份证就变成了19位。X是罗马数字的10，用X来代替10。
//    	------ ------ ------ 说明 end ------ ------ ------
//
//    	2. 电话号码:
//    	1) 移动电话:  ^((13[0-9])|(15[^4,\D])|(18[0-9]))\d{8}$
//    	------ ------ ------ 说明 start ------ ------ ------
//    	中国电信手机号码开头数字 133、1349、153、180、181、189
//    	中国联通手机号码开头数字 130、131、132、145、155、156、185、186
//    	中国移动手机号码开头数字 1340-1348、135、136、137、138、139、147、150、151、152、157、158、159、182、183、184、187、188　
//    	补充：14开头的号码以前为上网卡专属号段，如联通的是145，移动的是147等等。不过现在14开头的号码也可以使用语音通话等全部业务，不受限制。
//    	------ ------ ------ 说明 end ------ ------ ------
//    	forJava:  Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"); 
//    	2) 固定电话:  
//    	--------------- 区号-号码 -------------------
//    	String regex1 = "\\(?(010|021|022|023|024|025|026|027|028|029|852)?\\)?-?\\d{8}";//3位区号,8位号码
//    	String regex2 = "\\(?(0[3-9][0-9]{2})?\\)?-?\\d{7,8}";//4位区号
//    	String regex3 = "(\\(?(010|021|022|023|024|025|026|027|028|029|852)?\\)?-?\\d{8})|(\\(?(0[3-9][0-9]{2})?\\)?-?\\d{7,8})";
//    	--------------- 加上分机号 (\\-?[0-9]{1,4})? ------- 区号-号码-分机号 ---------------
//    	String regex1 = "\\(?(010|021|022|023|024|025|026|027|028|029|852|)\\)?-?\\d{8}(\\-?[0-9]{1,4})?";//3位区号
//    	String regex2 = "\\(?(0[3-9][0-9]{2})\\)?-?\\d{7,8}(\\-?[0-9]{1,4})?";//4位区号
//    	String regex3 = "(\\(?(010|021|022|023|024|025|026|027|028|029|852|)\\)?-?\\d{8}(\\-?[0-9]{1,4})?)|(\\(?(0[3-9][0-9]{2})\\)?-?\\d{7,8}(\\-?[0-9]{1,4})?)";

    
    
}
