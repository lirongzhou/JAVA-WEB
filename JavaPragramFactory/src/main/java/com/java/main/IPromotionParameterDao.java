package com.java.main;

import java.util.List;

/**
 *  @author  作者 li rong zhou 创建时间:2016-09-12 04:05:33
 */
public interface IPromotionParameterDao  {
	
        
	public int updatePromotionParameter(PromotionParameter promotionParameter );
	
    
	public int selectCountPromotionParameter(PromotionParameter promotionParameter );
	
    
	public List<PromotionParameter> selectPromotionParameter(PromotionParameter promotionParameter );
	
    
	public int deletePromotionParameter(PromotionParameter promotionParameter );
	
    
	public PromotionParameter selectByIdPromotionParameter(PromotionParameter promotionParameter );
	
    
	public int insertPromotionParameter(PromotionParameter promotionParameter );
	
    
	public List<PromotionParameter> selectPagerPromotionParameter(PromotionParameter promotionParameter );
	

}
