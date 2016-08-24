package com.java.templet;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mantoto.controller.base.ControllerBase;
import com.mantoto.page.Pager;
import com.mantoto.util.MyJsonView;

public class JavaIterfaceImplContorllerTemplate extends JavaFileTempletBase {


	public JavaIterfaceImplContorllerTemplate() {
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

		}

		String implement = super.getBaseInterfceName().trim();
		implement = implement.substring(implement.lastIndexOf(".") + 1);
		StringBuffer conntent = new StringBuffer();
		String overrideMehod = assemblyIterfaceMethod(importJar, className, beanPragam);
		conntent.append(super.javaFileInterfaceImplHead(packag, importJar,
				className + super.getSuffix() +"  extends ControllerBase "+ " implements " + implement));
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
	 * @param netBeanClass
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
				if (m.getName().startsWith(super.SELECT) || m.getName().startsWith(super.SELECTCOUNT)||m.getName().startsWith(super.SELECTBYID)) {
					methodStr.append("@RequestMapping(method = RequestMethod.GET, value = \"" + m.getName() + "\")\r\n"
							+ methodHome);
				} else if (m.getName().startsWith(super.INSSERT)) {
					methodStr.append("@RequestMapping(method = RequestMethod.POST, value = \"" + m.getName() + "\")\r\n"
							+ methodHome);
				} else if (m.getName().startsWith(super.UPDATE)) {
					methodStr.append("@RequestMapping(method = RequestMethod.PUT, value = \"" + m.getName() + "\")\r\n"
							+ methodHome);
				} else if (m.getName().startsWith(super.DELETE)) {
					methodStr.append("@RequestMapping(method = RequestMethod.DELETE, value = \"" + m.getName()
							+ "\")\r\n" + methodHome);
				} else {
					methodStr.append(methodHome);
				}

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
				/**
				 * 设置方法名及参数
				 */
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
                    if(pragram.equals("String")||pragram.equals("int")
                    		||pragram.equals("long")||pragram.equals("float")
                    		||pragram.equals("double")){
                    	
                    	//methodStr.append(metndPragram + "Param")
                    	
                    	 Class clas=Class.forName(this.beanPackage+"."+this.beanName);
						 strTopCharToLower(this.getFieldId(clas.getDeclaredFields()));
						 methodStr.append( strTopCharToLower(this.getFieldId(clas.getDeclaredFields())));
						 
                    }else if(pragram.equals("HttpServletRequest")){
                    	methodStr.append("request");
                    }else if(pragram.equals("HttpServletResponse")){
                    	methodStr.append("response");
                    }else{
                    	methodStr.append(metndPragram);
                    }
					methodStr.append(",");
				}
				if(methodStr.toString().endsWith(",")){
					methodStr.delete(methodStr.length() - 1, methodStr.length());
				}
				methodStr.append(")");
				methodStr.append("{");
				/**
				 * 开始写方法体
				 */
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
//											  netmetndPragram.append(strTopCharToLower(cl.getSimpleName())+ "Param");
											  Class clas=Class.forName(this.beanPackage+"."+this.beanName);
											  netmetndPragram.append( strTopCharToLower(this.getFieldId(clas.getDeclaredFields())));
										  }else{
											  netmetndPragram.append(strTopCharToLower(cl.getSimpleName()));
										  }
										netmetndPragram.append(",");
										continue netMethodTypes;
									}
								}
								
								netmetndPragram.append(",");
							}
							if(netmetndPragram.toString().endsWith(",")){
								netmetndPragram.delete(netmetndPragram.length() - 1, netmetndPragram.length());
							}
							if(method.getName().contains("select")){
								netmetndPragram.append("true");
							}
//							methodStr.append("\r\n" + netPramName + "." + m.getName() + "(" + netmetndPragram + ");");
							
							
							String returnTypeName=method.getReturnType().getSimpleName();
							String receive="";
							String dataType="";
							 if(returnTypeName.equals("int")){
								 dataType="int";
								 
								 receive="rowCount";
							 }else if (returnTypeName.equals("long")){
								 Class clas=Class.forName(this.beanPackage+"."+this.beanName);
								 
								 dataType="Long"; receive=strTopCharToLower(this.getFieldId(clas.getDeclaredFields()));
							 }else if(returnTypeName.equals("boolean")){
								 dataType="boolean";receive="isSuccess";
							 }else{
								 dataType=returnTypeName; receive=strTopCharToLower(returnTypeName);
							 }
						
							methodStr.append("\r\n" +contorllerMethodBody(  m.getName(), netPramName + "." + m.getName() + "(" + netmetndPragram + ");",dataType,receive));
							
