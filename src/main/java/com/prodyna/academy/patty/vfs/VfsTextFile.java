package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.TextFile;
import com.prodyna.academy.patty.vfs.visitor.VfsVisitor;

public class VfsTextFile extends VfsFile implements TextFile {

	private String content;

	private String charset = "UTF-8";

	VfsTextFile() {
	}

	@Override
	public int getSize() {
		return content.getBytes().length;
	}

	public String getContent() {
		return content;
	}

	public int getPageCount() {
		return 1;
	}

	public String getEncoding() {
		return charset.toString();
	}

	void setContent(String content, String charset) {
		this.content = content;
		this.charset = charset;
	}

	public void setContent(String content) {
		this.content = content;
		this.charset = "UTF-8";
	}

	public void accept(VfsVisitor visitor) {
		visitor.visit(this);
	}

}
