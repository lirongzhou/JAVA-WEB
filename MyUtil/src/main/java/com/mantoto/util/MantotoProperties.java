package com.mantoto.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
/**
 * Properties文件的操作
 * @author li rong zhou
 *创建时间  2016年8月2日 上午10:57:13
 */
public class MantotoProperties {

	private static Properties pps ;
//	private static String sysPath = System.getProperty("user.dir");
	

	
	private static String  suffix=".properties";
	/**
	 *这个方法已经过时了 请调用 MantotoProperties(String pakageName,String fileName) 这个方法
	 */
	@Deprecated 
	public MantotoProperties(){
//		try {
//			pps = new Properties();
//			pps.load(new InputStreamReader(new FileInputStream(sysPath+"//src//com//mantoto//config//message//"+"mantoto.properties"),"UTF-8"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	private static  boolean isNull(Object o) {
		return null == o || "" == o || "".equals(o) ? true : false;
	}
	
//	public  static StringBuffer getRootPath() {
//		StringBuffer path = new  StringBuffer(MantotoProperties.class.getResource("").getPath());
//		if(path.toString().contains("/WEB-INF/classes")){
//			path.delete(path.lastIndexOf("/WEB-INF/classes")+"/WEB-INF/classes".length()+1, path.length());
//		}else
//		if(path.toString().contains("/WEB-INF/lib")){
//			path.delete(path.lastIndexOf("/WEB-INF/lib")+"/WEB-INF".length()+1, path.length());
//			path.append("classes/");
//		}else if(path.toString().contains("classes")){
//			path.delete(path.lastIndexOf("classes")+"classes".length()+1, path.length());
//		}
//		if(path.toString().startsWith("file:/")){
//			path=new StringBuffer(path.substring("file:/".length()));
//		}
//		if(path.toString().startsWith("/")){
//			path=new StringBuffer(path.substring("/".length()));
//		}
//		
//		System.out.println(path);
//		return path;
//	}
   /**
    * 请传递你的包名和文件名字
    * @param pakageName
    * @param fileName 后缀为.properties
    * @param key
    */
	
	public static String getPropertiesValue(String pakageName,String fileName,String key){
		
		pps = new Properties();
		if(isNull(pakageName)||isNull(fileName)){
			return null;
		}
		if(!fileName.contains(".")){
			return null;
		}
		if(!fileName.substring(fileName.lastIndexOf("."),fileName.length()).equals(suffix)){
			return null;
		}
		
		pakageName=pakageName.replaceAll("\\.", "//");
		try {
//			pps.load(new InputStreamReader(new FileInputStream(sysPath+"//src//"+pakageName+"//"+fileName),"UTF-8"));
			
			StringBuffer path = FindClasses.getRootPath();
//			 System.out.println(path);

			pps.load(new InputStreamReader(new FileInputStream(path+pakageName+"/"+fileName),"UTF-8"));
			String value=pps.getProperty(key);
			pps.clear();
			return value;
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	
	}
	/**
	 * 获得配置文件的操作对象
	 * @param pakageName包名
	 * @param fileName文件名
	 * @return   Properties 对象
	 */
   public static Properties getProperties(String pakageName,String fileName){
		
		pps = new Properties();
		if(isNull(pakageName)||isNull(fileName)){
			return null;
		}
		if(!fileName.contains(".")){
			return null;
		}
		if(!fileName.substring(fileName.lastIndexOf("."),fileName.length()).equals(suffix)){
			return null;
		}
		
		pakageName=pakageName.replaceAll("\\.", "/");
		
		
		try {
//			 StringBuffer path = new  StringBuffer(MantotoProperties.class.getResource("").getPath().substring(1));
//			 path.delete(path.lastIndexOf("classes")+"classes".length()+1, path.length());
			
			StringBuffer path = FindClasses.getRootPath();
//			 System.out.println(path);

			pps.load(new InputStreamReader(new FileInputStream(path+pakageName+"/"+fileName),"UTF-8"));
			return pps;
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
//	public static void main(String [] args){
////		String fileName="business.properties";
////		System.out.println(fileName.substring(fileName.lastIndexOf("."),fileName.length()-1));
//		System.out.println( getProperties("com.mantoto.config.business","business.properties"));
//		 System.out.println(getPropertiesValue("com.mantoto.config.business","business.properties","appName"));
//		
//	}
	public  String getValue(String key){
		return pps.getProperty(key);
	}
}
