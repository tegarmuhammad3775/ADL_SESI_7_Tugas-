package com.adl.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ModelQuizFile extends ModelQuiz{
	private String url;
	
	public ModelQuizFile(String url){
		this.url = url;
		openFile(url);
	}
	
	public void openFile(String url){
		File file = new File(url);
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				this.addSoal(scan.nextLine());
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
