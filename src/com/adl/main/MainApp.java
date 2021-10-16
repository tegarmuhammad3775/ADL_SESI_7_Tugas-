package com.adl.main;

import java.awt.EventQueue;
import javax.swing.JFrame;

import com.adl.controller.QuizController;
import com.adl.model.ModelQuizFile;
import com.adl.view.Component;

public class MainApp {
	
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ModelQuizFile model = new ModelQuizFile("D:/soal0.txt");
		QuizController quiz = new QuizController(model);
		quiz.showForm();
		//quiz.generateNilai();
		
		
		
	}
}
