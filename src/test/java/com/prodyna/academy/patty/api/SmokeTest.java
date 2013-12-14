package com.prodyna.academy.patty.api;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmokeTest extends AbstractTest {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testFileSystem() {
		FileManager manager = FileManager.getInstance();
		Folder root = manager.getFileSystem().getRoot();
		Assert.assertEquals("", root.getName());
		manager.getFileSystem().rename(root, "rooty");
		Assert.assertEquals("rooty", root.getName());
		Folder lorem = manager.getFileFactory().createFolder("lorem");
		Folder ipsum = manager.getFileFactory().createFolder("ipsum");
		TextFile t1 = manager.getFileFactory().createTextFile("lorem1.txt", getSampleText());
		TextFile t2 = manager.getFileFactory().createTextFile("lorem2.txt", getSampleText());
		TextFile t3 = manager.getFileFactory().createTextFile("lorem3.txt", getSampleText());
		TextFile t4 = manager.getFileFactory().createTextFile("lorem4.txt", getSampleText());
		TextFile t5 = manager.getFileFactory().createTextFile("lorem5.txt", getSampleText());
		manager.getFileSystem().add(lorem, t1);
		manager.getFileSystem().add(lorem, t2);
		manager.getFileSystem().add(lorem, t3);
		manager.getFileSystem().add(lorem, t4);
		manager.getFileSystem().add(lorem, t5);
		manager.getFileSystem().add(root, lorem);
		Assert.assertEquals(2955, root.getSize());
		log.info(root.getName() + "[" + root.getSize() + "]");
		log.info("Files below 'lorem':");
		for (Node node : lorem.list()) {
			log.info(node.getName() + "[" + node.getSize() + "]");
		}
		manager.getFileSystem().move(t5, ipsum);
		Assert.assertEquals(2955 - 591, lorem.getSize());
		Assert.assertEquals(591, ipsum.getSize());
	}
}
