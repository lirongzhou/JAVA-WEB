package com.java.main;

import com.java.mantoto.mould.CreateMantotoMain;

/**
	* @author  作者 li rong zhou 
	* @date 创建时间：2016年9月11日 下午2:55:16 
	* 
	*  
	*/
public class Main {
   
	public static void main(String[] args) {
		CreateMantotoMain createMantotoMain=new CreateMantotoMain();
//		createMantotoMain.createBean("com.java.main");
		
		createMantotoMain.setBeanPack("com.java.main");
		createMantotoMain.createDao("com.java.main");
		createMantotoMain.createService("com.java.main");
		createMantotoMain.createOpenService("com.java.main");
		createMantotoMain.createCache("com.java.main");
		
		
//		createMantotoMain.createDaoImpl("com.java.main");
//		createMantotoMain.createOpenService("com.java.main");
//		createMantotoMain.createServiceImpl("com.java.main");
//		createMantotoMain.createCacheImpl("com.java.main");
		
		
//		try {
//			List<String> tableNames=MantotoPragramBase.sourceData.getTableNames();
//			for(String tableName:tableNames){
//				CreatePragramBase pragram=new CreateMantotoBean(tableName, "com.java.main",NameaRule.INITIALUPPER);
//				System.out.println(pragram.getFileContent().getTemplateStr());
//				ClassTemplate classTemplate=	pragram.getFileContent();
//				CrateJavaFile.CreateJavaMaven(classTemplate.getJavaName(), classTemplate.getPagckage(), classTemplate.getTemplateStr(), "java");
//			}
//		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
