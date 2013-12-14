package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.ImageFile;
import com.prodyna.academy.patty.vfs.visitor.VfsVisitor;

public class VfsImageFile extends VfsBinaryFile implements ImageFile {
	
	public void accept(VfsVisitor visitor) {
		visitor.visit(this);
	}
	
}
