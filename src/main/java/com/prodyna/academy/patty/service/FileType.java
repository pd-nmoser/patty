/**
 * 
 */
package com.prodyna.academy.patty.service;

/**
 * @author aheizenreder
 *
 */
enum FileType {
	TEXT("Text"),
	IMAGE("Image"),
	VIDEO("Video"),
	FOLDER("Folder");
	
	private String description;
	
	private FileType (String description){
		this.description = description;
	}
	
	public String toString(){
		return description;
	}
}
