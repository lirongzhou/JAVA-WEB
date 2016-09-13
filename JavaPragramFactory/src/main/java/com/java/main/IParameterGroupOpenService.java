package com.java.main;

import java.util.List;

/**
 *  @author  作者 li rong zhou 创建时间:2016-09-12 04:05:33
 */
public interface IParameterGroupOpenService  {
	
        
	public boolean updateParameterGroup(ParameterGroup parameterGroup );
	
    
	public int selectCountParameterGroup(ParameterGroup parameterGroup );
	
    
	public List<ParameterGroup> selectParameterGroup(ParameterGroup parameterGroup );
	
    
	public boolean deleteParameterGroup(ParameterGroup parameterGroup );
	
    
	public ParameterGroup selectByIdParameterGroup(ParameterGroup parameterGroup );
	
    
	public int insertParameterGroup(ParameterGroup parameterGroup );
	
    
	public Pager selectPagerParameterGroup(ParameterGroup parameterGroup );
	

}
