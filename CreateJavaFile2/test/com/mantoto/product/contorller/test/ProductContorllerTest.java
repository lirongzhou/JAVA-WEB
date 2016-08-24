package com.mantoto.product.contorller.test;
import  org.junit.After;
import  org.junit.Before;
import  org.junit.Test;
import  org.springframework.mock.web.MockHttpServletRequest;
import  org.springframework.mock.web.MockHttpServletResponse;
import  org.springframework.web.servlet.ModelAndView;
import  com.mantoto.contorller.test.base.BaseControllerTest;
import  com.mantoto.product.contorller.ProductContorller;
public class ProductContorllerTest extends BaseControllerTest {
MockHttpServletRequest request; 
 MockHttpServletResponse response; 
ModelAndView  modelAndView;
ProductContorller productContorller;
@Before
public void  init(){
productContorller=(ProductContorller)  this.applicationContext.getBean("productContorller");
request = new MockHttpServletRequest();  
response = new MockHttpServletResponse();  
modelAndView=new ModelAndView();
}
@After
 public void destroy(){
 request =null;  
response =null;  
productContorller =null;
System.gc();
}
@Test
public void testselectCountProduct(){
//productContorller.selectCountProduct(,modelAndView,request,response)
}
@Test
public void testselectByIdProduct(){
//productContorller.selectByIdProduct(,modelAndView,request,response)
}
@Test
public void testdeleteProduct(){
//productContorller.deleteProduct(,modelAndView,request,response)
}
@Test
public void testupdateProduct(){
//productContorller.updateProduct(,modelAndView,request,response)
}
@Test
public void testinsertProduct(){
//productContorller.insertProduct(,modelAndView,request,response)
}
@Test
public void testselectProduct(){
//productContorller.selectProduct(,modelAndView,request,response)
}
}
