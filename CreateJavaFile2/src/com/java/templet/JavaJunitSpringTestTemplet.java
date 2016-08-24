package com.java.templet;

import java.lang.reflect.Method;
import java.util.Map;

public class JavaJunitSpringTestTemplet extends JavaFileTempletBase {

	@Override
	public boolean analysisDataConntent(Class clas, String packag) {
		// TODO Auto-generated method stub
		StringBuffer context = new StringBuffer();
		context.append("package " + packag + ";\r\n");
		context.append("import  org.junit.After;\r\n");
		context.append("import  org.junit.Before;\r\n");
		context.append("import  org.junit.Test;\r\n");
		context.append("import  org.springframework.mock.web.MockHttpServletRequest;\r\n");
		context.append("import  org.springframework.mock.web.MockHttpServletResponse;\r\n");
		context.append("import  org.springframework.web.servlet.ModelAndView;\r\n");
		context.append("import  com.mantoto.contorller.test.base.BaseControllerTest;\r\n");
		context.append("import  " + clas.getName() + ";\r\n");

		context.append("public class " + clas.getSimpleName() + "Test" + " extends BaseControllerTest {\r\n");

		context.append("MockHttpServletRequest request; \r\n ");
		context.append("MockHttpServletResponse response; \r\n");
		context.append("ModelAndView  modelAndView;\r\n");
		context.append(clas.getSimpleName() + " " + super.strTopCharToLower(clas.getSimpleName()) + ";\r\n");

		context.append("@Before\r\n");
		context.append("public void  init(){\r\n");

		context.append(super.strTopCharToLower(clas.getSimpleName()) + "=(" + clas.getSimpleName()
				+ ")  this.applicationContext.getBean(\"" + super.strTopCharToLower(clas.getSimpleName()) + "\");\r\n");
		context.append("request = new MockHttpServletRequest();  \r\n");
		context.append("response = new MockHttpServletResponse();  \r\n");
		context.append("modelAndView=new ModelAndView();\r\n");
		context.append("}\r\n");

		context.append("@After\r\n");
		context.append(" public void destroy(){\r\n");
		context.append(" request =null;  \r\n");
		context.append("response =null;  \r\n");
		context.append(super.strTopCharToLower(clas.getSimpleName()) + " =null;\r\n");
		context.append("System.gc();\r\n");
		context.append("}\r\n");

		Method[] methods = clas.getDeclaredMethods();

		for (Method method : methods) {
			context.append("@Test\r\n");
			context.append("public void test" + method.getName() + "(){\r\n");
			context.append("//" + super.strTopCharToLower(clas.getSimpleName()) + "." + method.getName()
					+ "(,modelAndView,request,response)\r\n");
			context.append("}\r\n");

		}

		context.append("}\r\n");

		crate.CreateJavaTest(clas.getSimpleName() + "Test", packag, context.toString(), "java");

		return false;
	}

	@Override
	public boolean analysisDataConntent(String packag, String importJar, String className, String beanPackage,
			Map map) {

		return false;
	}

	@Override
	public boolean analysisDataConntent(String packag, String importJar, String className, Map map) {
		// TODO Auto-generated method stub
		StringBuffer context = new StringBuffer();
		setInterfaceMethodTemplate(className);
		context.append(
				super.javaFileInterfaceHead(packag, importJar, super.getPrefix() + className + super.getSuffix()));

		context.append(super.interfaceMethod(super.DELETE, className));
		context.append(super.interfaceMethod(super.UPDATE, className));
		context.append(super.interfaceMethod(super.INSSERT, className));
		context.append(super.interfaceMethod(super.SELECT, className));
		context.append(super.interfaceMethod(super.SELECTCOUNT, className));
		context.append(super.javaFileEnd());

		if (crate.CreateJava(super.getPrefix() + className + super.getSuffix(), packag, context.toString(), "java")) {
			return super.compiler(packag, super.getPrefix() + className + super.getSuffix());
		}
		return false;
	}

}
