package com.java.mantoto.mould;

import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;

public class CreateMantotoContorller extends MantotoPragramBase implements  CreatePragramBase{
	private Class beanClass;
	public CreateMantotoContorller(String tableName,String pack,Class beanClass){
		super(JavaLogicClassType.CONTORLLER);
		super.tableName=tableName;
		super.pack=pack;
		
	}
	public String getFileContent() {
		// TODO Auto-generated method stub
		return null;
	}


}
