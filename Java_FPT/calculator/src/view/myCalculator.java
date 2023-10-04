package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class myCalculator extends JFrame{
	
	public myCalculator() {
		
		this.setLocationRelativeTo(null);
		this.setTitle("Calculator");
		this.setSize(300,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set size for text field
		JTextField headerField = new JTextField(100);
		Dimension size = new Dimension(300,70);
		// Set font for text field
		Font font = new Font("Arial", Font.PLAIN, 50);
		headerField.setPreferredSize(size);
		headerField.setFont(font);
		
		// Add header to panel to control
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new BorderLayout());
		headerPanel.add(headerField,BorderLayout.CENTER);
		
		// Create button for calculator
		JButton jButton_0 = new JButton("7");
		JButton jButton_1 = new JButton("8");
		JButton jButton_2 = new JButton("9");
		JButton jButton_3 = new JButton("/");
		JButton jButton_4 = new JButton("AC");
		JButton jButton_5 = new JButton("4");
		JButton jButton_6 = new JButton("5");
		JButton jButton_7 = new JButton("6");
		JButton jButton_8 = new JButton("*");
		JButton jButton_9 = new JButton("(");
		JButton jButton_10 = new JButton("1");
		JButton jButton_11 = new JButton("2");
		JButton jButton_12 = new JButton("3");
		JButton jButton_13 = new JButton("-");
		JButton jButton_14 = new JButton(")");
		JButton jButton_15 = new JButton("0");
		JButton jButton_16 = new JButton("00");
		JButton jButton_17 = new JButton(".");
		JButton jButton_18 = new JButton("+");
		JButton jButton_19 = new JButton("=");


		// Add all button to panel to control
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,5));
		
		buttonPanel.add(jButton_0);
		buttonPanel.add(jButton_1);
		buttonPanel.add(jButton_2);
		buttonPanel.add(jButton_3);
		buttonPanel.add(jButton_4);
		buttonPanel.add(jButton_5);
		buttonPanel.add(jButton_6);
		buttonPanel.add(jButton_7);
		buttonPanel.add(jButton_8);
		buttonPanel.add(jButton_9);
		buttonPanel.add(jButton_10);
		buttonPanel.add(jButton_11);
		buttonPanel.add(jButton_12);
		buttonPanel.add(jButton_13);
		buttonPanel.add(jButton_14);
		buttonPanel.add(jButton_15);
		buttonPanel.add(jButton_16);
		buttonPanel.add(jButton_17);
		buttonPanel.add(jButton_18);
		buttonPanel.add(jButton_19);
		
		// Add all panel to JFrame main
		this.setLayout(new BorderLayout());
		this.add(headerPanel,BorderLayout.NORTH);
		this.add(buttonPanel,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		try {
//			com.sun.java.swing.plaf.gtk.GTKLookAndFeel
//			com.sun.java.swing.plaf.motif.MotifLookAndFeel
//			com.sun.java.swing.plaf.windows.WindowsLookAndFeel

//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new myCalculator();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
