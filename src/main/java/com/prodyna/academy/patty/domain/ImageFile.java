package com.prodyna.academy.patty.domain;

import com.prodyna.academy.patty.service.Visitor;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class ImageFile extends File {
	private long height;
	private long width;

	ImageFile(final String name, final long size, final long height,
			final long width) {
		this.height = height;
		this.width = width;
		super.setName(name);
		super.setSize(size);
	}

	public long getHeight() {
		return height;
	}

	void setHeight(final long height) {
		this.height = height;
	}

	public long getWidth() {
		return width;
	}

	void setWidth(final long width) {
		this.width = width;
	}

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}
}