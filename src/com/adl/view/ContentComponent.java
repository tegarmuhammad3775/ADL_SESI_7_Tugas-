package com.adl.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContentComponent extends Component {

	private JFrame frame;
	private JTextField textField;
	private JTextPane textPane;
	private String nama;
	private String label;

	public ContentComponent() {
		super();
		initialize();
	}

	public ContentComponent(String nama, String label, String jawaban, int score) {
		super(nama, label, jawaban, score);
		this.nama = nama;
		this.label = label;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContentComponent window = new ContentComponent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(33, 28, 374, 95);
		textPane.setText(label);
		frame.getContentPane().add(textPane);
		
		

		textField = new JTextField();
		textField.setBounds(33, 166, 374, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Jawaban");
		lblNewLabel.setBounds(33, 144, 68, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Soal");
		lblNewLabel_1.setBounds(33, 11, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JButton nextEssay = new JButton("Kirim Jawaban");
		nextEssay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		nextEssay.setBounds(252, 229, 155, 23);
		frame.getContentPane().add(nextEssay);
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
