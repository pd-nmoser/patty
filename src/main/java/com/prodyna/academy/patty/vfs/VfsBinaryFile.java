package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.visitor.NodeVisitor;

public abstract class VfsBinaryFile extends VfsFile {

	private byte[] content;

	public byte[] getContent() {
		return content;
	}

	@Override
	public int getSize() {
		return content.length;
	}

	void setContent(byte[] content) {
		this.content = content;

		oberverSupport.fireChangeEvent(this);
	}

	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
