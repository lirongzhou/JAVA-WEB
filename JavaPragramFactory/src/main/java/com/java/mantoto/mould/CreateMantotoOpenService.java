package com.java.mantoto.mould;

import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;

public class CreateMantotoOpenService extends MantotoPragramBase implements  CreatePragramBase{
	private Class beanClass;
	public CreateMantotoOpenService(String tableName,String pack,Class beanClass){
		super(JavaLogicClassType.OPENSERVICE);
		super.tableName=tableName;
		super.pack=pack;
		this.beanClass=beanClass;
	}
	public String getFileContent() {
		// TODO Auto-generated method stub
		return null;
	}


}
