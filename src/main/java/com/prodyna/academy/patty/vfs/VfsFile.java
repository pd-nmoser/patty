package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.vfs.visitor.VfsVisitor;

public abstract class VfsFile extends VfsNode {
	
	public void accept(VfsVisitor visitor) {
		visitor.visit(this);
	}

}
