package shop.gui;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import shop.model.Customer;

public class ProfileUi extends JFrame{
	private static final long serialVersionUID = 1L;

	private JPanel p1,p2;
	JButton back;
	JLabel lab1,l2,l3,l4,l5,l6,l7,l8,l9,l10;

	public ProfileUi(Customer c){

		p1=new JPanel();
		p2=new JPanel();

		Font f2=new Font("Tahoma",Font.PLAIN,23);
		setTitle("Profile Page");
		BorderLayout bl=new BorderLayout();
		lab1=new JLabel("Profile Of "+c.getuName());
		lab1.setFont(f2);
		lab1.setBounds( 70, 40, 200, 80);
		p1.setBackground(Color.ORANGE);
		p1.setLayout(bl);
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		p2.setBackground(Color.CYAN);
		p2.setLayout(new GridLayout(10,10,4,4));

		setVisible(true);
		setSize(500,500);
		p1.add(lab1);		


		l2=new JLabel("Customer ID :   "+"\t\t"+c.getCid());
		l3=new JLabel("FirstName :   "+"\t\t"+c.getfName());
		l2.setFont(f2);
		l3.setFont(f2);
		l4=new JLabel("LastName :    "+"\t\t"+c.getlName());
		l4.setFont(f2);

		l5=new JLabel("Customer Age :     "+"\t\t"+c.getAge());
		l5.setFont(f2);

		l6=new JLabel("Email ID :     "+"\t\t"+c.getEmail());
		l6.setFont(f2);

		l7=new JLabel("Username -   "+"\t\t"+c.getuName());
		l7.setFont(f2);

		l8=new JLabel("Password -    "+"\t\t"+c.getPasswd());
		l8.setFont(f2);

		back=new JButton("Go Back");
		back.setBackground(Color.ORANGE);
		back.setBounds(10, 210, 80,40);

		back.setFont(f2);
		p2.add(l2);
		p2.add(l3);
		p2.add(l4);
		p2.add(l5);
		p2.add(l6);
		p2.add(l7);
		p2.add(l8);				
		p2.add(back);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new WelcomeBank(c);
				setVisible(false);
			}
		});
	}
}