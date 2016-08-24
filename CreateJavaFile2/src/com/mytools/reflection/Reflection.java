package com.mytools.reflection;

import java.lang.reflect.InvocationTargetException;

import com.mytools.base.ToolsBase;

public class Reflection extends ToolsBase {

	/**
	 * 根据传来的java文件名称进行实例化class 对象
	 * 
	 * @param classPath
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Class getClass(String classPath) throws ClassNotFoundException {
		if (isNull(classPath))
			return null;
		Class c = Class.forName(classPath);
		return c;
	}

	/**
	 * 
	 * @param c
	 *            class 对象
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object instance(Class c) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (isNull(c))
			return null;
		Object o = c.newInstance();
		return o;
	}

}
