package com.java.templet;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class JavaIterfaceServiceImplTemplate extends JavaFileTempletBase {

	public JavaIterfaceServiceImplTemplate() {
	}

	@Override
	public boolean analysisDataConntent(String packag, String importJar, String className, Map map) {
		// TODO Auto-generated method stub
		if (!importJar.contains(super.getBaseInterfceName().trim())) {
			importJar = importJar + "import " + super.getBaseInterfceName() + ";\r\n";
		}

		StringBuffer netBean = new StringBuffer();
		String beanPragam = "";
		if (null != super.getNetPackage()) {

			netBean.append("\r\n");
			netBean.append(super.getPramAnnotation());
			netBean.append("\r\n");
			netBean.append(pr);
			netBean.append(super.getNetPrefix() + className + super.getNetSuffix());
			netBean.append(" ");
			beanPragam = className + super.getNetSuffix();
			String methodName = beanPragam;

			char[] arr = beanPragam.trim().toCharArray();
			arr[0] = Character.toLowerCase(arr[0]);

			beanPragam = new String(arr);
			netBean.append(beanPragam);
			netBean.append(";");
			netBean.append("\r\n");
			// String returnStr,String methodName,String paramType,String
			// parameter,String thisParam
			// String set = setMethod("void", "set" + methodName,
			// super.getNetPrefix() + className + super.getNetSuffix(),
			// beanPragam, beanPragam);
			// String get = getMethod(super.getNetPrefix() + className +
			// super.getNetSuffix(), "get" + methodName,
			// beanPragam);
			//
			// netBean.append(set);
			// netBean.append(get);
		}

		String implement = super.getBaseInterfceName().trim();
		implement = implement.substring(implement.lastIndexOf(".") + 1);
		StringBuffer conntent = new StringBuffer();
		String overrideMehod = assemblyIterfaceMethod(importJar, className, beanPragam);
		conntent.append(super.javaFileInterfaceImplHead(packag, importJar,
				className + super.getSuffix() + " extends OpenServiceBase  implements " + implement));
		conntent.append(netBean);
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
	public String assemblyIterfaceMethod(String importJar, String entity, String netPramName) {

		Class c;

		try {
			StringBuffer methodStr = new StringBuffer();
			String methodHome = " @Override\r\n public  ";
			String methodEnd = "}  ";

			c = Class.forName(super.getBaseInterfceName().trim());

			Method[] methods = c.getMethods();
			Method[] netMethods = null;
			Map<String, String> methodName = new HashMap<String, String>();
			if (null != super.getNetPackage()) {
				Class netClass = Class
						.forName(super.getNetPackage() + "." + super.getNetPrefix() + entity + super.getNetSuffix());
				netMethods = netClass.getMethods();
				for (Method m : methods) {
					String key = m.getName() + m.getParameterTypes().toString();
					key = key.substring(0, key.indexOf(";"));
					System.out.println(m.getName() + m.getParameterTypes().toString() + " key " + key);
					methodName.put(key, m.getReturnType().getName());
				}

			}

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
                     if(pragram.equals("int")
                    		 ||pragram.equals("String")
                    		 ||pragram.equals("double")
                    		 ||pragram.equals("float")
                    		
                    		 ){
                    	 
                    	 Class clas=Class.forName(this.beanPackage+"."+this.beanName);
						
                    	 methodStr.append(strTopCharToLower(this.getFieldId(clas.getDeclaredFields())));
                     }else if(pragram.equals("boolean")){
                    	 methodStr.append("isContorller" );
                     }else{
                    	 methodStr.append(metndPragram );
                     }
					
					methodStr.append(",");

				}
				methodStr.delete(methodStr.length() - 1, methodStr.length());

				methodStr.append(")");
				methodStr.append("{");
				if (null != netMethods) {
					/**
					 * 判断是否能够找到相同的方法名的下层方法
					 */
					for (Method method : netMethods) {
						if (method.getName().equals(m.getName())) {

							Class[] clss = method.getParameterTypes();
							netMethodTypes: for (Class cl : clss) {
								for (Class cl2 : m.getParameterTypes()) {
									if (cl.equals(cl2)) {
										System.out.println(cl.getSimpleName());
									    if(cl.getSimpleName().equals("int")
					                    		 ||cl.getSimpleName().equals("String")
					                    		 ||cl.getSimpleName().equals("double")
					                    		 ||cl.getSimpleName().equals("float")
					                    		 ){
									   	 Class clas=Class.forName(this.beanPackage+"."+this.beanName);
										  netmetndPragram.append( strTopCharToLower(this.getFieldId(clas.getDeclaredFields())));
//									    	netmetndPragram.append(strTopCharToLower(cl.getSimpleName()) + "Param");
					                     }else if(cl.getSimpleName().equals("boolean")){
					                    	 netmetndPragram.append("isContorller" );
					                     }else{
					                    	 netmetndPragram.append(strTopCharToLower(cl.getSimpleName()));
					                     }
										
										netmetndPragram.append(",");
										continue netMethodTypes;
									}
								}
								netmetndPragram.append(",");
							}
							netmetndPragram.delete(netmetndPragram.length() - 1, netmetndPragram.length());
							
							
//							Pager pager=businessNoticeService.selectBusinessNotice(businessNotice, isContorller);
//							String strApplicationJson;
//							try {
//								/**
//								 * 把查询条件进行序列化成为可对接的字符串
//								 */
//								strApplicationJson = MyJsonView.serializableObject(MessageSelectCondition.class, businessNotice);
//								setPagerSelectCondition(pager, strApplicationJson);
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//								return pager;
							
							if( m.getName().startsWith("delete")){
								methodStr.append(
										"\r\n return " + netPramName + "." + m.getName() + "(" + netmetndPragram + ");");
							}else if(m.getName().startsWith("update")){
								methodStr.append("\r\n if(!Validate.updateSpecificationValidate("+netmetndPragram+"))");
								methodStr.append("\r\n return false;");
								methodStr.append(
										"\r\n return " + netPramName + "." + m.getName() + "(" + netmetndPragram + ");");
								
							}else if(m.getName().startsWith(SELECTCOUNT)){
								methodStr.append(
										"\r\n return " + netPramName + "." + m.getName() + "(" + netmetndPragram + ");");
							}else if(m.getName().startsWith(SELECTBYID)){
								methodStr.append(
										"\r\n return " + netPramName + "." + m.getName() + "(" + netmetndPragram + ");");
							}else if(m.getName().startsWith(SELECT)){
								
								methodStr.append("\r\n Pager pager="+netPramName + "." + m.getName() + "(" + netmetndPragram + ");");
								methodStr.append("\r\nString strApplicationJson;");
								methodStr.append("\r\ntry {");
								methodStr.append("\r\n/**");
								methodStr.append("\r\n * 把查询条件进行序列化成为可对接的字符串");
								methodStr.append(" \r\n*/"); 
								if(netmetndPragram.toString().contains(",")){
									netmetndPragram=netmetndPragram.delete(netmetndPragram.indexOf(","), netmetndPragram.length());
								}
								methodStr.append("\r\n	strApplicationJson = MyJsonView.serializableObject(ProductSelectCondition.class, "+netmetndPragram+");");
								methodStr.append("\r\n	setPagerSelectCondition(pager, strApplicationJson);");
								methodStr.append("\r\n} catch (Exception e) {");
									// TODO Auto-generated catch block");
								methodStr.append("\r\n	e.printStackTrace();");
								methodStr.append("\r\n}");
								methodStr.append("\r\n	return pager;");
								
							}else if(m.getName().startsWith("insert")){
								
								Class clas=Class.forName(this.beanPackage+"."+this.beanName);
								Field[] fields= clas.getDeclaredFields();
                                for(Field field:fields){
                                	if(field.getName().equalsIgnoreCase("cTime")){
//                                		String setMethodName=strTopCharToUpperCase(field.getName());
                                		methodStr.append("\r\n"+netmetndPragram+".setcTime(new Timestamp(System.currentTimeMillis()));");
                                	}
                                }
                                methodStr.append("\r\n"+netmetndPragram+".set"+strTopCharToUpperCase(this.getFieldId(clas.getDeclaredFields()))+"(CreateUniqId.getUniqId());");
								methodStr.append("\r\nif(!Validate.isSpecification("+netmetndPragram+"))");
								methodStr.append("\r\nreturn 0;");
								methodStr.append(
										"\r\n return " + netPramName + "." + m.getName() + "(" + netmetndPragram + ");");
							}
						
						}
						
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
