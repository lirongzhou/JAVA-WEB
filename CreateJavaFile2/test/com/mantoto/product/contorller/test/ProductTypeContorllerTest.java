package com.mantoto.product.contorller.test;
import  org.junit.After;
import  org.junit.Before;
import  org.junit.Test;
import  org.springframework.mock.web.MockHttpServletRequest;
import  org.springframework.mock.web.MockHttpServletResponse;
import  org.springframework.web.servlet.ModelAndView;
import  com.mantoto.contorller.test.base.BaseControllerTest;
import  com.mantoto.product.contorller.ProductTypeContorller;
public class ProductTypeContorllerTest extends BaseControllerTest {
MockHttpServletRequest request; 
 MockHttpServletResponse response; 
ModelAndView  modelAndView;
ProductTypeContorller productTypeContorller;
@Before
public void  init(){
productTypeContorller=(ProductTypeContorller)  this.applicationContext.getBean("productTypeContorller");
request = new MockHttpServletRequest();  
response = new MockHttpServletResponse();  
modelAndView=new ModelAndView();
}
@After
 public void destroy(){
 request =null;  
response =null;  
productTypeContorller =null;
System.gc();
}
@Test
public void testdeleteProductType(){
//productTypeContorller.deleteProductType(,modelAndView,request,response)
}
@Test
public void testupdateProductType(){
//productTypeContorller.updateProductType(,modelAndView,request,response)
}
@Test
public void testinsertProductType(){
//productTypeContorller.insertProductType(,modelAndView,request,response)
}
@Test
public void testselectProductType(){
//productTypeContorller.selectProductType(,modelAndView,request,response)
}
@Test
public void testselectCountProductType(){
//productTypeContorller.selectCountProductType(,modelAndView,request,response)
}
@Test
public void testselectByIdProductType(){
//productTypeContorller.selectByIdProductType(,modelAndView,request,response)
}
}
