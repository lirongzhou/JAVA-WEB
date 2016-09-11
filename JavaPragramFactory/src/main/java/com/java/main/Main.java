package com.java.main;

import java.sql.SQLException;
import java.util.List;

import com.java.base.ClassTemplate;
import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.CreateMantotoBean;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.NameaRule;
import com.mytools.file.CrateJavaFile;

/**
	* @author  作者 li rong zhou 
	* @date 创建时间：2016年9月11日 下午2:55:16 
	* 
	*  
	*/
public class Main {
   
	public static void main(String[] args) {
		
		try {
			List<String> tableNames=MantotoPragramBase.sourceData.getTableNames();
			for(String tableName:tableNames){
				CreatePragramBase pragram=new CreateMantotoBean(tableName, "com.java.mantoto.test",NameaRule.INITIALUPPER);
				System.out.println(pragram.getFileContent().getTemplateStr());
				ClassTemplate classTemplate=	pragram.getFileContent();
				CrateJavaFile.CreateJava(classTemplate.getJavaName(), classTemplate.getPagckage(), classTemplate.getTemplateStr(), ".java");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
