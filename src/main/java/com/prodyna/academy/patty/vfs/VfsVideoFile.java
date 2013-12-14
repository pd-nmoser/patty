package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.VideoFile;
import com.prodyna.academy.patty.api.visitor.NodeVisitor;

public class VfsVideoFile extends VfsBinaryFile implements VideoFile {

	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
