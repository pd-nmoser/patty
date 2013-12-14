package com.prodyna.academy.patty.api.observer.event;

import com.prodyna.academy.patty.api.Node;

public class NodeRenameEvent extends NodeChangeEvent {

	private String oldName;
	private String newName;

	public NodeRenameEvent(Node source, String oldName, String newName) {
		super(source);

		this.oldName = oldName;
		this.newName = newName;
	}

	public String getOldName() {
		return oldName;
	}

	public String getNewName() {
		return newName;
	}
}
