package com.mytools.base;

import com.mantoto.util.FindClasses;

public class RootPath {
    /**
     * 获得文件的绝对根目录
     * @return
     */
	   public  static StringBuffer getRootPath(Class clas,String pagck,String fileName) {
		   pagck = pagck.replaceAll("\\.", "/");
			StringBuffer path = new  StringBuffer(clas.getResource("").getPath());
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
			return path.append(pagck+"/"+fileName);
		}
	   
	   
}
