package com.java.mantoto.mould.base;

import java.util.Map;

import com.java.mantoto.mould.emun.JavaLogicClassType;
import com.java.mantoto.mould.emun.NameaRule;

public abstract class MantotoPragramBase {

	protected String tableName;
	protected String pack;
	protected String calssName;
	protected  NameaRule nameaRule;
	protected JavaLogicClassType javaLogicClassType;
	
	protected MantotoPragramBase(JavaLogicClassType javaLogicClassType){
		this.javaLogicClassType=javaLogicClassType;
	}
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getCalssName() {
		return javaLogicClassType.createClassName(nameaRule.createClassName(tableName));
	}
	
	public NameaRule getNameaRule() {
		return nameaRule;
	}
	public void setNameaRule(NameaRule nameaRule) {
		this.nameaRule = nameaRule;
	}
	public JavaLogicClassType getJavaLogicClassType() {
		return javaLogicClassType;
	}
	public void setJavaLogicClassType(JavaLogicClassType javaLogicClassType) {
		this.javaLogicClassType = javaLogicClassType;
	}
	
	
	
}
