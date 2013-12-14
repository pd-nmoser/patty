package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.VideoFile;
import com.prodyna.academy.patty.vfs.visitor.VfsVisitor;

public class VfsVideoFile extends VfsBinaryFile implements VideoFile {

	public void accept(VfsVisitor visitor) {
		visitor.visit(this);
	}

}
