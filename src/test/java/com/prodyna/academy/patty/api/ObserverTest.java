package com.prodyna.academy.patty.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.prodyna.academy.patty.api.observer.NodeChangeListener;
import com.prodyna.academy.patty.api.observer.NodeRenameListener;
import com.prodyna.academy.patty.api.observer.event.NodeChangeEvent;
import com.prodyna.academy.patty.api.observer.event.NodeRenameEvent;

public class ObserverTest extends AbstractTest {

	private FileManager manager;

	private Folder root;

	@Before
	public void setUp() {
		manager = FileManager.getInstance();
		root = manager.getFileSystem().getRoot();
	}

	@Test
	public void observe() throws Exception {

		SampleChangeListener changeListener = new SampleChangeListener();
		manager.registerListener(changeListener);

		Folder foo = manager.getFileFactory().createFolder("foo");
		manager.getFileSystem().add(root, foo);

		Folder bar = manager.getFileFactory().createFolder("bar1");
		manager.getFileSystem().add(foo, bar);

		Folder bar2 = manager.getFileFactory().createFolder("bar2");
		manager.getFileSystem().add(foo, bar2);

		TextFile text = manager.getFileFactory().createTextFile("lorem5.txt", getSampleText());
		manager.getFileSystem().add(bar, text);

		SampleRenameListener renameListener = new SampleRenameListener();
		manager.registerListener(renameListener);
		manager.getFileSystem().rename(text, "blub.txt");
		Assert.assertEquals(1, renameListener.count);

		manager.getFileSystem().move(text, bar2);
		manager.getFileSystem().delete(text);

		Assert.assertEquals(6, changeListener.count);
	}

	private class SampleRenameListener implements NodeRenameListener {

		private int count;

		@Override
		public void nodeRenamed(NodeRenameEvent event) {
			System.out.print("Renamed: " + event.getSource());
			System.out.print(" --> Old Name: " + event.getOldName());
			System.out.println(" | New Name: " + event.getNewName());

			count++;
		}

	}

	private class SampleChangeListener implements NodeChangeListener {

		private int count;

		@Override
		public void nodeChange(NodeChangeEvent event) {
			System.out.print("Changed: " + event.getSource());
			System.out.println(" --> Type: " + event.getType());

			count++;
		}

	}

}
