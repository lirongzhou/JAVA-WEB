package com.mantoto.util;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import com.mytools.base.RootPath;
import com.mytools.file.FileBasicOperation;

/**
	* @author  作者 li rong zhou 
	* @date 创建时间：2016年9月12日 上午9:14:06 
	* 
	*  
	*/
public class CompilerJavaToClass {
	
	static FileBasicOperation fileBasicOperation = new FileBasicOperation();

	static String sysPath = System.getProperty("user.dir");

	static String outPath = sysPath + "\\bin\\";
	static String tagetPathSrc = sysPath + "\\src\\";

	static String mavenPath=sysPath+"\\src\\main\\java\\";
	/**
	 * 编译java文件
	 * 
	 * @param packag
	 * @param fileName
	 * @return
	 */
	public boolean compiler(String packag, String fileName) {
		try {
			String packagPath = packag.replace('.', '/');
			JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
			int result = javaCompiler.run(null, null, null, tagetPathSrc + packagPath + "/" + fileName + ".java");
			if (result == 0) {
				return fileBasicOperation.removeFile(fileName + ".class", tagetPathSrc + packagPath,
						outPath + packagPath, true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return false;
	}
    /**
     * 
     * @param sameRootDirectoryclass 相同目录的class文件
     * @param packag                 源文件包名
     * @param fileName               源文件名称
     * @return
     */
	public static  boolean compilerMaven(Class sameRootDirectoryclass,String packag, String fileName) {
		try {
			outPath=RootPath.getClassRootPath(sameRootDirectoryclass).toString();
			String packagPath = packag.replace('.', '/');
			JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
			int result = javaCompiler.run(null, null, null, mavenPath + packagPath + "/" + fileName + ".java");
			
			if (result == 0) {
				return fileBasicOperation.removeFile(fileName + ".class", mavenPath + packagPath,
						outPath + packagPath, true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
