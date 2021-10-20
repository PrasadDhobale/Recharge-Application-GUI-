package shop.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shop.dao.AccountDao;
import shop.dao.CustomerDao;
import shop.model.Account;
import shop.model.Customer;

public class AddAccount extends JFrame implements ActionListener {
	
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel success,msglabel,unamelabel,accnolabel,accballabel;
	private static JTextField unamevalue,accbalvalue,accnovalue;
	private static JButton craccbtn,dbtn;
	
	public AddAccount(Customer c) {
		frame.setSize(500, 600);
		frame.add(panel);
		panel.setBackground(Color.CYAN);
		
		GridLayout gl = new GridLayout(6,2);
		panel.setLayout(gl);
		
		dbtn = new JButton("Dashboard");
		dbtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				DashboardGui dg = new DashboardGui(c);
				frame.dispose();
			}
		});
		panel.add(dbtn);
		
		msglabel = new JLabel("~~~~ Welcome To Banking ~~~~");
		msglabel.setBounds(50, 40, 200, 25);
		panel.add(msglabel);
		
		unamelabel = new JLabel("Username");
		panel.add(unamelabel);
		
		unamevalue = new JTextField(20);
		panel.add(unamevalue);
		
		Random rd = new Random();
		String accno ="77";
		for(int i=0;i<8;i++) {
			int n = rd.nextInt(8) + 0;
			accno += Integer.toString(n);
		}
		accnolabel = new JLabel("Account Number");		
		panel.add(accnolabel);
		
		accnovalue = new JTextField(20);
		panel.add(accnovalue);				
		
		accballabel = new JLabel("Account Balance");
		panel.add(accballabel);
		
		accbalvalue = new JTextField(20);
		panel.add(accbalvalue);
				
		craccbtn  = new JButton("Create Account");
		craccbtn.setBounds(80, 360, 130, 25);
		craccbtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String uname = unamevalue.getText();
				int accno = Integer.parseInt(accnovalue.getText());
				Double accbal = Double.parseDouble(accbalvalue.getText());
				AccountDao adao = new AccountDao();
				Account a = new Account(uname, accno, accbal);
				int f = adao.adAccount(a);
				if(f == 1) {
					success.setText("Account Created Successfully");
				}else {
					success.setText("Something Went Wrong");
				}
			}
		});
		panel.add(craccbtn);
		
		success = new JLabel("");
		panel.add(success);
				
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}