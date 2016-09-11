package com.java.base;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.mantoto.util.FileBasicOperation;
import com.mantoto.util.TemplateParse;

public abstract class TemplateJavaBase {
	
	static TemplateParse  templateParse =new TemplateParse();
	private static  final String templatePackage="com/template/base";
	

	public abstract String getTemplateStr() ;
	
	public static String getTemplateStr(Object object) {
		
		FileBasicOperation fileBasicOperation=new FileBasicOperation();
		try {

			String template=fileBasicOperation.redFileToString(getRootPath()+"/"+templatePackage+"/"+object.getClass().getSimpleName());
			Map<String,String> paresPragram=getParesPragram (object) ;
			String  fillTemplate= templateParse.parsse(template, paresPragram);
 System.out.println(fillTemplate);
			return fillTemplate;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}
	
	 public static Map<String,String>  getParesPragram (Object obj) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		 Map<String,String> paresPragram=new HashMap<String,String>();
	   	  boolean mark=true;
	         Class<?> cls = obj.getClass();
	         String filedName;
	         Method[] methods=cls.getDeclaredMethods();
	        
	        do{
System.out.println(cls.getSimpleName());
	        	 Field[] fields = cls.getDeclaredFields();
	        	for (Field field : fields) {
	        		Object val=null;
					field.setAccessible(true); //设置些属性是可以访问的  
					val = field.get(obj);//得到此属性的值  
					if(null!=val){
						String getMethod=parGetName(field.getName());
						if(checkGetMet(methods, getMethod)){
							Method method=cls.getMethod(getMethod, new Class[] {});
							
							paresPragram.put(field.getName(), method.invoke(obj,  new Object[] {}).toString());
						}else
							paresPragram.put(field.getName(), "");
						
					}else{
						paresPragram.put(field.getName(), "");
					}
					
		         }
	        	cls=cls.getSuperclass();
	        }while(!cls.getSimpleName().equals("Object"));
	          
	           
	       return paresPragram;
	   }
	 

	    /** 
	     * 拼接某属性的 get方法 
	     *  
	     * @param fieldName 
	     * @return String 
	     */  
	    public static String parGetName(String fieldName) {  
	        if (null == fieldName || "".equals(fieldName)) {  
	            return null;  
	        }  
	        int startIndex = 0;  
	        if (fieldName.charAt(0) == '_')  
	            startIndex = 1;  
	        return "get"  
	                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()  
	                + fieldName.substring(startIndex + 1);  
	    }  
	
	    /** 
	     * 判断是否存在某属性的 get方法 
	     *  
	     * @param methods 
	     * @param fieldGetMet 
	     * @return boolean 
	     */  
	    public static boolean checkGetMet(Method[] methods, String fieldGetMet) {  
	        for (Method met : methods) {  
	            if (fieldGetMet.equals(met.getName())) {  
	                return true;  
	            }  
	        }  
	        return false;  
	    }  
	  
    /**
     * 获得文件的绝对根目录
     * @return
     */
	   public  static StringBuffer getRootPath() {
			StringBuffer path = new  StringBuffer(TemplateJavaBase.class.getResource("").getPath());
			if(path.toString().contains("/WEB-INF/classes")){
				path.delete(path.lastIndexOf("/WEB-INF/classes")+"/WEB-INF/classes".length()+1, path.length());
			}else
			if(path.toString().contains("/WEB-INF/lib")){
				path.delete(path.lastIndexOf("/WEB-INF/lib")+"/WEB-INF".length()+1, path.length());
				path.append("classes/");
			}else if(path.toString().contains("classes")){
				path.delete(path.lastIndexOf("classes")+"classes".length()+1, path.length());
			}
			if(path.toString().startsWith("file:/")){
				path=new StringBuffer(path.substring("file:/".length()));
			}
			if(path.toString().startsWith("/")){
				path=new StringBuffer(path.substring("/".length()));
			}
			
			System.out.println(path);
			return path;
		}
}
