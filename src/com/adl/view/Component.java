package com.adl.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.adl.interfaces.ActionListener;
import com.adl.view.Component;
import java.awt.event.ActionEvent;


public class Component {

	public JFrame frame;
	private String name;
	private String label;
	private String jawaban;
	private int score;
	private List<Component> componentListener = new ArrayList<>();
	private JTextField textField;
	private JTextPane textPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Component  comp = new Component();
		comp.show();
	}

	/**
	 * Create the application.
	 */
	public Component() {
		
	}

	public Component(String nama, String label, String jawaban, int score) {
		this.name = nama;
		this.label = label;
		this.jawaban = jawaban;
		this.score = score;
		initialize(nama, label, jawaban, score);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Component window = new Component(name, label, jawaban, score);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void addActionListener (Component component){
		this.componentListener.add(component);
	}
	
	public void onAction(ActionListener action) {
		action.onAction(this.componentListener);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String input, String jawaban, int score) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Soal");
		lblNewLabel.setBounds(10, 11, 49, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 36, 405, 97);
		frame.getContentPane().add(textPane);
		
		textPane.setText(input);
		
		JLabel lblNewLabel_1 = new JLabel("Jawaban");
		lblNewLabel_1.setBounds(10, 157, 125, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 182, 405, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Kirim Jawaban");
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String jwb = textField.getText();
				if(jwb.equalsIgnoreCase(jawaban)){
					JOptionPane.showMessageDialog(frame, "Jawaban Benar! \nScore anda bertambah "+score+", jumlah jawaban benar bertambah 1");
				}
				else {
					JOptionPane.showMessageDialog(frame, "Jawaban Salah! jumlah jawaban salah bertambah 1");
				}
			}
		});
		btnNewButton.setBounds(252, 229, 163, 23);
		frame.getContentPane().add(btnNewButton);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}

}
