package com.java.templet;

import java.util.Map;
import java.util.Set;

public class JavaBeanFileTemplet extends JavaFileTempletBase {

	/**
	 * 创建java bean 内容
	 * 
	 * @param map
	 * @return
	 */
	public boolean analysisDataConntent(String packag, String importJar, String className, Map map) {

		Set<Map.Entry<String, String>> entryseSet = map.entrySet();

		StringBuffer conntent = new StringBuffer();

		conntent.append(super.javaFileHead(packag, importJar, className,"BeanBase"));

		StringBuffer meThods = new StringBuffer();
		String methodName;
		char[] arr;
		for (Map.Entry<String, String> entry : entryseSet) {
			String value = "";
			String ColumnDescription = "";
			if (!isNull(super.getPrimaryKey())) {
				if (super.getPrimaryKey().equals(entry.getKey().trim())) {
					conntent.append("\r\n@JsonView(ProductView.class)");
					conntent.append("\r\n@ValidateAnnotaion(isId=IsId.TRUE)\r\n");
				} else {
					conntent.append("\r\n@JsonView(ProductView.class)");
					conntent.append("\r\n@ValidateAnnotaion\r\n");
				}

			}

			conntent.append(pr);
			if (entry.getValue().trim().contains(",")) {
				value = entry.getValue().trim().substring(0, entry.getValue().trim().indexOf(","));
				ColumnDescription = "//" + entry.getValue().trim().substring(entry.getValue().trim().indexOf(","),
						entry.getValue().trim().length());
				;
			} else {
				value = entry.getValue().trim();
			}
			conntent.append(value);
			conntent.append(" ");
			String key = entry.getKey().trim();

			char[] keyChars = key.toCharArray();
			keyChars[0] = Character.toLowerCase(keyChars[0]);
			key = new String(keyChars);
			conntent.append(key.trim());
			conntent.append(";");
			conntent.append(ColumnDescription);
			conntent.append("\r\n");

			arr = entry.getKey().trim().toCharArray();
			arr[0] = Character.toUpperCase(arr[0]);
			// methodName = new String(arr);

			// meThods.append(setMethod("void", "set" + methodName, value, key,
			// key));
			// meThods.append(getMethod(value, "get" + methodName, key));

		}

		conntent.append(meThods);

		conntent.append(super.javaFileEnd());
		if (crate.CreateJava(className, packag, conntent.toString(), "java")) {
			return super.compiler(packag, className);
		}
		return false;

	}

	@Override
	public boolean analysisDataConntent(String packag, String importJar, String className, String beanPackage,
			Map map) {
		// TODO Auto-generated method stub

		return analysisDataConntent(packag, importJar, className, map);
	}

}
