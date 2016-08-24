package com.java.templet;

import java.util.Map;

public class JavaIterfaceTemplet extends JavaFileTempletBase {

	@Override
	public boolean analysisDataConntent(String packag, String importJar, String className, String beanPackage,
			Map map) {
		// TODO Auto-generated method stub
		StringBuffer context = new StringBuffer();
		// setInterFacwMwthodTemplt(className);
		setInterfaceMethodTemplate(className);
		context.append(
				super.javaFileInterfaceHead(packag, importJar, super.getPrefix() + className + super.getSuffix()));
		context.append(super.interfaceMethod(super.SELECTBYID, className, beanPackage));
		context.append(super.interfaceMethod(super.DELETE, className, beanPackage));
		context.append(super.interfaceMethod(super.UPDATE, className));
		context.append(super.interfaceMethod(super.INSSERT, className));
		context.append(super.interfaceMethod(super.SELECT, className));
		context.append(super.interfaceMethod(super.SELECTCOUNT, className));
		context.append(super.javaFileEnd());
		resetMethodPrefix();
		if (crate.CreateJava(super.getPrefix() + className + super.getSuffix(), packag, context.toString(), "java")) {
			return super.compiler(packag, super.getPrefix() + className + super.getSuffix());
		}
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
