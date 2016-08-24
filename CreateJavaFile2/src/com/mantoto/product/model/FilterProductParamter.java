
package com.mantoto.product.model;

/**
 * @author Li
 * @version 1.0
 *  @created 21-八月-2016 下午 1:46:08
 */
public enum FilterProductParamter {
	
	PRODUCTTYPE("ProductTypeId",DataType.INT),
	KEYWORDS("KeyWords",DataType.STING),
	ISFOREXPRESS("IsForExpress",DataType.BOOLEAN),
	PROFUCTNAME("ProductName",DataType.STING),
	SALEAS("SaleAs",DataType.INT),
	BUSINESSID("BusinessId",DataType.LONG),
	STATUS("Status",DataType.INT),
	PRICE("Price",DataType.DOUBLE);

	private String columName;
	private  DataType dataType;
	/**
	 * 
	 * @param columName
	 * @param dataType    dataType
	 */
	FilterProductParamter(String columName, DataType dataType){
		this.columName=columName;
		this.dataType=dataType;
	}

	public String getColumName() {
		return columName;
	}

	public DataType getDataType() {
		return dataType;
	}

}