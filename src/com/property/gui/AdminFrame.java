package com.property.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.property.model.Branch;
import com.property.service.BranchService;
import com.property.utils.Validator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField phoneNo;
	private JTextField address;
	private JTextField email;
	private JTextField username;
	private JTextField webAddress;
	private JPasswordField password;
	private JPasswordField rePassword;
	
	private JPanel formPanel;
	private JPanel tablePanel;
	
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane js;

	public AdminFrame() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new Validator().closeWindow(e);
			}
		});
		setBounds(100, 100, 937, 826);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		formPanel = new JPanel();
		formPanel.setBackground(new Color(192, 192, 192));
		formPanel.setBounds(0, 368, 921, 419);
		contentPane.add(formPanel);
		formPanel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(47, 11, 104, 30);
		formPanel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(47, 100, 104, 30);
		formPanel.add(lblAddress);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(47, 189, 104, 30);
		formPanel.add(lblUsername);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setForeground(Color.WHITE);
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhoneNo.setBounds(302, 11, 104, 30);
		formPanel.add(lblPhoneNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(302, 100, 104, 30);
		formPanel.add(lblEmail);
		
		JLabel lblWebAddress = new JLabel("Web Address");
		lblWebAddress.setForeground(Color.WHITE);
		lblWebAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWebAddress.setBounds(302, 189, 104, 30);
		formPanel.add(lblWebAddress);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(47, 277, 104, 30);
		formPanel.add(lblPassword);
		
		JLabel lblRePassword = new JLabel("Re Password");
		lblRePassword.setForeground(Color.WHITE);
		lblRePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRePassword.setBounds(302, 277, 104, 30);
		formPanel.add(lblRePassword);
		
		name = new JTextField();
		name.setBounds(47, 52, 178, 30);
		formPanel.add(name);
		name.setColumns(10);
		
		phoneNo = new JTextField();
		phoneNo.setColumns(10);
		phoneNo.setBounds(297, 52, 178, 30);
		formPanel.add(phoneNo);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(47, 139, 178, 30);
		formPanel.add(address);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(297, 141, 178, 30);
		formPanel.add(email);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(47, 236, 178, 30);
		formPanel.add(username);
		
		webAddress = new JTextField();
		webAddress.setColumns(10);
		webAddress.setBounds(302, 230, 178, 30);
		formPanel.add(webAddress);
		
		password = new JPasswordField();
		password.setBounds(47, 318, 178, 30);
		formPanel.add(password);
		
		rePassword = new JPasswordField();
		rePassword.setBounds(302, 318, 178, 30);
		formPanel.add(rePassword);
		
		JButton btnAddBranch = new JButton("Add Branch");
		
		btnAddBranch.setBounds(674, 56, 132, 30);
		btnAddBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButtonClicked(e);
			}
		});
		formPanel.add(btnAddBranch);
		
		JButton btnUpdateBranch = new JButton("Update Branch");
		btnUpdateBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateButtonClicked(e);
			}
		});
		btnUpdateBranch.setBounds(674, 139, 132, 30);
		formPanel.add(btnUpdateBranch);
		
		JButton btnDeleteBranch = new JButton("Delete Branch");
		btnDeleteBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButtonClicked(e);
				
			}
		});
		btnDeleteBranch.setBounds(674, 230, 132, 30);
		formPanel.add(btnDeleteBranch);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 921, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutButtonClicked(e);
			}
		});
		btnLogout.setBounds(822, 11, 89, 30);
		panel.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Admin Panel");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(24, 11, 208, 30);
		panel.add(lblNewLabel);
		
		tablePanel = new JPanel();
		tablePanel.setBounds(0, 52, 921, 318);
		contentPane.add(tablePanel);
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		
		BranchService bs = new BranchService();

		
		table = new JTable();
		table.setRowHeight(30);
		
		String [] header = { "ID", "NAME", "PHONE NO.", "ADDRESS", "EMAIL", "WEB ADDRESS",
				"USERNAME", "PASSWORD"
		};
		Object [] data ;
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(header);
		table.setModel(model);
		
		int i = 0;
		for(Branch b : bs.getBranches()) {
			Object[] row = { b.getId(), b.getName(), b.getPhoneNo(), b.getAddress(), b.getEmail(), b.getWebAddress(), b.getUserName(), b.getPassword() };			
			model.addRow(row);
		}
		
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if (i > -1) {
					name.setText(model.getValueAt(i, 1).toString());
					phoneNo.setText(model.getValueAt(i, 2).toString());
					address.setText(model.getValueAt(i, 3).toString());
					email.setText(model.getValueAt(i, 4).toString());
					webAddress.setText(model.getValueAt(i, 5).toString());
					username.setText(model.getValueAt(i, 6).toString());
					password.setText(model.getValueAt(i, 7).toString());
					rePassword.setText(model.getValueAt(i, 7).toString());
				}
			}
		});
