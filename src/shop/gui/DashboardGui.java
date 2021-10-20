package shop.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import shop.model.Customer;

public class DashboardGui implements ActionListener{

	private static JFrame frame;
	private static JPanel panel;	
	private static JLabel userlabel,cidlabel,fnamelabel,lnamelabel,agelabel,emaillabel,unamelabel,passlabel;
	private static JLabel cidvalue,fnamevalue,lnamevalue,agevalue,emailvalue,unamevalue,passvalue;
	private static JButton btnlgout,btnProfile,btnAddAccount,btnRecharge,btnaddmoney,btnchangepass;

	public DashboardGui(Customer c) {
		panel = new JPanel();
		frame = new JFrame();

		frame.setSize(700, 600);
		frame.add(panel);
		
		userlabel = new JLabel("Welcome to Dashboard");
		panel.add(userlabel);

		panel.setLayout(new GridLayout(10, 10, 5, 5));
		panel.setBackground(Color.CYAN);

		btnaddmoney = new JButton("Add Money");
		panel.add(btnaddmoney);
		
		btnchangepass = new JButton("Change Password");
		btnchangepass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				ChangePasswordUi cpg = new ChangePasswordUi(c);
				frame.dispose();
			}
		});
		panel.add(btnchangepass);		

		btnlgout = new JButton("Logout");
		panel.add(btnlgout);
		btnlgout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				LoginGui lg = new LoginGui();
				frame.dispose();
			}
		});
		userlabel = new JLabel("");
		userlabel.setText("Welcome "+c.getuName());
		panel.add(userlabel);

		btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnProfile) {					

					ProfileUi pg = new ProfileUi(c);
					/*cidlabel.setText("Customer ID");
					cidvalue.setText(": "+String.valueOf(c.getCid()));
					fnamelabel.setText("First Name");
					fnamevalue.setText(": "+c.getfName());
					lnamelabel.setText("Last Name");
					lnamevalue.setText(": "+c.getlName());
					agelabel.setText("Customer Age");
					agevalue.setText(": "+String.valueOf(c.getAge()));
					emaillabel.setText("Email ID");
					emailvalue.setText(": "+c.getEmail());
					unamelabel.setText("Username");
					unamevalue.setText(": "+c.getuName());
					passlabel.setText("Password");
					passvalue.setText(": "+c.getPasswd());*/
				}
			}
		});
		panel.add(btnProfile);

		cidlabel = new JLabel("");
		panel.add(cidlabel);

		cidvalue = new JLabel("");
		panel.add(cidvalue);

		fnamelabel = new JLabel("");
		panel.add(fnamelabel);

		fnamevalue= new JLabel("");
		panel.add(fnamevalue);

		lnamelabel = new JLabel("");
		panel.add(lnamelabel);

		lnamevalue= new JLabel("");
		panel.add(lnamevalue);

		agelabel = new JLabel("");
		panel.add(agelabel);

		agevalue= new JLabel("");
		panel.add(agevalue);

		emaillabel = new JLabel("");
		panel.add(emaillabel);

		emailvalue= new JLabel("");
		panel.add(emailvalue);

		unamelabel =new JLabel("");
		panel.add(unamelabel);

		unamevalue= new JLabel("");
		panel.add(unamevalue);

		passlabel = new JLabel("");
		panel.add(passlabel);		

		passvalue = new JLabel("");
		panel.add(passvalue);

		btnAddAccount = new JButton("Add Bank Account");
		btnAddAccount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {			
				AddAccount ag = new AddAccount(c);
				frame.dispose();
			}
		});
		panel.add(btnAddAccount);		

		btnRecharge = new JButton("Recharge");
		btnRecharge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				RechargeUi rm = new RechargeUi(c);
				frame.dispose();
			}
		});
		panel.add(btnRecharge);		
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}