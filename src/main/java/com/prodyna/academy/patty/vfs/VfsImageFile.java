package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.ImageFile;
import com.prodyna.academy.patty.api.visitor.NodeVisitor;

public class VfsImageFile extends VfsBinaryFile implements ImageFile {

	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
