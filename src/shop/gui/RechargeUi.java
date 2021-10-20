package shop.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shop.dao.AccountDao;
import shop.model.Customer;

public class RechargeUi extends JFrame{

	JPanel pl,p2;
	JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	JComboBox service;
	JButton rech,back;
	public RechargeUi(Customer c)
	{
		BorderLayout br=new BorderLayout();
		pl=new JPanel();
		p2=new JPanel();

		Font f2=new Font("Aerial",Font.BOLD,23);
		l4=new JLabel("Recharge Page");
		l4.setFont(f2);
		l4.setBounds(70, 40, 200, 40);
		p2.setBackground(Color.CYAN);
		add(p2,BorderLayout.NORTH);
		p2.add(l4);
		pl.setBackground(Color.ORANGE);
		setVisible(true);
		pl.setLayout(new GridLayout(4,2,2,2));
		setSize(500,500);
		l2=new JLabel("Phone Number :");
		l2.setFont(f2);
		t1=new JTextField(10);
		t1.setFont(f2);

		l3=new JLabel("Service Provider :");
		l3.setFont(f2);

		String sp[]= {"Vodafone","Jio","Airtel","Idea"};
		service=new JComboBox(sp);
		service.setFont(f2);

		l1=new JLabel("Enter Balance :");
		l1.setFont(f2);
		t2=new JTextField(20);
		t2.setFont(f2);


		rech=new JButton("Recharge");
		rech.setFont(f2);
		rech.setBackground(Color.CYAN);

		rech.setBounds(280, 280,100,40);
		//service.setBounds(70, 230, 200, 30);
		back=new JButton("Go Back");
		back.setBackground(Color.CYAN);
		back.setBounds(300, 280, 100,40);

		back.setFont(f2);
		pl.add(l2);
		pl.add(t1);
		pl.add(l3);
		pl.add(service);
		pl.add(l1);
		pl.add(t2);
		pl.add(rech);
		pl.add(back);
		add(pl);

		rech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1=t2.getText();
				String mob=t1.getText();
				if(mob.equals("") || str1.equals("")) {
					JOptionPane.showMessageDialog(rech, "Please Fill The Details");
				}else {
					double n1=Integer.parseInt(str1);

					AccountDao adao = new AccountDao();
					double bal=adao.getbal(c.getuName());
					if(bal != 0) {
						bal = bal - n1;
						if(n1 < bal) {
							adao.recharge(c.getuName(), bal);
							JOptionPane.showMessageDialog(rech, "Recharge SuccessFully");	
						}else {
							JOptionPane.showMessageDialog(rech, "Insufficient Balance In Your Account");
						}
					}else {
						JOptionPane.showMessageDialog(rech, "Please Link Your Bank Account");
					}
				}
			}
		});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WelcomeBank dg = new WelcomeBank(c);				
				setVisible(false);
			}
		});
	}
}