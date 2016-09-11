package com.java.mantoto.mould;

import com.java.base.ClassTemplate;
import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;
import com.java.mantoto.mould.emun.NameaRule;

public class CreateMantotoOpenService extends MantotoPragramBase implements  CreatePragramBase{
	private Class beanClass;
	public CreateMantotoOpenService(String tableName,String pack,Class beanClass,NameaRule nameaRule){
		super(JavaLogicClassType.OPENSERVICE,nameaRule);
		super.tableName=tableName;
		super.pack=pack;
		this.beanClass=beanClass;
	}
	public ClassTemplate getFileContent() {
		// TODO Auto-generated method stub
		return null;
	}


}