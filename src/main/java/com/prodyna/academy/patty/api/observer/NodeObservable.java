package com.prodyna.academy.patty.api.observer;

public interface NodeObservable {

	void registerListener(NodeObserver listener);

	void unregisterListener(NodeObserver listener);

}
