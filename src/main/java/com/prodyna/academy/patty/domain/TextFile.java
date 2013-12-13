package com.prodyna.academy.patty.domain;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class TextFile extends File {
	private String textEncoding;
	private long pageCount;
	
	TextFile(String name, long size, String textEncoding, long pageCount) {
		this.textEncoding = textEncoding;
		this.pageCount = pageCount;
		super.setName(name);
		super.setSize(size);
	}
	
	public String getTextEncoding() {
		return textEncoding;
	}
	public void setTextEncoding(String textEncoding) {
		this.textEncoding = textEncoding;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
}
