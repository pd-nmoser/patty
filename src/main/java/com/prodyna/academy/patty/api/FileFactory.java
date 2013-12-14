package com.prodyna.academy.patty.api;

public interface FileFactory {

	TextFile createTextFile(String name, String content);

	ImageFile createImageFile(String name, byte[] content);

	VideoFile createVideoFile(String name, byte[] content);

	Folder createFolder(String name);

}
