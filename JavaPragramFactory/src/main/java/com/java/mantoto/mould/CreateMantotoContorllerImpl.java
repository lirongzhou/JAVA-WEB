package com.java.mantoto.mould;

import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;

public class CreateMantotoContorllerImpl extends MantotoPragramBase implements  CreatePragramBase{
	
	public CreateMantotoContorllerImpl(String tableName,String pack){
		super(JavaLogicClassType.CONTORLLERIMPL);
		super.tableName=tableName;
		super.pack=pack;
		
	}
	public String getFileContent() {
		// TODO Auto-generated method stub
		return null;
	}


}
