package shop.gui;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import shop.dao.CustomerDao;
import shop.model.Customer;

public class LoginGui extends JFrame implements ActionListener{

	private static JButton lgbtn,regbtn,hmbtn;
	private static JPasswordField passtext;
	private static JLabel passLabel;
	private static JTextField usertext;
	private static JLabel userlabel;
	private static JLabel success,msg;
	
	private static JPanel panel;
	private static JFrame frame;

	public LoginGui() {
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(400, 400);

		frame.add(panel);
		panel.setLayout(new GridLayout(9,10,10,10));
		panel.setBackground(Color.CYAN);
		
		hmbtn = new JButton("Home");
		panel.add(hmbtn);

		msg = new JLabel("Welcome To Login",JLabel.CENTER);
		panel.add(msg);
		userlabel = new JLabel("Username");
		panel.add(userlabel);

		usertext = new JTextField(20);
		panel.add(usertext); 

		passLabel =new JLabel("Password");
		panel.add(passLabel);

		passtext = new JPasswordField();
		panel.add(passtext);

		lgbtn = new JButton("Login");
		panel.add(lgbtn);
		lgbtn.addActionListener(this);

		success = new JLabel("");
		panel.add(success);

		regbtn = new JButton("");
		regbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterGui rgui= new RegisterGui();
				frame.dispose();
			}
		});

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
		String uname = usertext.getText();
		String pass = passtext.getText();

		if(uname.equals("") || pass.equals("")) {
			success.setText("Please Fill All The Details");
		}else {
			CustomerDao cdao = new CustomerDao();
			Customer c = cdao.Login(uname, pass);
			if(c != null) {
				if(uname.equals(c.getuName()) && pass.equals(c.getPasswd())) {
					success.setText("Login Successfully");
					//DashboardGui dg = new DashboardGui(c);
					WelcomeBank wb = new WelcomeBank(c);
					success.setText("");
					frame.dispose();
				}
			}else{
				success.setText("You Not Registered With Us !! Register Here..");
				regbtn.setText("Register");
				panel.add(regbtn);
			}
		}
	}
}