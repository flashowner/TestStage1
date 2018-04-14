/*
 * 功能简单的计算器
 */
package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EasyCalculator extends JFrame implements ActionListener {
	//JPanel p1, p2;
	JLabel jlb1, jlb2, jlb3;
	JTextField jtf1, jtf2;
	JButton jb1, jb2, jb3, jb4, jb5;
	
	public static void main(String[] args) {
		EasyCalculator easy = new EasyCalculator();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "+") {
			jlb1.setText("+");
		} else if (e.getActionCommand() == "-") {
			jlb1.setText("-");
		} else if (e.getActionCommand() == "*") {
			jlb1.setText("*");
		} else if (e.getActionCommand() == "/") {
			jlb1.setText("/");
		} else if (e.getActionCommand() == "OK") {
			String operation = jlb1.getText();
			String op1 = jtf1.getText();
			String op2 = jtf2.getText();
			boolean chk1 = check(op1);
			boolean chk2 = check(op2);
			boolean chk3 = true;
			if (operation == "")
				chk3 = false;
			if (chk1 && chk2 && chk3) {
				int num1 = Integer.parseInt(op1);
				int num2 = Integer.parseInt(op2);
				if (operation == "+") {
					jlb3.setText(Integer.toString(num1 + num2));
				} else if (operation == "-") {
					jlb3.setText(Integer.toString(num1 - num2));
				} else if (operation == "*") {
					jlb3.setText(Integer.toString(num1 * num2));
				} else if (operation == "/") {
					jlb3.setText(Float.toString((float)num1 / num2));
				}
				
			} else {
				jlb3.setText("ERROR");
			}
		}
	}
	
	public boolean check(String name) {
		boolean check = true;
		char[] args = name.toCharArray();
		for (int i = 0; i < name.length(); i++) {
			if (args[i] < '0' || args[i] > '9') {
				check = false;
				break;
			}
		}
		return check;
	}
	
	public EasyCalculator() {
		//p1 = new JPanel();
		//p2 = new JPanel();
		
		jlb1 = new JLabel();
		jlb2 = new JLabel("=", JLabel.CENTER);
		jlb3 = new JLabel();
		jlb1.setHorizontalAlignment(JLabel.CENTER);
		jlb3.setHorizontalAlignment(JLabel.CENTER);
		jlb1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		jlb2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		jlb3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		jtf1 = new JTextField(8);
		jtf2 = new JTextField(8);
		jtf1.setHorizontalAlignment(JTextField.CENTER);
		jtf2.setHorizontalAlignment(JTextField.CENTER);
		jtf1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		jtf2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		jb1 = new JButton("+");
		jb2 = new JButton("-");
		jb3 = new JButton("*");
		jb4 = new JButton("/");
		jb5 = new JButton("OK");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		
		
		/*p1.add(jtf1);
		p1.add(jlb1);
		p1.add(jtf2);
		p1.add(jlb2);
		p1.add(jlb3);
		
		p2.add(jb1);
		p2.add(jb2);
		p2.add(jb3);
		p2.add(jb4);
		p2.add(jb5);*/
		
		this.add(jtf1);
		this.add(jlb1);
		this.add(jtf2);
		this.add(jlb2);
		this.add(jlb3);
		
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		
		//this.add(p1);
		//this.add(p2);
		
		this.setLayout(new GridLayout(2,5));
		this.setTitle("Easy Calculator");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
}
