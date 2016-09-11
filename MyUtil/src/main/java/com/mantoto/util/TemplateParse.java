package com.mantoto.util;

import java.util.Map;

/**
 * 模板解析工具
 * @author li rong zhou
 *创建时间  2016年8月2日 上午10:58:12
 */
public class TemplateParse {

	/**
	 * 
	 * @param temlate
	 * @param paresPragram  替换模板的参数  替换规则  #{key} 替换 map。getKey(key)的值  
	 * @return  解析完成后返回解析好的数据
	 */
	public static String parsse(String template,Map<String,String> paresPragram){
		
		if(isNull(template)){
			return  "";
		}
		StringBuffer   replaceAlltemplate=new StringBuffer(template);
		for(String key:paresPragram.keySet()){
			
			if(template.toString().contains(key)){
				replaceAlltemplate= replaceAll(replaceAlltemplate, "#{"+key+"}",paresPragram.get(key));
			}
			
		}
		
		return replaceAlltemplate.toString();
	}
	
	private static  boolean  isNull(Object o){
		return null==o||""==o?true:false;
	}
	private static StringBuffer replaceAll(StringBuffer template, String oldStr,String newStr){
		
		       if(isNull(oldStr))
		    	   return template;
		       
		       if(isNull(newStr))
		    	   newStr="";
		       
		       int i=template.indexOf(oldStr);
		       int oldLen=oldStr.length();
		       int newLen=newStr.length();
		       
		       while(i>-1){
		    	   template.delete(i, i+oldLen);
		    	   template.insert(i, newStr);
		    	   i=template.indexOf(oldStr, i+newLen);		    	  
		       }

		return template;
	
	}
	
	
//	public static void main(String[] args){
//		
//		String template="   尊敬的#{userName}您好，欢迎使用#{appName}。\r\n#{body}。\r\n谢谢大家对#{appName}的支持！";
//		Map paresPragram=new HashMap<String,String>();
//		
//		Map addPrasePragram=new HashMap<String,String>();
//		
//		addPrasePragram.put("userName", "清风徐来");
//		addPrasePragram.put("body", "大家好我是小漫！ 恭喜您获得了一份100元的上网权限");
//		paresPragram.putAll(addPrasePragram);
//		
//		System.out.println( parsse( template, paresPragram));
//		System.out.println(template);
//	
//	}
	
	
	
	
	
	
	
}
