package shop.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import shop.dao.CustomerDao;
import shop.model.Customer;

public class RegisterGui implements ActionListener{

	private static JButton lgbtn,regbtn,hmbtn;

	private static JTextField cidtext;
	private static JLabel cidlabel;

	private static JTextField fnametext;
	private static JLabel fnamelabel;

	private static JTextField lnametext;
	private static JLabel lnamelabel;

	private static JTextField agetext;
	private static JLabel agelabel;

	private static JTextField emailtext;
	private static JLabel emaillabel;

	private static JTextField usertext;
	private static JLabel userlabel;

	private static JPasswordField passtext;
	private static JLabel passLabel;

	private static JLabel title,success;
	private static JPanel panel;
	private static JFrame frame;

	public RegisterGui() {		
		panel = new JPanel();
		frame = new JFrame();

		frame.setSize(500, 600);
		frame.add(panel);
		panel.setLayout(new GridLayout(10,10,5,5));
		panel.setBackground(Color.CYAN);

		hmbtn = new JButton("Home");			
		panel.add(hmbtn);

		title = new JLabel("~~~ Registration Form ~~~");		
		panel.add(title);

		cidlabel= new JLabel("Customer ID");		
		panel.add(cidlabel);

		cidtext= new JTextField(20);		
		panel.add(cidtext);

		fnamelabel = new JLabel("First Name");		
		panel.add(fnamelabel);

		fnametext= new JTextField(20);		
		panel.add(fnametext);

		lnamelabel  = new JLabel("Last Name");		
		panel.add(lnamelabel);

		lnametext  = new JTextField(20);		
		panel.add(lnametext);

		agelabel = new JLabel("Customer Age");		
		panel.add(agelabel);

		agetext= new JTextField(20);		
		panel.add(agetext);

		emaillabel = new JLabel("Email ID");		
		panel.add(emaillabel);

		emailtext = new JTextField(20);		
		panel.add(emailtext);

		userlabel = new JLabel("Username");		
		panel.add(userlabel);

		usertext = new JTextField(20);		
		panel.add(usertext);

		passLabel= new JLabel("Password");		
		panel.add(passLabel);

		passtext = new JPasswordField(20);		
		panel.add(passtext);

		regbtn = new JButton("Register");		
		panel.add(regbtn);

		success = new JLabel("");		
		panel.add(success);

		title = new JLabel("Already Have an Account ?");		
		panel.add(title);

		lgbtn = new JButton("Login");		
		panel.add(lgbtn);

		lgbtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginGui lg = new LoginGui();
				frame.dispose();				
			}
		});
		regbtn.addActionListener(this);
		hmbtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				IndexGui ig = new IndexGui();
				frame.dispose();
			}
		});
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == regbtn) {
			String id = cidtext.getText();
			String fname = fnametext.getText();
			String lname = lnametext.getText();
			String age = agetext.getText();
			String email = emailtext.getText();
			String uname = usertext.getText();
			String pass = passtext.getText();

			if(id.equals("") || fname.equals("") || lname.equals("") || age.equals("") || email.equals("") || uname.equals("") || pass.equals("")) {
				JOptionPane.showMessageDialog(success, "Please Fill All The Details Correctly");
			}else {
				String regex = "^(?=.*[0-9])"
	                       + "(?=.*[a-z])(?=.*[A-Z])"
	                       + "(?=.*[@#$%^&+=])"
	                       + "(?=\\S+$).{8,20}$";
				
				if(Pattern.matches(regex,pass) && pass.length()== 8){
					if(id.matches("[0-9]+") && age.matches("[0-9]+") ) {
						if(fname.matches("^[a-zA-Z]*$") && lname.matches("^[a-zA-Z]*$")) {
							if(!uname.matches("^[a-zA-Z0-9]")) {															
							int cid = Integer.parseInt(id);
							int cage = Integer.parseInt(age);
							CustomerDao cdao = new CustomerDao();
							boolean b = cdao.checkuser(cid,uname);
							if(b != true) {
								Customer c = new Customer(cid, fname, lname, cage, email, uname, pass);
								int flag = cdao.RegisterCust(c);
								if(flag == 1) {
									JOptionPane.showMessageDialog(success, "You are Now Successfully Registered With Us");
								}else {
									JOptionPane.showMessageDialog(success, "Failed To Register!! Try Again.");
								}
							}else {
								JOptionPane.showMessageDialog(success, "Customer ID Or Username Already Exists");
							}
							}else {
								JOptionPane.showMessageDialog(success, "Please Enter Strong Username");
							}
						}else {
							JOptionPane.showMessageDialog(success, "First & Last Name Should have Only Alphabets");
						}
					}else {
						JOptionPane.showMessageDialog(success, "Customer Id & Age Should have Only Numbers");
					}
				}else {
					JOptionPane.showMessageDialog(success, "Password Incredentials\nShould have to be 8 characters\n3 Digits and Alphabets");
				}
			}
		}
	}
}