//package com.Ui;
//import java.awt.BorderLayout;
//
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.Font;
//
//import java.awt.GridLayout;
//
//import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.net.URL;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//
//import com.Main.BankAppMain;
//
//public class WelcomeBank extends JFrame{
//
//    private static final long serialVersionUID = 1L;
//
//	JPanel p1,p2,p3,p4;
//	JLabel l1,l2,l3;
//	JTextField t1,t2;
//	
//	JButton cp,logout,rec,addmoney,profile,trans;
//	Font f2=new Font("Tahoma",Font.PLAIN,20);
//	public WelcomeBank(String uname)
//	{
//		Font f=new Font("Tahoma",Font.PLAIN,30);
//		BorderLayout bl=new BorderLayout();
//		setLayout(bl);
//		setSize(600,600);
//		setVisible(true);
//		p1=new JPanel();
//		p1.setBackground(Color.CYAN);
//		add(p1,BorderLayout.NORTH);
//		l1=new JLabel("Dear "+uname+" Welcome to our Bank !");
//		l1.setFont(f);
//	
//		p1.add(l1);
//		p2=new JPanel();
//		p2.setBackground(Color.BLACK);
//	
//		add(p2,BorderLayout.CENTER);
//		
//		p3=new JPanel(new GridLayout(10,1,15,15));
//		p3.setBackground(Color.ORANGE);
//		p3.setBounds(0,0,400, 0);
//		add(p3,BorderLayout.WEST);
//		p4 = new JPanel();
//		add(p4,BorderLayout.CENTER);
//		p4.setBackground(Color.DARK_GRAY);
//		
//		try
//		{
//			BufferedImage img = ImageIO.read(new URL(
//			        "https://img.republicworld.com/republic-prod/stories/promolarge/xxhdpi/fkhdzmqsb3torsnw_1598859765.jpeg") );
//			    ImageIcon icon = new ImageIcon(img);
//			    
//			    JLabel l9=new JLabel(icon);
//			    l9.setBounds(2300,400, 90,90);
//				p4.add(l9);
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//		
//		profile=new JButton("Profile");
//		profile.setFont(f2);
//		rec=new JButton("Recharge");
//		rec.setFont(f2);
//		rec.setBounds(70,230,200,90);
//		cp=new JButton("Change Password");
//		cp.setFont(f2);
//		logout=new JButton("LogOut");
//		logout.setFont(f2);
//		addmoney=new JButton("Add Money");
//		addmoney.setFont(f2);
//		trans=new JButton("View Transactions");
//		trans.setFont(f2);
//		p3.add(profile);
//		p3.add(rec);
//		p3.add(cp);
//		p3.add(addmoney);
//		p3.add(trans);
//		p3.add(logout);
//		profile.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				ProfileUi pr=new ProfileUi(uname);
//				setVisible(false);
//				pr.setTitle("Profile Page");
//				
//			}
//		});
//		rec.addActionListener(new ActionListener() {
//	            public void actionPerformed(ActionEvent e) {
//	            	RechargeUi rc=new RechargeUi(uname);
//	            	setVisible(false);
//	               rc.setTitle("Recharge Page");
//	                
//	            }
//		});
//		cp.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				ChangePasswordUi ch=new ChangePasswordUi(uname);
//				setVisible(false);
//				ch.setTitle("Change Password");
//			}
//		});
//		addmoney.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				AddMoneyUi ad=new AddMoneyUi(uname);
//				setVisible(false);
//			
//				
//			}
//		});
//		trans.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				TransactionUi t=new TransactionUi(uname);
//				setVisible(false);
//			}
//		});
//		logout.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                int a = JOptionPane.showConfirmDialog(logout, "Are you sure?");
//                // JOptionPane.setRootFrame(null);
//                if (a == JOptionPane.YES_OPTION) {
//                    dispose();
//                   BankAppMain bp=new BankAppMain();
//                    bp.setTitle("Home-Page");
//                    bp.setVisible(true);
//                }
//                dispose();
//                BankAppMain bg=new BankAppMain();
//                bg.setVisible(true);
//            }
//        });
//	}
//}
