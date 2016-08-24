package com.mantoto.product.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mantoto.annotation.ValidateAnnotaion;
import com.mantoto.annotation.ValidateAnnotaion.CanUpdate;
import com.mantoto.annotation.ValidateAnnotaion.IsId;
import com.mantoto.base.bean.BeanBase;
import com.mantoto.product.jsonView.ProductView;

public class Media extends BeanBase {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String figurePath;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String description;

	@JsonView(ProductView.class)
	@ValidateAnnotaion(canUpdate = CanUpdate.FALSE)
	private long bId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String isFrontCover;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private int height;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private int width;

	@JsonView(ProductView.class)
	@ValidateAnnotaion(isId = IsId.TRUE)
	private long mId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private int mediaTypeId;

	@JsonView(ProductView.class)
	@ValidateAnnotaion
	private String path;

	public String getFigurePath() {
		return figurePath;
	}

	public void setFigurePath(String figurePath) {
		this.figurePath = figurePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getbId() {
		return bId;
	}

	public void setbId(long bId) {
		this.bId = bId;
	}

	public String getIsFrontCover() {
		return isFrontCover;
	}

	public void setIsFrontCover(String isFrontCover) {
		this.isFrontCover = isFrontCover;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public long getmId() {
		return mId;
	}

	public void setmId(long mId) {
		this.mId = mId;
	}

	public int getMediaTypeId() {
		return mediaTypeId;
	}

	public void setMediaTypeId(int mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}