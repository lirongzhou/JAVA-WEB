package com.mytools.file;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class CrateJavaFile {


	public static boolean CreateJava(String classname, String packag, String content, String Suffix) {
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


}
