package com.template.base;

/**
	* @author  作者 li rong zhou 
	* @date 创建时间：2016年9月1日 下午3:30:55 
	* 
	*  
	*/
public enum OrderStatus {
//	订单状态  -1已关闭  1未支付 2 已支付 3 已完成 
	/**
	 * 关闭状态
	 */
	CLOSE(-1,"关闭状态"),
	/**
	 * 未支付
	 */
	NOTPAY(1,"未支付"),
	/**
	 * 已支付
	 */
	PAID(2,"已支付"),
	/**
	 * 已完成
	 */
	COMPLETION(3,"已完成");
	
	private int id;
	private String value;
	
	OrderStatus(int id,String value){
		this.id=id;
		this.value=value;
	}
	
	public static  OrderStatus getOrderStatus(int id){
		OrderStatus[]enums= OrderStatus.values();
	    for(OrderStatus orderStatus:enums){
	    	if(orderStatus.getId()==id){
	    		return orderStatus;
	    	}
	    }
	    return null;
	}
	
	public int getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

}