//		js = createTable();
		tablePanel.add(new JScrollPane(table));
	}
	
	private void addButtonClicked(ActionEvent e) {
		Validator v = new Validator();
		if(v.validateAddBranch(name.getText(), phoneNo.getText(), webAddress.getText(), email.getText(), address.getText(), username.getText(), new String(password.getPassword()), new String(rePassword.getPassword()))) {
			Branch b = new Branch(name.getText(), phoneNo.getText(), webAddress.getText(), email.getText(), address.getText(), username.getText(), new String(password.getPassword()));
			BranchService bs = new BranchService();
			bs.createBranch(b);
			System.out.println(bs.getBranches());
			Object[] row = { b.getId(), b.getName(), b.getPhoneNo(), b.getAddress(), b.getEmail(), b.getWebAddress(), b.getUserName(), b.getPassword() };
			model.addRow(row);
		}
	}
	
	private void updateButtonClicked(ActionEvent e) {
		int i = table.getSelectedRow();
		if(i > -1) {
			int id = Integer.parseInt(model.getValueAt(i, 0).toString());
			BranchService bs = new BranchService();
			Branch branch = new Branch(name.getText(), phoneNo.getText(), webAddress.getText(), email.getText(), address.getText(), username.getText(), new String(password.getPassword()));
			Validator v = new Validator();
			if(v.validateBranch(name.getText(), phoneNo.getText(), webAddress.getText(), email.getText(), address.getText(), username.getText(), new String(password.getPassword()), new String(rePassword.getPassword())) && (username.getText() != model.getValueAt(i, 6) || !(v.userNameExists(username.getText())))) {
				bs.updateBranch(id, branch);
				model.setValueAt(name.getText(), i, 1);
				model.setValueAt(phoneNo.getText(), i, 2);
				model.setValueAt(address.getText(), i, 3);
				model.setValueAt(email.getText(), i, 4);
				model.setValueAt(webAddress.getText(), i, 5);
				model.setValueAt(username.getText(), i, 6);
				model.setValueAt(password.getText(), i, 7);
			}
//			if(bs.updateBranch(id, branch)) {
//				
//			}
			
		}
	}
	
	private void deleteButtonClicked(ActionEvent e) {
		 int i = table.getSelectedRow();
		 if(i > -1) {
			 int id = Integer.parseInt(model.getValueAt(i, 0).toString());
			 BranchService bs = new BranchService();
			 if(bs.deleteBranch(id)) {
				 model.removeRow(i);
			 }
			 System.out.println(bs.getBranches().toString());
		 } else {
			 JOptionPane.showMessageDialog(new JFrame(),"Select a branch.","Alert", JOptionPane.WARNING_MESSAGE);
		 }
	}
	
	private void logoutButtonClicked(ActionEvent e) {
		Validator v = new Validator();
		v.setUser(null);
		this.dispose();
		new LoginForm().setVisible(true);
	}
	
private JScrollPane createTable() {
		
		BranchService bs = new BranchService();

		String [] header = { "ID", "NAME", "PHONE NO.", "ADDRESS", "EMAIL", "WEB ADDRESS",
				"USERNAME", "PASSWORD"
		};
		Object [][] data = new Object[bs.getNoOfBranch()][8];
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(header);
		table.setModel(model);
		
		int i = 0;
		for(Branch b : bs.getBranches()) {
			
			data[i][0] = b.getId();
			data[i][1] = b.getName();
			data[i][2] = b.getPhoneNo();
			data[i][3] = b.getAddress();
			data[i][4] = b.getEmail();
			data[i][5] = b.getWebAddress();
			data[i][6] = b.getUserName();
			data[i][7] = b.getPassword();

			i++;
		}
		
		table = new JTable(data, header);
		
		return new JScrollPane(table);
		
	}

}