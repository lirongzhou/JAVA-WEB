package com.java.main;

import java.util.List;

/**
 *  @author  作者 li rong zhou 创建时间:2016-09-12 04:05:33
 */
public interface IParameterDao  {
	
        
	public int updateParameter(Parameter parameter );
	
    
	public int selectCountParameter(Parameter parameter );
	
    
	public List<Parameter> selectParameter(Parameter parameter );
	
    
	public int deleteParameter(Parameter parameter );
	
    
	public Parameter selectByIdParameter(Parameter parameter );
	
    
	public int insertParameter(Parameter parameter );
	
    
	public List<Parameter> selectPagerParameter(Parameter parameter );
	

}
