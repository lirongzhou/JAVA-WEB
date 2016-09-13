package com.java.main;

import java.util.List;

/**
 *  @author  作者 li rong zhou 创建时间:2016-09-12 04:05:33
 */
public interface IParameterGroupDao  {
	
        
	public int updateParameterGroup(ParameterGroup parameterGroup );
	
    
	public int selectCountParameterGroup(ParameterGroup parameterGroup );
	
    
	public List<ParameterGroup> selectParameterGroup(ParameterGroup parameterGroup );
	
    
	public int deleteParameterGroup(ParameterGroup parameterGroup );
	
    
	public ParameterGroup selectByIdParameterGroup(ParameterGroup parameterGroup );
	
    
	public int insertParameterGroup(ParameterGroup parameterGroup );
	
    
	public List<ParameterGroup> selectPagerParameterGroup(ParameterGroup parameterGroup );
	

}
