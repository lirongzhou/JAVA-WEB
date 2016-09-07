package com.java.mantoto.mould.emun;

public enum JavaLogicClassType {
   BEAN("",""),
   DAO("I","Dao"),
   DAOIMPL("","DaoImpl"),
   SERVICE("I","Service"),
   SERVICEIMPL("","ServiceImpl"),
   CONTORLLER("I","Contorller"),
   CONTORLLERIMPL("","Contorller"),
   OPENSERVICE("I","OpenService"),
   OPENSERVICEIMPL("","OpenServiceImpl"),
   CACHE("I","Cache"),
   CACHEIMPL("","CacheImpl");

	/**
	 * 前缀
	 */
	private String prefix="";
	/**
	 * 后缀
	 */
	private String suffix="";
	/**
	 * 默认继承类
	 */
	private String  extend="";
	
	JavaLogicClassType(String prefix,String suffix,String extend){
		this.prefix=prefix;
		this.suffix=suffix;
		this.extend=extend;
	}
	
	public  String createClassName(String className){
		 className=this.getPrefix()+className+this.getSuffix();
		 if(""!=extend)className+=this.getExtend();
		return className;
	}
	
	JavaLogicClassType(String prefix,String suffix ){
		this.prefix=prefix;
		this.suffix=suffix;
	}
    
	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getExtend() {
		return extend;
	}
	
	
}
