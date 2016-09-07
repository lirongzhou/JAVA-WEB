package com.mytutil.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertiesOperation  {

	private Properties props;

	public PropertiesOperation() {
		props = new Properties();
	}

	/**
	 * 获得一个 配置文件的操作对象
	 * 
	 * @param PropertiePath
	 * @return
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	public Properties load(String PropertiePath)
			throws IOException, UnsupportedEncodingException, FileNotFoundException {
		props.load(new InputStreamReader(new FileInputStream(PropertiePath), System.getProperty("file.encoding")));
		return props;
	}
}
