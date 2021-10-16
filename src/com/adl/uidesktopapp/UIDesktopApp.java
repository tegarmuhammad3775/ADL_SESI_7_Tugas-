package com.adl.uidesktopapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UIDesktopApp {

	private JFrame frame;
	private JTextField textField_nama;
	private JTextField textField_alamat;
	private JTextField textField_gaji;
	private JTextField textField_url;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIDesktopApp window = new UIDesktopApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UIDesktopApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_name = new JLabel("Nama");
		label_name.setBounds(34, 48, 49, 14);
		frame.getContentPane().add(label_name);
		
		JLabel label_alamat = new JLabel("Alamat");
		label_alamat.setBounds(34, 84, 49, 14);
		frame.getContentPane().add(label_alamat);
		
		JLabel label_gaji = new JLabel("Gaji");
		label_gaji.setBounds(34, 122, 49, 14);
		frame.getContentPane().add(label_gaji);
		
		JLabel label_url = new JLabel("URL");
		label_url.setBounds(34, 163, 49, 14);
		frame.getContentPane().add(label_url);
		
		textField_nama = new JTextField();
		textField_nama.setBounds(98, 45, 96, 20);
		frame.getContentPane().add(textField_nama);
		textField_nama.setColumns(10);
		
		textField_alamat = new JTextField();
		textField_alamat.setBounds(98, 81, 96, 20);
		frame.getContentPane().add(textField_alamat);
		textField_alamat.setColumns(10);
		
		textField_gaji = new JTextField();
		textField_gaji.setBounds(98, 119, 96, 20);
		frame.getContentPane().add(textField_gaji);
		textField_gaji.setColumns(10);
		
		textField_url = new JTextField();
		textField_url.setBounds(98, 160, 96, 20);
		frame.getContentPane().add(textField_url);
		textField_url.setColumns(10);
		
		JButton btnNewButton = new JButton("Simpan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					FileWriter file = new FileWriter(textField_url.getText(), true);
					file.write(textField_nama.getText()+";"+textField_alamat.getText()+";"+textField_gaji.getText()+"\n");
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame, "Data sudah tersimpan");
				textField_nama.setText("");
				textField_alamat.setText("");
				textField_gaji.setText("");
				textField_url.setText("");
			}
		});
		btnNewButton.setBounds(70, 209, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
