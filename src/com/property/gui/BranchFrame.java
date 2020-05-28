package com.property.gui;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.property.model.Branch;
import com.property.model.Flat;
import com.property.model.House;
import com.property.service.BranchService;
import com.property.service.FlatService;
import com.property.service.HouseService;
import com.property.utils.Validator;

public class BranchFrame extends JFrame {

	private JPanel contentPane;
	private JTextField address;
	private JTextField noOfRooms;
	private JTextField sellingPrice;
	private JTextField soldPrice;
	private JTextField noOfFloors;
	private JTextField floorNo;
	private JTextField monthlyCharge;
	private JRadioButton rdbtnHasGardenYes;
	private JRadioButton rdbtnHasGardenNo;
	private JRadioButton rdbtnHasGarageYes;
	private JRadioButton rdbtnHasGarageNo;
	private JRadioButton rdbtnHouse;
	private JRadioButton rdbtnFlat;
	private ButtonGroup hasGarden;
	private ButtonGroup hasGarage;
	
	private ButtonGroup propertyType;
	
	private JScrollPane housePane;
	private JScrollPane flatPane;
	
	private JTable houseTable;
	private DefaultTableModel houseModel;
	
	private JTable flatTable;
	private DefaultTableModel flatModel;

	
	public BranchFrame() {}
	
