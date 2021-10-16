package com.adl.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MultipleChoiceComponent extends Component{

	private String name;
	private String label;
	private String jawaban;
    private int score;
	private String[] pilihan;
	
	
	/**
	 * Create the application.
	 */
	
	public MultipleChoiceComponent(String name, String pertanyaan, String[] pilihan, String jawaban, int score){
		super(name, pertanyaan, jawaban, score);
		this.name = name;
		this.label = pertanyaan;
		this.pilihan= pilihan;
		this.jawaban = jawaban;
		this.score = score;
		initialize(name, pertanyaan, pilihan, jawaban, score);	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String pertanyaan, String[] pilihan, String jawaban, int score) {
		frame = new JFrame();
		frame.setBounds(150, 150, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Soal");
		lblNewLabel.setBounds(10, 11, 49, 14);
		frame.getContentPane().add(lblNewLabel);
		
		StringBuilder sb = new StringBuilder();
		sb.append(pertanyaan + "<br>");
        for (int i = 0; i < pilihan.length ; i++) {
            sb.append(pilihan[i] + "<br>"); //<br> tag to insert line breaks
        }
        
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
		textPane.setEditable(false);
		textPane.setBounds(10, 36, 405, 97);
		frame.getContentPane().add(textPane);
		
		textPane.setText(sb.toString());
        
		
		JLabel lblNewLabel_1 = new JLabel("Jawaban");
		lblNewLabel_1.setBounds(10, 157, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(10, 182, 405, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Kirim Jawaban");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String jwb = textField.getText();
				if(jwb.equalsIgnoreCase(jawaban)){
					JOptionPane.showMessageDialog(frame, "Jawaban Benar! \n Score anda bertambah "+score+", jumlah jawaban benar bertambah 1");
				}
				else{
					JOptionPane.showMessageDialog(frame, "Jawaban Salah! jumlah jawaban salah bertambah 1");
				}
			}
		});
		btnNewButton.setBounds(289, 229, 126, 23);
		frame.getContentPane().add(btnNewButton);
	}
	
	@Override
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultipleChoiceComponent window = new MultipleChoiceComponent(name, label, pilihan, jawaban, score);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}
