package com.prodyna.academy.patty.api.observer.event;

import com.prodyna.academy.patty.api.Node;

public class NodeEvent {

	private Node source;

	public NodeEvent(Node source) {
		this.source = source;
	}

	public Node getSource() {
		return source;
	}
}
