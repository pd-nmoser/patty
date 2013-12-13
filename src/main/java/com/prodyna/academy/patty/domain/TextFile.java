package com.prodyna.academy.patty.domain;

import com.prodyna.academy.patty.service.Visitor;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class TextFile extends File {
	private String textEncoding;
	private long pageCount;

	TextFile(final String name, final long size, final String textEncoding,
			final long pageCount) {
		this.textEncoding = textEncoding;
		this.pageCount = pageCount;
		super.setName(name);
		super.setSize(size);
	}

	public String getTextEncoding() {
		return textEncoding;
	}

	void setTextEncoding(final String textEncoding) {
		this.textEncoding = textEncoding;
	}

	public long getPageCount() {
		return pageCount;
	}

	void setPageCount(final long pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}
}