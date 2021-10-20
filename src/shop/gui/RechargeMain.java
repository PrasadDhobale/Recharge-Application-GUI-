package shop.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shop.dao.AccountDao;

public class RechargeMain extends JFrame implements ActionListener{
	
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel msg;
	private static JTextField ramt;
	private static JButton recharge;
	
	public RechargeMain(String uname) {
		frame.setSize(500, 600);
		frame.add(panel);
		GridLayout gl=new GridLayout(6,2,10,10);
		panel.setLayout(gl);
		panel.setBackground(Color.CYAN);
		
		msg = new JLabel("Enter Recharge Amount : ");
		panel.add(msg);
		
		ramt = new JTextField(20);
		panel.add(ramt);
		
		recharge = new JButton("Recharge");
		panel.add(recharge);
		recharge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double amt = Double.parseDouble(ramt.getText());
				AccountDao adao = new AccountDao();
				double b = adao.getbal(uname);
				if(amt < b) {
					b = b - amt;
					int f = adao.recharge(uname, b);
					if(f == 1) {						
						msg.setText("You Have Successfully Done a Recharge for "+String.valueOf(amt));
					}
				}else {
					msg.setText("Insufficient Balance In Your Account");
				}
			}
		});		
		
		msg = new JLabel("");
		panel.add(msg);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
