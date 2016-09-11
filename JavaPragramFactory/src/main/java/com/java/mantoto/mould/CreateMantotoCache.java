package com.java.mantoto.mould;

import com.java.base.ClassTemplate;
import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;

public class CreateMantotoCache extends MantotoPragramBase implements  CreatePragramBase{
	
	private Class beanClass;
	public CreateMantotoCache(String tableName,String pack,Class beanClass){
		super(JavaLogicClassType.CACHE);
		super.tableName=tableName;
		super.pack=pack;
		this.beanClass=beanClass;
	}
	public ClassTemplate getFileContent() {
		// TODO Auto-generated method stub
		return null;
	}


}
