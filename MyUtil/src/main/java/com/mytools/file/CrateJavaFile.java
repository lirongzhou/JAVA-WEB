package com.mytools.file;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class CrateJavaFile {

	private String pr = "private  ";

	public boolean CreateJava(String classname, String packag, String content, String Suffix) {
		FileBasicOperation fileOperation = new FileBasicOperation();
		String sysPath = System.getProperty("user.dir");
		String packagPath = packag.replace('.', '\\');

		String filePackagePath = sysPath + "\\src\\" + packagPath;
		File packageFile = new File(filePackagePath);

		if (!packageFile.exists() || !packageFile.isDirectory()) {
			packageFile.mkdirs();
		}
		sysPath = sysPath + "\\src\\" + packagPath + "\\" + classname + "." + Suffix;

		File file = new File(sysPath);

		try {
			file.createNewFile();

			fileOperation.setFile(content, sysPath);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// "\r\n"

		return false;
	}

	public boolean CreateJavaTest(String classname, String packag, String content, String Suffix) {
		FileBasicOperation fileOperation = new FileBasicOperation();
		String sysPath = System.getProperty("user.dir");
		String packagPath = packag.replace('.', '\\');

		String filePackagePath = sysPath + "\\test\\" + packagPath;
		File packageFile = new File(filePackagePath);

		if (!packageFile.exists() || !packageFile.isDirectory()) {
			packageFile.mkdirs();
		}
		sysPath = sysPath + "\\test\\" + packagPath + "\\" + classname + "." + Suffix;

		File file = new File(sysPath);

		try {
			file.createNewFile();

			fileOperation.setFile(content, sysPath);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// "\r\n"

		return false;
	}

	/**
	 * 创建java bean 内容
	 * 
	 * @param map
	 * @return
	 */
	public String analysisDataConntent(Map map) {

		Set<Map.Entry<String, String>> entryseSet = map.entrySet();

		StringBuffer conntent = new StringBuffer();
		String methodName;
		char[] arr;
		for (Map.Entry<String, String> entry : entryseSet) {

			conntent.append(pr);
			conntent.append(entry.getValue().trim());
			conntent.append(" ");
			conntent.append(entry.getKey().trim());
			conntent.append(";");
			conntent.append("\r\n");

			arr = entry.getKey().trim().toCharArray();
			arr[0] = Character.toUpperCase(arr[0]);

			methodName = new String(arr);

			conntent.append(setMethod("void", "set" + methodName, entry.getValue(), entry.getKey(), entry.getKey()));
			conntent.append(getMethod(entry.getValue(), "get" + methodName, entry.getKey()));
		}
		return conntent.toString();
	}

	/**
	 * 
	 * @param packag
	 * @param className
	 * @return
	 */
	public String javaFileHead(String packag, String className) {
		return "package " + packag + "; \r\n" + "public class " + className + "{\r\n";
	}

	public String javaFileEnd() {

		return " }";
	}

	public String setMethod(String returnStr, String methodName, String paramType, String parameter, String thisParam) {

		StringBuffer setMethod = new StringBuffer();
		setMethod.append("\r\npublic ");
		setMethod.append(returnStr);
		setMethod.append(" " + methodName + "(" + paramType + " " + parameter + "){\r\n");
		setMethod.append("this." + thisParam + "=" + parameter + ";\r\n");
		setMethod.append("}\r\n ");

		return setMethod.toString();
	}

	public String getMethod(String returnStr, String methodName, String returnParameter) {

		StringBuffer getMethod = new StringBuffer();
		getMethod.append("\r\npublic ");
		getMethod.append(returnStr);
		getMethod.append(" " + methodName + "(){\r\n");
		getMethod.append("return this." + returnParameter + ";\r\n");
		getMethod.append("} \r\n");

		return getMethod.toString();
	}

}