	public BranchFrame(String username) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new Validator().closeWindow(e);
			}
		});
		setBounds(100, 100, 1201, 835);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(260, 0, 925, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutButtonClicked(e);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(820, 13, 95, 36);
		panel.add(btnLogout);
		
		JLabel lblBranchName = new JLabel();
		lblBranchName.setText(username);
		lblBranchName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBranchName.setBounds(10, 11, 135, 36);
		panel.add(lblBranchName);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(0, 0, 260, 796);
		contentPane.add(formPanel);
		formPanel.setLayout(null);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(42, 11, 97, 19);
		formPanel.add(lblAddress);
		
		address = new JTextField();
		address.setBounds(42, 33, 178, 25);
		formPanel.add(address);
		address.setColumns(10);
		
		JLabel lblNoOfRooms = new JLabel("No of Rooms");
		lblNoOfRooms.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoOfRooms.setBounds(42, 69, 97, 19);
		formPanel.add(lblNoOfRooms);
		
		noOfRooms = new JTextField();
		noOfRooms.setColumns(10);
		noOfRooms.setBounds(42, 91, 178, 25);
		formPanel.add(noOfRooms);
		
		JLabel lblSellingPrice = new JLabel("Selling Price");
		lblSellingPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSellingPrice.setBounds(42, 127, 97, 19);
		formPanel.add(lblSellingPrice);
		
		sellingPrice = new JTextField();
		sellingPrice.setColumns(10);
		sellingPrice.setBounds(42, 149, 178, 25);
		formPanel.add(sellingPrice);
		
		JLabel lblSoldPrice = new JLabel("Sold Price");
		lblSoldPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoldPrice.setBounds(42, 185, 97, 19);
		formPanel.add(lblSoldPrice);
		
		soldPrice = new JTextField();
		soldPrice.setColumns(10);
		soldPrice.setBounds(42, 207, 178, 25);
		formPanel.add(soldPrice);
		
		JLabel lblNoOfFloors = new JLabel("No of Floors ( * for house)");
		lblNoOfFloors.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoOfFloors.setBounds(42, 243, 208, 19);
		formPanel.add(lblNoOfFloors);
		
		noOfFloors = new JTextField();
		noOfFloors.setColumns(10);
		noOfFloors.setBounds(42, 265, 178, 25);
		formPanel.add(noOfFloors);
		
		JLabel lblFloorNo = new JLabel("Floor No. ( * for Flat)");
		lblFloorNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFloorNo.setBounds(42, 301, 178, 19);
		formPanel.add(lblFloorNo);
		
		floorNo = new JTextField();
		floorNo.setColumns(10);
		floorNo.setBounds(42, 323, 178, 25);
		formPanel.add(floorNo);
		
		JLabel lblMonthlyCharge = new JLabel("Monthly Charge ( * for flat)");
		lblMonthlyCharge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMonthlyCharge.setBounds(42, 359, 208, 19);
		formPanel.add(lblMonthlyCharge);
		
		monthlyCharge = new JTextField();
		monthlyCharge.setColumns(10);
		monthlyCharge.setBounds(42, 381, 178, 25);
		formPanel.add(monthlyCharge);
		
		JButton btnAddProperty = new JButton("Add Property");
		btnAddProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPropertyButtonClicked(e);
			}
		});
		
		btnAddProperty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddProperty.setBounds(42, 655, 160, 36);
		formPanel.add(btnAddProperty);
		
		JButton btnUpdateProperty = new JButton("Update Property");
		btnUpdateProperty.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				updateButtonClicked(e);
			}
		});
		btnUpdateProperty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateProperty.setBounds(42, 702, 160, 36);
		formPanel.add(btnUpdateProperty);
		
		JButton btnDeleteProperty = new JButton("Delete Property");
		btnDeleteProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButtonClicked(e);
			}
		});
		btnDeleteProperty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteProperty.setBounds(42, 749, 160, 36);
		formPanel.add(btnDeleteProperty);
		
		JLabel lblHasGarden = new JLabel("Has Garden ( * for House)");
		lblHasGarden.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHasGarden.setBounds(42, 417, 208, 19);
		formPanel.add(lblHasGarden);
		
		JLabel lblHasGarage = new JLabel("Has Garage ( * for House)");
		lblHasGarage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHasGarage.setBounds(42, 507, 208, 19);
		formPanel.add(lblHasGarage);
		
		rdbtnHasGardenYes = new JRadioButton("Yes");
		rdbtnHasGardenYes.setBounds(42, 443, 109, 23);
		formPanel.add(rdbtnHasGardenYes);
		
		
		
		rdbtnHasGardenNo = new JRadioButton("No");
		rdbtnHasGardenNo.setSelected(true);
		rdbtnHasGardenNo.setBounds(42, 469, 109, 23);
		formPanel.add(rdbtnHasGardenNo);
		
		rdbtnHasGarageYes = new JRadioButton("Yes");
		rdbtnHasGarageYes.setBounds(42, 533, 109, 23);
		formPanel.add(rdbtnHasGarageYes);
		
		
		rdbtnHasGarageNo = new JRadioButton("No");
		rdbtnHasGarageNo.setSelected(true);
		rdbtnHasGarageNo.setBounds(42, 564, 109, 23);
		formPanel.add(rdbtnHasGarageNo);
		
		rdbtnHouse = new JRadioButton("House");
		rdbtnHouse.setBounds(42, 616, 72, 23);
		formPanel.add(rdbtnHouse);
		
		rdbtnFlat = new JRadioButton("Flat");
		rdbtnFlat.setBounds(132, 616, 70, 23);
		formPanel.add(rdbtnFlat);
		
		hasGarden = new ButtonGroup();
		hasGarage = new ButtonGroup();
		propertyType = new ButtonGroup();
		
		hasGarden.add(rdbtnHasGardenYes);
		hasGarden.add(rdbtnHasGardenNo);
		
		hasGarage.add(rdbtnHasGarageYes);
		hasGarage.add(rdbtnHasGarageNo);
	
		propertyType.add(rdbtnFlat);
		propertyType.add(rdbtnHouse);
		
		JPanel housePanel = new JPanel();
		housePanel.setBounds(260, 55, 925, 369);
		contentPane.add(housePanel);
		housePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHouse = new JLabel("House");
		lblHouse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		housePanel.add(lblHouse, BorderLayout.NORTH);
		
		houseTable = new JTable();
		houseTable.setRowHeight(30);
		housePane = new JScrollPane(houseTable);
		housePanel.add(housePane);
		
		String [] header = { "ID", "ADDRESS", "NO. OF ROOMS", "SELLING PRICE", "SOLD PRICE", "NO.OF FLOORS",
				"HAS GARDEN", "HAS GARAGE"
		};
		
		houseModel = new DefaultTableModel();
		houseModel.setColumnIdentifiers(header);
		houseTable.setModel(houseModel);
		
		HouseService hs = new HouseService();
		DecimalFormat format = new DecimalFormat("#0000000");
		
		Branch branch = new BranchService().getBranch(username);
		
		for(House h : hs.getHouses()) {
			Object[] row = {h.getId(), h.getAddress(), h.getNoOfRooms(), h.getSellingPrice(), h.getSoldPrice(), h.getNoOfFloors(), h.getHasGarden(), h.getHasGarage() };
			if(branch.getId() == h.getBranchId()) {
				houseModel.addRow(row);
			}
		}
		
		houseTable.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int i = houseTable.getSelectedRow();