//							methodStr.append("\r\nreturn  modelAndView;");
						}
						;
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

	
	private String contorllerMethodBody(String methodName,String callNetMethod,String dataType,String receive){
		StringBuffer buffer=new StringBuffer();
		if(methodName.startsWith(super.DELETE)||methodName.startsWith(super.UPDATE)){
			buffer.append("\r\ntry {");
//			buffer.append("\r\n boolean isSuccess=false;");
			
			
//			    buffer.append("isSuccess="+callNetMethod);
			    buffer.append("\r\n"+dataType+"  "+receive+"="+callNetMethod);
				buffer.append("\r\nif(isReturnJson(request)){");
				buffer.append("\r\nMap<String, String> jsonMap=new HashMap<String,String>();");
				buffer.append("\r\njsonMap.put(\"isSuccess\", "+receive+"?\"true\":\"false\");");
				buffer.append("\r\nMyJsonView.Render(jsonMap, response);");
				buffer.append("\r\nreturn null;");
				buffer.append("\r\n}else{");
			    buffer.append("\r\nif(isSuccess)");
			    buffer.append(" \r\nreturn returnSuccessPage(modelAndView, getSucccesTitle(request), getSuccessContent(request) );");
			    buffer.append("\r\nelse");
			    buffer.append(" \r\nreturn returnErrorPage(modelAndView, getErroTitle(request),getErroContent(request));");
                buffer.append("}");
			
			buffer.append("\r\n} catch (Exception e) {");
			buffer.append("\r\ne.printStackTrace();");
			buffer.append("\r\nthrow ThrowError(request, e);");
			buffer.append("\r\n}");

		}else if(methodName.startsWith(super.INSSERT)){
			
			
			buffer.append("\r\ntry {");
//			    buffer.append("\r\nlong id=0;");
//			    buffer.append(callNetMethod);
			    buffer.append("\r\n"+dataType+"  "+receive+"="+callNetMethod);
				buffer.append("\r\nif(isReturnJson(request)){");
				buffer.append("\r\nMap<String, String> jsonMap=new HashMap<String,String>();");
				buffer.append("\r\njsonMap.put(\""+receive+"\", "+receive+"+\"\");");
				buffer.append("\r\nMyJsonView.Render(jsonMap, response);");
				buffer.append("\r\nreturn null;");
				buffer.append("\r\n}else{");
			    buffer.append("\r\nif("+receive+">0)");
			    buffer.append(" \r\nreturn returnSuccessPage(modelAndView, getSucccesTitle(request), getSuccessContent(request) );");
			    buffer.append("\r\nelse");
			    buffer.append(" \r\nreturn returnErrorPage(modelAndView, getErroTitle(request),getErroContent(request));");
                buffer.append("}");
			
			buffer.append("\r\n} catch (Exception e) {");
			buffer.append("\r\ne.printStackTrace();");
			buffer.append("\r\nthrow ThrowError(request, e);");
			buffer.append("\r\n}");
		   
		}else if(methodName.startsWith(super.SELECTCOUNT)){
			buffer.append("\r\ntry {");
//				buffer.append(callNetMethod);
				 buffer.append("\r\n"+dataType+"  "+receive+"="+callNetMethod);
					buffer.append("\r\nif(isReturnJson(request)){");
					buffer.append("\r\nMap<String, String> jsonMap=new HashMap<String,String>();");
					buffer.append("\r\njsonMap.put(\""+receive+"\", "+receive+"+\"\");");
					buffer.append("\r\nMyJsonView.Render(jsonMap, response);");
					buffer.append("\r\nreturn null;");
					buffer.append("\r\n}");
					buffer.append("\r\n modelAndView.addObject(\""+receive+"\", "+receive+");");
					buffer.append("\r\n modelAndView.setViewName( getPageName(request));");
					buffer.append("\r\n return modelAndView;");
			buffer.append("\r\n} catch (Exception e) {");
			buffer.append("\r\ne.printStackTrace();");
			buffer.append("\r\nthrow ThrowError(request, e);");
			buffer.append("\r\n}");
		}else if(methodName.startsWith(super.SELECTBYID)){
			buffer.append("\r\ntry {");
//			buffer.append(callNetMethod);
			 buffer.append("\r\n"+dataType+"  "+receive+"="+callNetMethod);
			     buffer.append("\r\n if(isReturnJson(request)){");
			     buffer.append("\r\n String jsonStr = null;");
				 buffer.append("\r\njsonStr = MyJsonView.serializableObject("+getJsonView()+".class, "+receive+");");
				 buffer.append("\r\n MyJsonView.sendJson(response, jsonStr);");
				 buffer.append("\r\n return null;");
			     buffer.append("\r\n }else{");
				 buffer.append("\r\nmodelAndView.addObject(\""+receive+"\", "+receive+");");
				 buffer.append("\r\nmodelAndView.setViewName( getPageName(request));");
				 buffer.append("\r\n return modelAndView;");
			     buffer.append("\r\n }");
			
			buffer.append("\r\n} catch (Exception e) {");
			buffer.append("\r\ne.printStackTrace();");
			buffer.append("\r\nthrow ThrowError(request, e);");
			buffer.append("\r\n}");
		}else if(methodName.startsWith(super.SELECT)){
			buffer.append("\r\ntry {");
//			buffer.append("\r\nPager pager="+callNetMethod);
			buffer.append("\r\n"+dataType+"  "+receive+"="+callNetMethod);
				    buffer.append("\r\nif(isReturnJson(request)){");
				    buffer.append("\r\nString jsonStr = null;");
					buffer.append("\r\njsonStr = MyJsonView.serializableObject("+getJsonView()+".class, "+receive+");");
					buffer.append("\r\nMyJsonView.sendJson(response, jsonStr);");
					buffer.append("\r\nreturn null;");
				    buffer.append("\r\n}else{");
					buffer.append("\r\nmodelAndView.addObject(\"pager\", "+receive+");");
					buffer.append("\r\nmodelAndView.setViewName(getPageName(request));");
					buffer.append("\r\nreturn modelAndView;");
				    buffer.append("\r\n}");
			buffer.append("\r\n} catch (Exception e) {");
			buffer.append("\r\ne.printStackTrace();");
			buffer.append("\r\nthrow ThrowError(request, e);");
			buffer.append("\r\n}");
		}
		
		return buffer.toString();
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
