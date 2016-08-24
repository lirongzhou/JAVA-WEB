package com.java.templet;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.mantoto.redis.RedisBase;
import com.mantoto.service.base.ServiceBase;

public class JavaIterfaceCacheImplTemplate extends JavaFileTempletBase {

	public JavaIterfaceCacheImplTemplate() {
	}

	@Override
	public boolean analysisDataConntent(String packag, String importJar, String className, Map map) {
		// TODO Auto-generated method stub
		if (!importJar.contains(super.getBaseInterfceName().trim())) {
			importJar = importJar + "import " + super.getBaseInterfceName() + ";\r\n";
		}
		String implement = super.getBaseInterfceName().trim();
		implement = implement.substring(implement.lastIndexOf(".") + 1);
		StringBuffer conntent = new StringBuffer();
		String overrideMehod = assemblyIterfaceMethod(importJar, className);
		conntent.append(super.javaFileInterfaceImplHead(packag, importJar,
				className + super.getSuffix() + " extends RedisBase implements " + implement));
		conntent.append(overrideMehod);
		conntent.append(super.javaFileEnd());
		System.out.println(conntent.toString());
		if (crate.CreateJava(className + super.getSuffix(), packag, conntent.toString(), "java")) {
			return super.compiler(packag, className + super.getSuffix());
		}
		return false;
	}

	// public static void main(String[] args){
	// new JavaIterfaceImplTemplet().assemblyIterfaceMethod("","Address");
	// }
	//

	public String toLowerCase(String str) {
		String sub;
		if (str.contains(".")) {
			sub = str.substring(str.lastIndexOf(".") + 1);
		} else
			sub = str;

		char[] javaNameChar = sub.trim().toCharArray();
		javaNameChar[0] = Character.toLowerCase(javaNameChar[0]);
		sub = new String(javaNameChar);
		return sub;
	}

	/**
	 * 拼装接口的实现方法
	 * 
	 * @return
	 */
	public String assemblyIterfaceMethod(String importJar, String entity) {

		Class c;

		try {
			StringBuffer methodStr = new StringBuffer();
			String methodHome = " @Override\r\n public  ";
			String methodEnd = "}  ";

			c = Class.forName(super.getBaseInterfceName().trim());

			Method[] methods = c.getMethods();
		
			for (Method m : methods) {
				/**
				 * 开始拼凑方法
				 */
				methodStr.append(methodHome);
				/**
				 * 获得方法的返回类型
				 */
				String returnType = m.getReturnType().getName();
				if (returnType.contains(".")) {
					if (!importJar.contains(returnType)) {
						importJar = importJar + "import " + returnType + ";\r\n";
					}
					returnType = returnType.substring(returnType.lastIndexOf(".") + 1);

				}
				if (returnType.trim().equals("List")) {
					returnType = returnType + "<" + entity + ">";
				}
				/**
				 * 拼凑到方法
				 */
				methodStr.append(returnType + " ");

				/**
				 * 写入方法需要的参数
				 */
				methodStr.append(m.getName());
				methodStr.append("(");

				StringBuffer netmetndPragram = new StringBuffer();
				Class[] cls = m.getParameterTypes();
				String pragram;
				for (Class cl : cls) {
					pragram = cl.getName();
					String metndPragram;
					if (pragram.contains(".")) {
						if (!importJar.contains(pragram)) {
							importJar = importJar + "import " + pragram + ";\r\n";
						}
						pragram = pragram.substring(pragram.lastIndexOf(".") + 1);
					}
					metndPragram = toLowerCase(pragram);
					methodStr.append(pragram + " ");
					if(!m.getName().startsWith(SELECT)||m.getName().startsWith(SELECTBYID)){
						Class clas=Class.forName(this.beanPackage+"."+this.beanName);
	                	 methodStr.append( strTopCharToLower(this.getFieldId(clas.getDeclaredFields())));
					}else{
						methodStr.append(strTopCharToLower(pragram));
					}
//					methodStr.append(metndPragram + "Param");
					methodStr.append(",");

				}
				if(methodStr.toString().endsWith(",")){
					methodStr.delete(methodStr.length() - 1, methodStr.length());
				}

				methodStr.append(")");
				methodStr.append("{");
				
				if(!returnType.contains("void")){
					if(returnType.contains("int")
							||returnType.contains("double")
							||returnType.contains("float")
							||returnType.contains("long")){
						methodStr.append("\r\nreturn 0;");
					}else if(returnType.contains("boolean")){
						methodStr.append("\r\nreturn false;");
					}else{
						methodStr.append("\r\nreturn null;");
					}
				}
                     
				
                 
				methodStr.append("\r\n");

				methodStr.append(methodEnd);
				methodStr.append("\r\n");

			}

			System.out.println(methodStr.toString());
			return methodStr.toString();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(super.getBaseInterfceName().trim());
		}

		return "";
	}

	@Override
	public boolean analysisDataConntent(String packag, String importJar, String className, String beanPackage,
			Map map) {
		this.beanPackage=beanPackage;
		this.beanName=className;
		// TODO Auto-generated method stub
		return analysisDataConntent(packag, importJar, className, map);
	}

}
