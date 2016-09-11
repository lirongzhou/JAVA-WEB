package com.java.mantoto.mould.base;

import com.java.base.ClassTemplate;
import com.java.base.ClassType;
import com.java.mantoto.mould.emun.JavaLogicClassType;
import com.java.mantoto.mould.emun.NameaRule;
/**
 * 
 * @author li rong zhou
 *
 */
public abstract class MantotoPragramBase {

	public static final String COMMENTS=""
			+ "\n/**"
			+ "\n*"
			+ "\n* @author li rong zhou"
			+ "\n* "
			+ "\n*/";
	protected String tableName;
	protected String pack;
	protected String className;
	protected  NameaRule nameaRule;
	protected JavaLogicClassType javaLogicClassType;
	protected ClassTemplate  classTemplate;
	
	protected  void initClass(){
		this.classTemplate.setClassType(ClassType.CLASS);
		this.classTemplate.setJavaName(getClassName());
		this.classTemplate.setPagckage(getPack());
		this.classTemplate.setComments(COMMENTS);
	}
	protected MantotoPragramBase(JavaLogicClassType javaLogicClassType){
		this.javaLogicClassType=javaLogicClassType;
		classTemplate=new ClassTemplate();
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
	public String getClassName() {
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
