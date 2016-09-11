package com.java.mantoto.mould;

import java.util.ArrayList;
import java.util.List;

import com.java.base.ClassTemplate;
import com.java.base.ClassType;
import com.java.base.FieldTemplate;
import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;

public class CreateMantotoServiceImpl extends MantotoPragramBase implements  CreatePragramBase{
	
	public CreateMantotoServiceImpl(String tableName,String pack){
		super(JavaLogicClassType.SERVICEIMPL);
		super.tableName=tableName;
		super.pack=pack;
		
	}
	public ClassTemplate getFileContent() {
		// TODO Auto-generated method stub
		
		return null;
	}


}
