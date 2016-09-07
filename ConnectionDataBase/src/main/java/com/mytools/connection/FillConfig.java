package com.mytools.connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.mytutil.config.PropertiesOperation;

public class FillConfig {

	private static String sysPath = System.getProperty("user.dir");
	/**
	 * 填充配置信息到Map中 key 为大写
	 * 
	 * @param sqlService
	 * @param strPackage
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Map fillTypes(SqlService sqlService, String filepath)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Map dataTypes = new HashMap<>();
		PropertiesOperation propertiesOperation = new PropertiesOperation();

		filepath = filepath.replaceAll("\\.", "/");

		Properties properties = propertiesOperation.load(sysPath + "/src/" + filepath + ".properties");

		Set set = properties.keySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String subKey;
			if (key.contains("_")) {
				subKey = key.substring(key.lastIndexOf("_") + 1, key.length());
			} else
				subKey = key;

			switch (sqlService) {
			case SQLSERVER:
				if (!key.toLowerCase().contains("mysql") && !key.toLowerCase().contains("oracle")) {
					dataTypes.put(subKey.trim().toUpperCase(), properties.getProperty(key));
				}
				break;
			case MYSQL:
				if (!key.toLowerCase().contains("sqlserver") && !key.toLowerCase().contains("oracle")) {
					dataTypes.put(subKey.trim().toUpperCase(), properties.getProperty(key));
				}
				break;

			case ORACLE:
				if (!key.toLowerCase().contains("mysql") && !key.toLowerCase().contains("sqlserver")) {
					dataTypes.put(subKey.trim().toUpperCase(), properties.getProperty(key));
				}
				break;
			}
		}

		return dataTypes;
	}
}
