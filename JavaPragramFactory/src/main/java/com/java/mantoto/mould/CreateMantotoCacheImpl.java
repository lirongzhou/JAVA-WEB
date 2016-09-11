package com.java.mantoto.mould;

import com.java.base.ClassTemplate;
import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;

public class CreateMantotoCacheImpl extends MantotoPragramBase implements  CreatePragramBase{
	
	public CreateMantotoCacheImpl(String tableName,String pack){
		super(JavaLogicClassType.CACHEIMPL);
		super.tableName=tableName;
		super.pack=pack;
		
	}
	public ClassTemplate getFileContent() {
		// TODO Auto-generated method stub
		return null;
	}


}
