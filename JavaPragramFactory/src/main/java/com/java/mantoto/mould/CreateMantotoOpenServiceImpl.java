package com.java.mantoto.mould;

import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;

public class CreateMantotoOpenServiceImpl extends MantotoPragramBase implements  CreatePragramBase{
	
	public CreateMantotoOpenServiceImpl(String tableName,String pack){
		super(JavaLogicClassType.OPENSERVICEIMPL);
		super.tableName=tableName;
		super.pack=pack;
		
	}
	public String getFileContent() {
		// TODO Auto-generated method stub
		return null;
	}


}
