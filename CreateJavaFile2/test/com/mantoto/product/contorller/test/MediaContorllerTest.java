package com.mantoto.product.contorller.test;
import  org.junit.After;
import  org.junit.Before;
import  org.junit.Test;
import  org.springframework.mock.web.MockHttpServletRequest;
import  org.springframework.mock.web.MockHttpServletResponse;
import  org.springframework.web.servlet.ModelAndView;
import  com.mantoto.contorller.test.base.BaseControllerTest;
import  com.mantoto.product.contorller.MediaContorller;
public class MediaContorllerTest extends BaseControllerTest {
MockHttpServletRequest request; 
 MockHttpServletResponse response; 
ModelAndView  modelAndView;
MediaContorller mediaContorller;
@Before
public void  init(){
mediaContorller=(MediaContorller)  this.applicationContext.getBean("mediaContorller");
request = new MockHttpServletRequest();  
response = new MockHttpServletResponse();  
modelAndView=new ModelAndView();
}
@After
 public void destroy(){
 request =null;  
response =null;  
mediaContorller =null;
System.gc();
}
@Test
public void testselectCountMedia(){
//mediaContorller.selectCountMedia(,modelAndView,request,response)
}
@Test
public void testselectByIdMedia(){
//mediaContorller.selectByIdMedia(,modelAndView,request,response)
}
@Test
public void testdeleteMedia(){
//mediaContorller.deleteMedia(,modelAndView,request,response)
}
@Test
public void testselectMedia(){
//mediaContorller.selectMedia(,modelAndView,request,response)
}
@Test
public void testupdateMedia(){
//mediaContorller.updateMedia(,modelAndView,request,response)
}
@Test
public void testinsertMedia(){
//mediaContorller.insertMedia(,modelAndView,request,response)
}
}