//				DecimalFormat format  = new DecimalFormat("#00000000");
				if (i > -1) {
					address.setText(houseModel.getValueAt(i, 1).toString());
					noOfRooms.setText(houseModel.getValueAt(i, 2).toString());
					sellingPrice.setText(houseModel.getValueAt(i, 3).toString());
					soldPrice.setText(houseModel.getValueAt(i, 4).toString());
					noOfFloors.setText(houseModel.getValueAt(i, 5).toString());
					if(houseModel.getValueAt(i,6).equals(true)) {
						rdbtnHasGardenYes.setSelected(true);
					} else {
						rdbtnHasGardenNo.setSelected(false);
					}
					if(houseModel.getValueAt(i, 7).equals(true)) {
						rdbtnHasGarageYes.setSelected(true);
					} else {
						rdbtnHasGarageNo.setSelected(true);
					}
					rdbtnHouse.setSelected(true);
				}
			}
		});
		
		JPanel flatPanel = new JPanel();
		flatPanel.setBounds(260, 422, 925, 374);
		contentPane.add(flatPanel);
		flatPanel.setLayout(new BorderLayout(0,0));
		
		JLabel lblFlat = new JLabel("Flat");
		lblFlat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		flatPanel.add(lblFlat, BorderLayout.NORTH);
		
		flatTable = new JTable();
		flatTable.setRowHeight(30);
		flatPane = new JScrollPane(flatTable);
		flatPanel.add(flatPane);
		
		String [] flatHeader = { "ID", "ADDRESS", "NO. OF ROOMS", "SELLING PRICE", "SOLD PRICE", "FLOOR NO.", "MONTHLY CHARGE" };
		
		flatModel = new DefaultTableModel();
		flatModel.setColumnIdentifiers(flatHeader);
		flatTable.setModel(flatModel);
		
		
		FlatService fs = new FlatService();
		for(Flat f : fs.getFlats()) {
			
			Object[] row = {f.getId(), f.getAddress(), f.getNoOfRooms(), format.format(f.getSellingPrice()), format.format(f.getSoldPrice()), f.getFloorNo(), format.format(f.getMonthlyCharge()) };
			if(branch.getId() == f.getBranchId()) {
				flatModel.addRow(row);
			}
		}
		
		flatTable.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int i = flatTable.getSelectedRow();
				if (i > -1) {
					address.setText(flatModel.getValueAt(i, 1).toString());
					noOfRooms.setText(flatModel.getValueAt(i, 2).toString());
					sellingPrice.setText(flatModel.getValueAt(i, 3).toString());
					soldPrice.setText(flatModel.getValueAt(i, 4).toString());
					floorNo.setText(flatModel.getValueAt(i, 5).toString());
					monthlyCharge.setText(flatModel.getValueAt(i, 6).toString());
					rdbtnFlat.setSelected(true);
				}
			}
		});
		
	}
	
	
	private void addPropertyButtonClicked(ActionEvent e) {
		if(rdbtnHouse.isSelected()) {
			Validator v = new Validator();
			
			HouseService hs = new HouseService();
			boolean hasGdn = rdbtnHasGardenYes.isSelected()? true : false;
			boolean hasGar = rdbtnHasGarageYes.isSelected()? true : false;
			House h = v.validateHouse(address.getText(), noOfRooms.getText(), sellingPrice.getText(), soldPrice.getText(), noOfFloors.getText(), hasGdn, hasGar);
			if (h != null) {
				hs.createHouse(h);
				Object[] row = {h.getId(), h.getAddress(), h.getNoOfRooms(), h.getSellingPrice(), h.getSoldPrice(), h.getNoOfFloors(), h.getHasGarden(), h.getHasGarage() };
				houseModel.addRow(row);
			}
			
		} else if (rdbtnFlat.isSelected()) {
			Validator v = new Validator();
			
			FlatService fs = new FlatService();
			Flat f = v.validateFlat(address.getText(), noOfRooms.getText(), sellingPrice.getText(), soldPrice.getText(), floorNo.getText(), monthlyCharge.getText());
			if (f != null) {
				fs.createFlat(f);
				Object[] row = {f.getId(), f.getAddress(), f.getNoOfRooms(), f.getSellingPrice(), f.getSoldPrice(), f.getFloorNo(), f.getMonthlyCharge() };
				flatModel.addRow(row);
			}
		} else {
			JOptionPane.showMessageDialog(new JFrame(),"Select appropriate Property type.","Alert", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void updateButtonClicked(ActionEvent e) {
		if(rdbtnHouse.isSelected()) {
			
			int i = houseTable.getSelectedRow();
			if(i > -1) {
				int id = Integer.parseInt(houseModel.getValueAt(i, 0).toString());
				
				Validator v = new Validator();
				
				HouseService hs = new HouseService();
				boolean hasGdn = rdbtnHasGardenYes.isSelected()? true : false;
				boolean hasGar = rdbtnHasGarageYes.isSelected()? true : false;
				House h = v.validateHouse(address.getText(), noOfRooms.getText(), sellingPrice.getText(), soldPrice.getText(), noOfFloors.getText(), hasGdn, hasGar);
				if (h != null) {
					hs.updateHouse(id, h);
					houseModel.setValueAt(address.getText(), i, 1);
					houseModel.setValueAt(noOfRooms.getText(), i, 2);
					houseModel.setValueAt(sellingPrice.getText(), i, 3);
					houseModel.setValueAt(soldPrice.getText(), i, 4);
					houseModel.setValueAt(noOfFloors.getText(), i, 5);
					houseModel.setValueAt(hasGdn, i, 6);
					houseModel.setValueAt(hasGar, i, 7);
				}
				
			}
			
		}

		
	}
	
	private void deleteButtonClicked(ActionEvent e) {
		if(rdbtnHouse.isSelected()) {
			int i = houseTable.getSelectedRow();
			
			if (i > -1) {
				int id = Integer.parseInt(houseModel.getValueAt(i,0).toString());
				HouseService hs = new HouseService();
				if(hs.deleteHouse(id)) {
					houseModel.removeRow(i);
				}
			}
		} else if(rdbtnFlat.isSelected()) {
			int i = flatTable.getSelectedRow();
			if(i > -1) {
				int id = Integer.parseInt(flatModel.getValueAt(i,0).toString());
				FlatService fs = new FlatService();
				if(fs.deleteFlat(id)) {
					flatModel.removeRow(i);
				}
			}
		} else {
			JOptionPane.showMessageDialog(new JFrame(),"Select a property.","Alert", JOptionPane.WARNING_MESSAGE);
		}

	}
	
	private void logoutButtonClicked(ActionEvent e) {
		new Validator().setUser("");
		this.dispose();
		new LoginForm().setVisible(true);
	}
}

