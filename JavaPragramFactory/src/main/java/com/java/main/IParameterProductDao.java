package com.java.main;

import java.util.List;

/**
 *  @author  作者 li rong zhou 创建时间:2016-09-12 04:05:33
 */
public interface IParameterProductDao  {
	
        
	public int updateParameterProduct(ParameterProduct parameterProduct );
	
    
	public int selectCountParameterProduct(ParameterProduct parameterProduct );
	
    
	public List<ParameterProduct> selectParameterProduct(ParameterProduct parameterProduct );
	
    
	public int deleteParameterProduct(ParameterProduct parameterProduct );
	
    
	public ParameterProduct selectByIdParameterProduct(ParameterProduct parameterProduct );
	
    
	public int insertParameterProduct(ParameterProduct parameterProduct );
	
    
	public List<ParameterProduct> selectPagerParameterProduct(ParameterProduct parameterProduct );
	

}
