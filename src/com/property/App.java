package com.property;

import java.awt.EventQueue;

import com.property.gui.LoginForm;
import com.property.utils.FileManager;

public class App {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					FileManager fm = new FileManager();
					fm.loadBranch();
					fm.loadHouse();
					fm.loadFlat();
					fm.loadId();
					
					LoginForm frame = new LoginForm();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
