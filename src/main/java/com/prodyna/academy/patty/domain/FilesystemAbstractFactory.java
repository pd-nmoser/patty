package com.prodyna.academy.patty.domain;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class FilesystemAbstractFactory {
	
	public Folder createFolder(String name) {
		return new Folder(name);
	}
	
	public ImageFile createImageFile(String name, long size, long height, long width) {
		return new ImageFile(name, size, height, width);
	}
	
	public TextFile createTextFile(String name, long size, String textEncoding, long pageCount) {
		return new TextFile(name, size, textEncoding, pageCount);
	}
	
	public VideoFile createVideoFile(String name, long size, long height, long width) {
		return new VideoFile(name,size,height,width);
	}
}
