package com.mantoto.product.contorller.test;
import  org.junit.After;
import  org.junit.Before;
import  org.junit.Test;
import  org.springframework.mock.web.MockHttpServletRequest;
import  org.springframework.mock.web.MockHttpServletResponse;
import  org.springframework.web.servlet.ModelAndView;
import  com.mantoto.contorller.test.base.BaseControllerTest;
import  com.mantoto.product.contorller.CouponContorller;
public class CouponContorllerTest extends BaseControllerTest {
MockHttpServletRequest request; 
 MockHttpServletResponse response; 
ModelAndView  modelAndView;
CouponContorller couponContorller;
@Before
public void  init(){
couponContorller=(CouponContorller)  this.applicationContext.getBean("couponContorller");
request = new MockHttpServletRequest();  
response = new MockHttpServletResponse();  
modelAndView=new ModelAndView();
}
@After
 public void destroy(){
 request =null;  
response =null;  
couponContorller =null;
System.gc();
}
@Test
public void testselectCountCoupon(){
//couponContorller.selectCountCoupon(,modelAndView,request,response)
}
@Test
public void testselectByIdCoupon(){
//couponContorller.selectByIdCoupon(,modelAndView,request,response)
}
@Test
public void testdeleteCoupon(){
//couponContorller.deleteCoupon(,modelAndView,request,response)
}
@Test
public void testupdateCoupon(){
//couponContorller.updateCoupon(,modelAndView,request,response)
}
@Test
public void testinsertCoupon(){
//couponContorller.insertCoupon(,modelAndView,request,response)
}
@Test
public void testselectCoupon(){
//couponContorller.selectCoupon(,modelAndView,request,response)
}
}
