package com.prodyna.academy.patty.domain;

public class TextFile extends File {
	private String textEncoding;
	private long pageCount;
	
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
