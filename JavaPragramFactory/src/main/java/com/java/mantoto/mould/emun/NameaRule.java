package com.java.mantoto.mould.emun;

public enum NameaRule {
	/**
	 * 大写
	 */
	UPPER(2),
	/**
	 * 小写
	 */
	LOWER(4),
	/**
	 * 首字母大写
	 */
	INITIALUPPER(8),INITIALLOWER(16);
	

	private int id;
	NameaRule(int id){
		this.id=id;
	}
	public  String createClassName(String className){
		switch (this) {
		case UPPER:
			return className.toUpperCase();
			
       case LOWER:
			
    	   return className.toLowerCase();
       case INITIALUPPER:
    	  char [] chars= className.toCharArray();
    	  if(chars.length>=1)chars[0]= Character.toUpperCase(chars[0]);
    	  return new String(chars);
       case INITIALLOWER:
    	   char [] charsL= className.toCharArray();
     	  if(charsL.length>=1)charsL[0]= Character.toLowerCase(charsL[0]);
     	  return new String(charsL);
		}
		return className;
	}
}
