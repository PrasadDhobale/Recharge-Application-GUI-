package shop.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChangePasswordGui {

	private static JFrame frame;
	private static JLabel msg;
	private static JButton cpb;
	private static JPanel panel1;
	
	public ChangePasswordGui(String uname) {
		frame = new JFrame();
		panel1 = new JPanel();
		
		frame.setSize(400, 400);
		panel1.setBackground(Color.CYAN);
		
		msg = new JLabel("Enter Password : ");
		
	}
}
