package com.prodyna.academy.patty.api.observer;

import com.prodyna.academy.patty.api.observer.event.NodeRenameEvent;

public interface NodeRenameListener extends NodeObserver {

	void nodeRenamed(NodeRenameEvent event);
	
}
