package com.java.main;

import java.util.List;

/**
 *  @author  作者 li rong zhou 创建时间:2016-09-12 04:05:33
 */
public interface IParameterProductService  {
	
        
	public boolean updateParameterProduct(ParameterProduct parameterProduct );
	
    
	public int selectCountParameterProduct(ParameterProduct parameterProduct );
	
    
	public List<ParameterProduct> selectParameterProduct(ParameterProduct parameterProduct );
	
    
	public boolean deleteParameterProduct(ParameterProduct parameterProduct );
	
    
	public ParameterProduct selectByIdParameterProduct(ParameterProduct parameterProduct );
	
    
	public int insertParameterProduct(ParameterProduct parameterProduct );
	
    
	public Pager selectPagerParameterProduct(ParameterProduct parameterProduct );
	

}
