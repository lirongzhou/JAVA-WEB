package com.mytools.main;


import com.mytools.connection.CreateJavaFile;

public class Main {
	public static void main(String[] args) {

		CreateJavaFile analysisDataResult = new CreateJavaFile();
		// /**
		// * 生成实体类的调用方法的
		// */
		//
		//
		//
		//
		StringBuffer buffer = new StringBuffer();
		buffer.append("import  " + "com.fasterxml.jackson.annotation.JsonView;\r\n");
		buffer.append("import  " + "com.mantoto.annotation.ValidateAnnotaion;\r\n");
		buffer.append("import  " + "com.mantoto.annotation.ValidateAnnotaion.IsId;\r\n");
		buffer.append("import  " + "com.mantoto.base.bean.BeanBase;\r\n");
		buffer.append("import  " + "com.mantoto.product.jsonView.ProductView;\r\n");
		analysisDataResult.createJavaEntity("com.mantoto.user.model", buffer.toString());
////		// /**
////		// * 生成接口的调用方法
////		// */
//		 analysisDataResult.createJavaInterface("com.mantoto.product.dao","com.mantoto.product.model","Dao","I");
//		 analysisDataResult.createJavaServiceInterface("com.mantoto.product.service","com.mantoto.product.model","Service","I");
//		 analysisDataResult.createJavaServiceInterface("com.mantoto.product.open.service","com.mantoto.product.model","OpenService","I");
//		 analysisDataResult.createJavaContorllerInterface("com.mantoto.product.contorller","com.mantoto.product.model","Contorller","I");
//		analysisDataResult.createJavaCacheInterface( "com.mantoto.product.cache", "com.mantoto.product.model", "Cache", "I");	

		
		
		/**
		 * 生成Mapper文件的调用方法
		 */

//		 analysisDataResult.createMapperXml("com.mantoto.product.mapper",
//		 "com.mantoto.product.model", "Mapper",
//		 "com.mantoto.product.dao", "Dao", "I", "Msg_");
		
        
		/**
		 * 生成service层 控制缓存与数据库
		 */
//		analysisDataResult.createJavaServiceCacheImpl("com.mantoto.product.model", "com.mantoto.product.service.impl", "ServiceImpl",
//				"com.mantoto.product.service", "Service", "I",
//				"com.mantoto.product.dao","Dao","I",
//				"com.mantoto.product.cache", "I", "Cache");
		/**
		 * 实现缓存接口
		 */
//		analysisDataResult.createJavaCacheInterfaceImpl("com.mantoto.product.model", "com.mantoto.product.cache.impl", "cacheImpl", "com.mantoto.product.cache",
//		"Cache","I");
		/**
		 * 过时的生成service的方法
		 */
       //	 analysisDataResult.createJavaServiceImpl("com.mantoto.product.model","com.mantoto.product.service.impl","ServiceImpl","com.mantoto.product.service","Service","I","com.mantoto.product.dao","Dao","I");
		 /**
		  * 生成service层的 对外提供的接口
		  */
//		analysisDataResult.createJavaServiceImpl("com.mantoto.product.model","com.mantoto.product.open.service.impl","OpenServiceImpl","com.mantoto.product.open.service","OpenService","I","com.mantoto.product.service","Service","I");
		/**
		 * 生成controller
		 */
//		analysisDataResult.createJavaContorllerImpl("com.mantoto.product.model","com.mantoto.product.contorller","Contorller","com.mantoto.product.contorller","Contorller","I","com.mantoto.product.open.service","OpenService","I");
		/**
		 * 生成contorller的测试文件
		 */
		 analysisDataResult.createJavaTestFile("com.mantoto.product.contorller","com.mantoto.product.contorller.test");
	
	}
}
