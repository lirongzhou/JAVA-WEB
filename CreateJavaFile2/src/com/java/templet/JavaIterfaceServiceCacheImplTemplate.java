package com.java.templet;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.mantoto.page.Pager;
import com.mantoto.service.base.ServiceBase;

public class JavaIterfaceServiceCacheImplTemplate extends JavaFileTempletBase {

	public JavaIterfaceServiceCacheImplTemplate() {
	}

	@Override
	public boolean analysisDataConntent(String packag, String importJar, String className, Map map) {
		// TODO Auto-generated method stub
		if (!importJar.contains(super.getBaseInterfceName().trim())) {
			importJar = importJar + "import " + super.getBaseInterfceName() + ";\r\n";
		}
		StringBuffer netCacheBean = new StringBuffer();
	    String cacheBeanPragam="";
		if(null != super.getNetCachePackage()){
			importJar=importJar+"import "+super.getNetCachePackage()+"."+super.getNetCachePrefix() + className + super.getNetCacheSuffix()+";";
			netCacheBean.append("\r\n");
			netCacheBean.append(super.getPramAnnotation());
			netCacheBean.append("\r\n");
			netCacheBean.append(pr);
			netCacheBean.append(super.getNetCachePrefix() + className + super.getNetCacheSuffix());
			netCacheBean.append(" ");
			cacheBeanPragam=strTopCharToLower(className + super.getNetCacheSuffix());
			netCacheBean.append(cacheBeanPragam); 
			netCacheBean.append(";");
			netCacheBean.append("\r\n");
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
			
		}

		String implement = super.getBaseInterfceName().trim();
		implement = implement.substring(implement.lastIndexOf(".") + 1);
		StringBuffer conntent = new StringBuffer();
		String overrideMehod = assemblyIterfaceMethod(importJar, className, beanPragam,cacheBeanPragam);
		conntent.append(super.javaFileInterfaceImplHead(packag, importJar,
				className + super.getSuffix() + " extends ServiceBase implements " + implement));
		conntent.append(netBean);
		conntent.append(netCacheBean);
		conntent.append("\r\n@Autowired\r\n private Pager pager;");
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
	public String assemblyIterfaceMethod(String importJar, String entity, String netPramName,String cacheBeanPragam) {

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
							importJar = importJar + "\r\nimport " + pragram + ";\r\n";
						}
						pragram = pragram.substring(pragram.lastIndexOf(".") + 1);
					}
					
					metndPragram = toLowerCase(pragram);
					methodStr.append(pragram + " ");
                   
