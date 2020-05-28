package com.property.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.property.utils.Validator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public LoginForm() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new Validator().closeWindow(e);
			}
		});
		setBounds(100, 100, 588, 425);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 570, 386);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(164, 76, 239, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUserName = new JLabel("USERNAME");
		lblUserName.setBounds(164, 39, 106, 26);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(164, 135, 106, 26);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 172, 239, 35);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginBtnClicked(e);
			}
		});
		btnLogin.setForeground(new Color(248, 248, 255));
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setBounds(189, 244, 189, 45);
		panel.add(btnLogin);
	}
	
	private void loginBtnClicked(ActionEvent e) {
		Validator v = new Validator();
		String userName = textField.getText();
		String password = new String(passwordField.getPassword());
		String result = v.validateLogin(userName, password);
		 
		if(result != "") {
			if (result.equals("admin")) {
				AdminFrame af = new AdminFrame();
				af.setVisible(true);
				af.setResizable(false);
				af.setLocationRelativeTo(null);
				this.dispose();
			} else {
				BranchFrame bf = new BranchFrame(result);
				bf.setVisible(true);
				bf.setResizable(false);
				bf.setLocationRelativeTo(null);
				bf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.dispose();
			}
			
		}
		
	}
	


	
}
