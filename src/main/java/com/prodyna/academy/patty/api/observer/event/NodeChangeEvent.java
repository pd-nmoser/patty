package com.prodyna.academy.patty.api.observer.event;

import com.prodyna.academy.patty.api.Node;

public class NodeChangeEvent {

	private Node source;

	public NodeChangeEvent(Node source) {
		this.source = source;
	}

	public Node getSource() {
		return source;
	}

}
