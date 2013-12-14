package com.prodyna.academy.patty.api.observer;

import java.util.HashSet;
import java.util.Set;

import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.observer.event.NodeChangeEvent;
import com.prodyna.academy.patty.api.observer.event.NodeChangeType;
import com.prodyna.academy.patty.api.observer.event.NodeRenameEvent;

public final class OberverSupport {

	private Set<NodeObserver> listenerSet = new HashSet<NodeObserver>();

	public void addListener(NodeObserver listener) {
		this.listenerSet.add(listener);
	}

	public void removeListener(NodeObserver listener) {
		this.listenerSet.remove(listener);
	}

	public void fireChangeEvent(Node source, NodeChangeType type) {
		fireChangeEventInternal(new NodeChangeEvent(source, type));
	}

	public void fireChangeEvent(NodeChangeEvent event) {
		fireChangeEventInternal(event);
	}

	private void fireChangeEventInternal(NodeChangeEvent event) {
		for (NodeObserver listener : listenerSet) {
			if (listener instanceof NodeChangeListener) {
				((NodeChangeListener) listener).nodeChange(event);
			}
		}
	}

	public void fireRenameEvent(Node source, String oldName, String newName) {
		fireRenameEventInternal(new NodeRenameEvent(source, oldName, newName));
	}

	public void fireRenameEvent(NodeRenameEvent event) {
		fireRenameEventInternal(event);
	}

	private void fireRenameEventInternal(NodeRenameEvent event) {
		for (NodeObserver listener : listenerSet) {
			if (listener instanceof NodeRenameListener) {
				((NodeRenameListener) listener).nodeRenamed(event);
			}
		}
	}

}
