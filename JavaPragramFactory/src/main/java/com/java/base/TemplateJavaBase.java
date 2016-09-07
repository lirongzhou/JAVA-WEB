package com.java.base;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.mantoto.util.FileBasicOperation;
import com.mantoto.util.TemplateParse;

public abstract class TemplateJavaBase {
	
	static TemplateParse  templateParse =new TemplateParse();
	private static  final String templatePackage="com/template/base";
	protected String comments;

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
		}

		return "";
	}
	
	 public static Map<String,String>  getParesPragram (Object obj) throws IllegalArgumentException, IllegalAccessException {
		 Map<String,String> paresPragram=new HashMap<String,String>();
	   	  boolean mark=true;
	         Class<?> cls = obj.getClass();
	         String filedName;
	        do{
System.out.println(cls.getSimpleName());
	        	 Field[] fields = cls.getDeclaredFields();
	        	for (Field field : fields) {
	        		Object val=null;
					field.setAccessible(true); //设置些属性是可以访问的  
					val = field.get(obj);//得到此属性的值  
					if(null!=val){
						paresPragram.put(field.getName(), val.toString());
					}else{
						paresPragram.put(field.getName(), "");
					}
					
		         }
	        	cls=cls.getSuperclass();
	        }while(!cls.getSimpleName().equals("Object"));
	          
	           
	       return paresPragram;
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
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
