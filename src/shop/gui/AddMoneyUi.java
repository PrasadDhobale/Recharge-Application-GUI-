package shop.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.*;

import shop.dao.AccountDao;
import shop.model.Customer;

public class AddMoneyUi extends JFrame {

	JTextField t1;
	JLabel l1,l2;
	JPanel p1;
	JButton enter,back;	
	
	public AddMoneyUi(Customer c){
		setBounds(450, 360, 1024, 234);
		setVisible(true);
		setSize(600,500);
		p1 = new JPanel();
		p1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p1);
		p1.setLayout(null);
		p1.setBackground(Color.CYAN);
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		t1.setBounds(230, 80, 150, 40);
		p1.add(t1);
		t1.setColumns(10);

		enter=new JButton("Deposit");
		back=new JButton("Dashboard");
		enter.setFont(new Font("Tahoma", Font.PLAIN, 24));
		enter.setBackground(Color.ORANGE);
		enter.setBounds(230, 150, 150, 30);
		back.setFont(new Font("Tahoma", Font.PLAIN, 24));
		back.setBackground(Color.ORANGE);
		back.setBounds(5, 5, 150, 30);
		p1.add(enter);
		p1.add(back);
		l1= new JLabel("Enter Amount For Deposit");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		l1.setBounds(150, 30, 300, 50);
		p1.add(l1);

		enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
								
				double newbal=Double.parseDouble(t1.getText());
				
				AccountDao adao = new AccountDao();
				
				int i = adao.addMoney(c.getuName(), newbal);
				if(i > 0) {
					double bal = adao.getbal(c.getuName());
					JOptionPane.showMessageDialog(enter, "Money Added SuccessFully.\nUpdated Balance : "+bal);
				}else {
					JOptionPane.showMessageDialog(enter, "Failed to Add Money");
				}
			}
		});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WelcomeBank(c);
				setVisible(false);

			}
		});
	}	
}