package com.java.mantoto.mould.emun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
	* @author  作者 li rong zhou 
	* @date 创建时间：2016年9月12日 上午11:08:51 
	* 
	*  
	*/
public enum MethodNameRule {
    ONE,TWO;
	
	public static List<String> getEnumValues(MethodNameRule methodNameRule ){
		List<String> enumValues=new ArrayList<String>();
		switch(methodNameRule){
		case ONE:
			for(StyleOne styleOne:StyleOne.values()){
				enumValues.add(styleOne.getName());
			}
			
			break;
		case TWO:
			for(StyleTwo styleTwo:StyleTwo.values()){
				enumValues.add(styleTwo.getName());
			}
			
			break;
		}
		return enumValues;
	}
	
	
	public static Map<String,String> getEnumValues(MethodNameRule methodNameRule,JavaLogicClassType javaLogicClassType,String beanName){
		Map<String,String>  enumValues=new HashMap<String,String> ();
		switch(methodNameRule){
		case ONE:
			for(StyleOne styleOne:StyleOne.values()){
				enumValues.put(styleOne.getName(),"");
				switch(javaLogicClassType){
				case DAO:
					switch(styleOne){
					case DELETE:
					case INSERT:
					case UPDATE:
					case SELECTCOUNT:
						enumValues.put(styleOne.getName(),"int");
						break;
					case SLECTPAGER:
					case SELECT:
						enumValues.put(styleOne.getName(),"List<"+beanName+">");
						break;
					case SELECTBYID:
						enumValues.put(styleOne.getName(),beanName);
						break;
					}
					break;
				case SERVICE:
				case OPENSERVICE:
				case CACHE:
					switch(styleOne){
					case DELETE:
					case UPDATE:
						enumValues.put(styleOne.getName(),"boolean");
						break;
					case INSERT:
					case SELECTCOUNT:
						enumValues.put(styleOne.getName(),"int");
						break;
					case SLECTPAGER:
						enumValues.put(styleOne.getName(),"Pager");
						break;
					case SELECT:
						enumValues.put(styleOne.getName(),"List<"+beanName+">");
						break;
					case SELECTBYID:
						enumValues.put(styleOne.getName(),beanName);
						break;
					}
					break;
				case CONTORLLER:
					
					break;
				}
				
			}
			break;
		case TWO:
			for(StyleTwo styleTwo:StyleTwo.values()){
				
				switch(javaLogicClassType){
				case DAO:
					switch(styleTwo){
					case ADD:
					case REMOVE:
					case UPDATE:
					case FINDCOUNT:
						enumValues.put(styleTwo.getName(),"int");
						break;
					case FINDPAGER:
					case FIND:
						enumValues.put(styleTwo.getName(),"List<"+beanName+">");
						break;
					case FINDEBYID:
						enumValues.put(styleTwo.getName(),beanName);
						break;
					}
					break;
				case CACHE:
				case SERVICE:
				case OPENSERVICE:
					switch(styleTwo){
					case REMOVE:
					case UPDATE:
						enumValues.put(styleTwo.getName(),"boolean");
						break;
					case ADD:
					case FINDCOUNT:
						enumValues.put(styleTwo.getName(),"int");
						break;
					case FINDPAGER:
						enumValues.put(styleTwo.getName(),"Pager");
						break;
					case FIND:
						enumValues.put(styleTwo.getName(),"List<"+beanName+">");
						break;
					case FINDEBYID:
						enumValues.put(styleTwo.getName(),beanName);
						break;
					}
					break;
				case CONTORLLER:
					break;
				}
			}
			break;
		}
		return enumValues;
	}
	private    enum StyleOne{
		SELECTCOUNT("selectCount"),SELECT("select"),SELECTBYID("selectById"),
		SLECTPAGER("selectPager"),DELETE("delete"),UPDATE("update"),INSERT("insert");
		private String name;
		StyleOne(String name){
			this.name=name;
		}
		public String getName(){
			return name;
		}
	}
	
	private    enum StyleTwo{
		
    	FIND("find"),FINDCOUNT("findCount"),FINDEBYID("findById"),FINDPAGER("findPager"),
    	REMOVE("Remove"),ADD("add"),UPDATE("update");
		private String name; 
		StyleTwo(String name){
			this.name=name;
    	}
		public String getName(){
			return name;
		}
    }
	
}
