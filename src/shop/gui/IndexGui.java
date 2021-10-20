package shop.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IndexGui extends JFrame implements ActionListener{
	
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel userlabel;
	private static JButton btnlogin,btnregister;
	
	public IndexGui() {
		frame.setSize(400, 400);
		frame.add(panel);
		panel.setLayout(null);
		
		userlabel  = new JLabel("Welcome Page");		
		userlabel.setBounds(100, 20, 100, 25);
		panel.add(userlabel);
		
		
		btnlogin = new JButton("Login");
		btnlogin.setBounds(10,100, 80,25);
		btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginGui lg = new LoginGui();
				frame.dispose();			
			}
		});
		panel.add(btnlogin);
		
		btnregister = new JButton("Register");
		btnregister.setBounds(200,100, 100,25);
		btnregister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterGui rg = new RegisterGui();
				frame.dispose();
			}
		});
		panel.add(btnregister);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		
	}	
}