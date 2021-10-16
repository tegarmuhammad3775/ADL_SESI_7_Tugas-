package com.adl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import com.adl.model.ModelQuiz;
import com.adl.view.Component;
import com.adl.view.ContentComponent;
import com.adl.view.Form;
import com.adl.view.MultipleChoiceComponent;

public class QuizController {
	ModelQuiz model;
	List<Form> listForm = new ArrayList<Form>();
	private int benar = 0;
	private int salah = 0;
	
	public QuizController(ModelQuiz model) {
		this.model = model;
		generateForm(model);
	}
	
	public void generateForm(ModelQuiz model){
		for (String modelData : model.getListsoal()) {
			Form form = new Form();
			String soal[] = modelData.split(";");
			String jawaban = "";
			int score = 0;
			
			switch (soal[0]) {
			case "essay":
				jawaban = soal[2];
				score = Integer.parseInt(soal[3]);
				Component content = new Component("",soal[1], jawaban, score);
				form.addComponent(content);
				break;
			case "multiplechoice": 
				jawaban = soal[3];
				score = Integer.parseInt(soal[4]);
				MultipleChoiceComponent choice = new MultipleChoiceComponent("", soal[1], soal[2].split("#"), jawaban, score);
				form.addComponent(choice);
				break;
			default:
				break;
			}
			this.listForm.add(form);
		}
	}	


	public int hitungNilai(String jawaban, String kunciJawaban, int score){
		int nilai = 0;
		if(jawaban.equalsIgnoreCase(kunciJawaban)){
			nilai += score;
			this.benar++;
		}
		else {
			this.salah++;
		}
		
		return nilai;
    }
	
	public void showForm(){
		for (Form form : listForm) {
			form.showComponents();
		}
	}
	
}	
