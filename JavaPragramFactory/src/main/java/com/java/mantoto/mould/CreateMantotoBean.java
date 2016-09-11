package com.java.mantoto.mould;

import java.util.ArrayList;
import java.util.List;

import com.java.base.ClassTemplate;
import com.java.base.FieldTemplate;
import com.java.base.IMethodTemplate;
import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;

public class CreateMantotoBean extends MantotoPragramBase implements  CreatePragramBase{
	
	public CreateMantotoBean(String tableName,String pack){
		super(JavaLogicClassType.BEAN);
		super.tableName=tableName;
		super.pack=pack;
		initClass();
	}
	
	public ClassTemplate getFileContent() {
		// TODO Auto-generated method stub
		
		List<FieldTemplate> fields=new ArrayList<FieldTemplate>();
		this.classTemplate.setFields(fields);
		
		List<IMethodTemplate> methods=new ArrayList<IMethodTemplate>();
		this.classTemplate.setMethods(methods);
		
		return this.classTemplate;
	}


}
