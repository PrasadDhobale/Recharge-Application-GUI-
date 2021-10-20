package shop.gui;
import java.sql.*;
import shop.dao.*;
import shop.model.Customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChangePasswordUi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblEnterNewPassword;
	
	PreparedStatement ps=null;


	public ChangePasswordUi(Customer c) {
		setBounds(450, 360, 1024, 234);
		setVisible(true);
		setSize(900,900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.CYAN);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField.setBounds(350, 35, 400, 50);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Enter");
		JButton back=new JButton("Go Back");

		btnSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String pass = textField.getText();
				if(pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill The Password");
				}else {
					CustomerDao cdao = new CustomerDao();
					int i = cdao.changePass(c.getuName(),c.getPasswd());
					if(i>0){
						JOptionPane.showMessageDialog(null, "Password Updated Successfully");
					}
					else{
						JOptionPane.showMessageDialog(null, "Oops!! Something Went Wrong.Try Again Later.");
					}
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
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnSearch.setBackground(Color.ORANGE);
		btnSearch.setBounds(400, 127, 170, 59);
		back.setFont(new Font("Tahoma", Font.PLAIN, 29));
		back.setBackground(Color.ORANGE);
		back.setBounds(400, 200, 170, 59);
		contentPane.add(btnSearch);
		contentPane.add(back);
		lblEnterNewPassword = new JLabel("Enter New Password :");
		lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEnterNewPassword.setBounds(30, 30, 300, 67);
		contentPane.add(lblEnterNewPassword);
	}
}