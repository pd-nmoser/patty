package com.prodyna.academy.patty.api.observer.event;

import com.prodyna.academy.patty.api.Node;

public class NodeChangeEvent extends NodeEvent {

	private NodeChangeType type;

	public NodeChangeEvent(Node source, NodeChangeType type) {
		super(source);

		this.type = type;
	}

	public NodeChangeType getType() {
		return type;
	}
}
