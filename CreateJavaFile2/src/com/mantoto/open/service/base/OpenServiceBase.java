package com.mantoto.open.service.base;

import com.mantoto.page.Pager;

/**
	* @author  作者 li rong zhou 
	* @date 创建时间：2016年7月25日 下午2:42:19 
	* 
	*  
	*/
public class OpenServiceBase {
	
	 protected void setPagerSelectCondition(Pager pager, String strJson) {
			pager.setSelectConditionJson(strJson.replaceAll("\\{", "").replaceAll("\\}", ""));
			pager.setSelectConditionGet(getSelectConditionGet(strJson.replaceAll("\"", "").replaceAll("\\,", "&").replaceAll("\\:", "=").replaceAll("\\{", "").replaceAll("\\}", "")));
		}
	    
	    private String getSelectConditionGet(String strJson){
	    	String [] strs= strJson.split("&");
	      	
	    	StringBuffer strGetBuffer=new StringBuffer();
	    	for(String str:strs){
	    		if(!str.trim().contains("=null")){
	    			strGetBuffer.append(str+"&");
	    		}
	    		
	    	}
	    	if(strGetBuffer.length()>1){
	    		strGetBuffer.delete(strGetBuffer.length()-1, strGetBuffer.length());
	        	System.out.println(strGetBuffer);

	    	}
	    	return strGetBuffer.toString();
	    }
	    
	    protected boolean isNull(Object o) {
			return null == o || "" == o || "".equals(o) ? true : false;
		}
}
