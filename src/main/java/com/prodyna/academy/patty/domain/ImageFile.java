package com.prodyna.academy.patty.domain;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class ImageFile extends File {
	private long height;
	private long width;
	
	ImageFile(String name, long size, long height, long width) {
		this.height = height; 
		this.width = width; 
		super.setName(name);
		super.setSize(size);
	}
	
	public long getHeight() {
		return height;
	}
	public void setHeight(long height) {
		this.height = height;
	}
	public long getWidth() {
		return width;
	}
	public void setWidth(long width) {
		this.width = width;
	}
}
