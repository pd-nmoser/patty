package com.prodyna.academy.patty.api.observer;

import com.prodyna.academy.patty.api.observer.event.NodeChangeEvent;

public interface NodeChangeListener extends NodeObserver {

	void nodeChange(NodeChangeEvent event);

}
