package com.mantoto.product.contorller.test;
import  org.junit.After;
import  org.junit.Before;
import  org.junit.Test;
import  org.springframework.mock.web.MockHttpServletRequest;
import  org.springframework.mock.web.MockHttpServletResponse;
import  org.springframework.web.servlet.ModelAndView;
import  com.mantoto.contorller.test.base.BaseControllerTest;
import  com.mantoto.product.contorller.UserCouponContorller;
public class UserCouponContorllerTest extends BaseControllerTest {
MockHttpServletRequest request; 
 MockHttpServletResponse response; 
ModelAndView  modelAndView;
UserCouponContorller userCouponContorller;
@Before
public void  init(){
userCouponContorller=(UserCouponContorller)  this.applicationContext.getBean("userCouponContorller");
request = new MockHttpServletRequest();  
response = new MockHttpServletResponse();  
modelAndView=new ModelAndView();
}
@After
 public void destroy(){
 request =null;  
response =null;  
userCouponContorller =null;
System.gc();
}
@Test
public void testdeleteUserCoupon(){
//userCouponContorller.deleteUserCoupon(,modelAndView,request,response)
}
@Test
public void testupdateUserCoupon(){
//userCouponContorller.updateUserCoupon(,modelAndView,request,response)
}
@Test
public void testinsertUserCoupon(){
//userCouponContorller.insertUserCoupon(,modelAndView,request,response)
}
@Test
public void testselectUserCoupon(){
//userCouponContorller.selectUserCoupon(,modelAndView,request,response)
}
@Test
public void testselectCountUserCoupon(){
//userCouponContorller.selectCountUserCoupon(,modelAndView,request,response)
}
@Test
public void testselectByIdUserCoupon(){
//userCouponContorller.selectByIdUserCoupon(,modelAndView,request,response)
}
}