                    if(pragram.equals("String")||pragram.equals("int")
                    		||pragram.equals("long")||pragram.equals("float")
                    		||pragram.equals("double")){
                    	 Class clas=Class.forName(this.beanPackage+"."+this.beanName);
                    	 methodStr.append( strTopCharToLower(this.getFieldId(clas.getDeclaredFields())));
//                    	methodStr.append(metndPragram + "Param");
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
								        if(cl.getSimpleName().equals("String")||cl.getSimpleName().equals("int")
					                    		||cl.getSimpleName().equals("long")||cl.getSimpleName().equals("float")
					                    		||cl.getSimpleName().equals("double")){
								        	 Class clas=Class.forName(this.beanPackage+"."+this.beanName);
											  netmetndPragram.append( strTopCharToLower(this.getFieldId(clas.getDeclaredFields())));
//								        	netmetndPragram.append(strTopCharToLower(cl.getSimpleName()) + "Param");
					                    }else if(cl.getSimpleName().equals("boolean")){
					                    	netmetndPragram.append("isContorller" );
					                    }else{
					                    	netmetndPragram.append(strTopCharToLower(cl.getSimpleName()) );
					                    }
										netmetndPragram.append(",");
										continue netMethodTypes;
									}
								}
								netmetndPragram.append(",");
							}
							netmetndPragram.delete(netmetndPragram.length() - 1, netmetndPragram.length());
							if( m.getName().startsWith("delete") ){
								methodStr.append("\r\nif("+ netPramName + "." + m.getName() + "(" + netmetndPragram + ")>=1){");							
								methodStr.append("\r\nif(super.isCacheCanUse()){");
//								couponCache.updateCacheByIdCoupon(coupon.getCouponId()+"");
								methodStr.append("\r\n"+cacheBeanPragam+".remove"+beanName+"("+netmetndPragram+");");
								methodStr.append("\r\n}");
								methodStr.append("\r\nreturn true;");
							    methodStr.append("\r\n}");
							    methodStr.append("\r\nreturn false;");
							}else if(m.getName().startsWith("update")){
								methodStr.append("\r\nif("+ netPramName + "." + m.getName() + "(" + netmetndPragram + ")>=1){");
//								
								methodStr.append("\r\nif(super.isCacheCanUse()){");
								Class clas=Class.forName(beanPackage+"."+beanName);
								String idName=strTopCharToUpperCase(getFieldId(clas.getDeclaredFields()));
								 methodStr.append("\r\n"+cacheBeanPragam+"."+UPDATECACHEID+beanName+"("+netmetndPragram+".get"+idName+"()+\"\");");
//								couponCache.updateCacheByIdCoupon(coupon.getCouponId()+"");
								
								methodStr.append("\r\n}");
								methodStr.append("\r\nreturn true;");
							    methodStr.append("\r\n}");
							    methodStr.append("\r\nreturn false;");
								
							}else if(m.getName().startsWith("selectById")){
								methodStr.append("\r\n if (super.isSelectcacheCanUse() && isContorller) ");
								methodStr.append("\r\nreturn "+cacheBeanPragam+"."+SELECTBYID+beanName+"("+netmetndPragram+");");
								methodStr.append("\r\n return " + netPramName + "." + m.getName() + "(" + netmetndPragram + ");");
							}else if(m.getName().startsWith("selectCount")){
								methodStr.append("\r\n if (super.isSelectcacheCanUse() && isContorller) ");
								methodStr.append("\r\nreturn "+cacheBeanPragam+"."+SELECTCOUNT+beanName+"("+netmetndPragram+");");
								methodStr.append("\r\n return " + netPramName + "." + m.getName() + "(" + netmetndPragram + ");");
							} else if(m.getName().startsWith("select")){
								methodStr.append("\r\npager.setPageSize("+netmetndPragram+".getPageSize());");
								methodStr.append("\r\npager.setPageNo("+netmetndPragram+".getPageNo());");
								methodStr.append("\r\nif(super.isSelectcacheCanUse()&&isContorller){");
								methodStr.append("\r\nreturn "+cacheBeanPragam+"."+SELECT+beanName+"("+netmetndPragram+");");
							   methodStr.append(" \r\n}else{");
							   methodStr.append("\r\npager.setRowCount("+SELECTCOUNT+beanName+"("+netmetndPragram+",isContorller)); ");
							   methodStr.append("\r\npager.setResultList( "+ netPramName + "." + m.getName() + "(" + netmetndPragram + "));");
//							     }
								methodStr.append(
										"\r\n }\r\n return pager;");
							}else if(m.getName().startsWith("insert")){
							  methodStr.append("\r\nif("+netPramName + "." + m.getName() + "(" + netmetndPragram + ")>=1){");	
							  methodStr.append("\r\nif(super.isCacheCanUse()){");
							     Class clas=Class.forName(beanPackage+"."+beanName);
							     String idName=strTopCharToUpperCase(getFieldId(clas.getDeclaredFields()));
							     methodStr.append("\r\n"+cacheBeanPragam+"."+UPDATECACHEID+beanName+"("+netmetndPragram+".get"+idName+"()+\"\");");
//								 methodStr.append("\r\n"+cacheBeanPragam+"."+UPDATECACHEID+beanName+"("+netmetndPragram+"set"+idName+");");
							  methodStr.append("\r\n}");
							  methodStr.append("\r\n}");
							  methodStr.append("\r\n return 0;");
							}
						
						}
						;
					}

				}
				// Exception e=new Exception("");
				// e.printStackTrace();

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
