package com.java.mantoto.mould.emun;
	/**
	* @author  作者 li rong zhou 
	* @date 创建时间：2016年9月11日 下午3:51:27 
	* 
	*  
	*/
public enum Qualifier {
	/**
	 * 大写
	 */
	PUBLIC("public"),
	/**
	 * 小写
	 */
	PRIVATE("private"),
	/**
	 * 首字母大写
	 */
	PROTECTED("protected");
	

	private String name;
	Qualifier(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
}
