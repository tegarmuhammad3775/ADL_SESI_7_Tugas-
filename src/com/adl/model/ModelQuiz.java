package com.adl.model;
import java.util.ArrayList;
import java.util.List;

public class ModelQuiz {
	
	List<String> listsoal = new ArrayList<>();
	
	
	//untuk menambahkan soal ke dalam list soal
	public void addSoal(String soal){
		this.listsoal.add(soal);
	}
	
	//mendapatkan soal
	public List<String> getListsoal() {
		return listsoal;
	}
	
	//mengubah soal
	public void setListsoal(List<String> listsoal) {
		this.listsoal = listsoal;
	}
		
			
		

}
