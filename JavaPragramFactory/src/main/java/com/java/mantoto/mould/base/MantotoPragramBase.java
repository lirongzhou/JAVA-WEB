package com.java.mantoto.mould.base;

import com.java.base.ClassTemplate;
import com.java.base.ClassType;
import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;
import com.java.mantoto.mould.emun.NameaRule;
import com.mytools.connection.SourceData;
/**
 * 
 * @author li rong zhou
 *
 */
public abstract class MantotoPragramBase implements  CreatePragramBase{

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
	public static SourceData sourceData;
	protected StringBuffer importStr=new StringBuffer();
	static{
		
		  sourceData=new SourceData();
		
	}
	protected  void initClass(){
		classTemplate.setClassType(ClassType.CLASS);
	    classTemplate.setJavaName(getClassName());
		classTemplate.setPagckage(getPack());
		classTemplate.setComments(COMMENTS);
	}
	protected MantotoPragramBase(JavaLogicClassType javaLogicClassType,NameaRule nameaRule){
		this.javaLogicClassType=javaLogicClassType;
		classTemplate=new ClassTemplate();
		this.nameaRule=nameaRule;

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
