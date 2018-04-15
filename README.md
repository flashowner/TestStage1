# TestStage1
实训第一阶段资源


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EasyCalculator extends JFrame implements ActionListener {
	// Label for operation, =, result
	private JLabel jlb1, jlb2, jlb3;
	// Textfield for input number
	private JTextField jtf1, jtf2; 
	// Button
	private JButton jb1, jb2, jb3, jb4, jb5; 
	
	public static void main(String[] args) {
		// Run the JFrame
		EasyCalculator easy = new EasyCalculator(); 
	}
	
	public void actionPerformed(ActionEvent e) {
		// judge the button text
		if (e.getActionCommand().equals("+")) {
			// Set the label text 
			jlb1.setText("+"); 
		} else if (e.getActionCommand().equals("-")) {
			jlb1.setText("-");
		} else if (e.getActionCommand().equals("*")) {
			jlb1.setText("*");
		} else if (e.getActionCommand().equals("/")) {
			jlb1.setText("/");
		} else if (e.getActionCommand().equals("OK")) {
			String operation = jlb1.getText();
			String op1 = jtf1.getText();
			String op2 = jtf2.getText();
			boolean chk1 = check(op1);
			boolean chk2 = check(op2);
			boolean chk3 = true;
			if (operation.equals(""))
				chk3 = false;
			if (chk1 && chk2 && chk3) {
				int num1 = Integer.parseInt(op1);
				int num2 = Integer.parseInt(op2);
				if (operation.equals("+")) {
					jlb3.setText(Integer.toString(num1 + num2));
				} else if (operation.equals("-")) {
					jlb3.setText(Integer.toString(num1 - num2));
				} else if (operation.equals("*")) {
					jlb3.setText(Integer.toString(num1 * num2));
				} else if (operation.equals("/")) {
					jlb3.setText(Float.toString((float)num1 / num2));
				}
				
			} else {
				jlb3.setText("ERROR");
			}
		}
	}
	
	// check if the input text is number
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
		final int number = 8;
		
		jlb1 = new JLabel();
		jlb2 = new JLabel("=", JLabel.CENTER);
		jlb3 = new JLabel();
		// Make the input text in the center
		jlb1.setHorizontalAlignment(JLabel.CENTER);
		jlb3.setHorizontalAlignment(JLabel.CENTER);
		// Add the gray border to the label edge
		jlb1.setBorder(BorderFactory.createLineBorder(Color.GRAY)); 
		jlb2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		jlb3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		// The largest allowed number is 99999999		
		jtf1 = new JTextField(number);
		jtf2 = new JTextField(number); 
		// Make the input text in the center
		jtf1.setHorizontalAlignment(JTextField.CENTER);
		jtf2.setHorizontalAlignment(JTextField.CENTER);
		// Add the gray border to the label edge
		jtf1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		jtf2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		jb1 = new JButton("+");
		jb2 = new JButton("-");
		jb3 = new JButton("*");
		jb4 = new JButton("/");
		jb5 = new JButton("OK");
		// Add action listener to the button
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		
		// Add components to the JFrame
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
		
		// Make the Layout 2 rows 5 columns
		this.setLayout(new GridLayout(2,5));
		// Set the title
		this.setTitle("Easy Calculator");
		// Set the JFrame size
		this.setSize(400, 200);
		// Set the position to the center
		this.setLocationRelativeTo(null);
		// Make the default close operation JFrame close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Make JFrame visible
		this.setVisible(true);
		// Make the user can't resize the JFrame
		this.setResizable(false);
	}
}
