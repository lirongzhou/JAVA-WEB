package com.mytools.main;

import java.lang.reflect.Method;

import com.mantoto.product.contorller.ICouponContorller;

/**
	* @author  作者 li rong zhou 
	* @date 创建时间：2016年8月20日 下午2:54:09 
	* 
	*  
	*/
public class InterfaceTest {
  
   
   public static void main(String[] args) {
	   Class  clas=ICouponContorller.class;
	   
	   
	   Method [] methods= clas.getDeclaredMethods();
	   
	   for(Method m:methods){
		  
	   }
   }
}
