package com.qa.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	
	// Declare how many Buttons we need and what they are
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	// Declare Font and Style
	Font myFont = new Font("Comic Sans", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	// Main Calculator Constructor
	Calculator(){
		frame = new JFrame("Peter's Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		// Text Fields
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		// All our Function Buttons
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("M");
		
		// Add buttons to an Array
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for (int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			
		}
		
		delButton.setBounds(25,430,85,50);
		clrButton.setBounds(125,430,85,50);
		equButton.setBounds(225,430,150,50);
		
		// Create New Panel
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 8, 8));
		panel.setBackground(Color.BLUE);
		
		// Add Numbers and Other Buttons to Panel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(negButton);
		panel.add(divButton);
		
		// Add the Buttons to the Frame (Bottom)
		frame.add(panel);
		frame.add(equButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	 public static void main(String[] args) {
		 
		 @SuppressWarnings("unused")
		Calculator calc = new Calculator();
	 }
	
	 
	 // Override was here but was causing an error
	 // @Override
	 public void actionPerformed(ActionEvent e) {
		 
		 for(int i=0; i < 10; i++) {
			 if(e.getSource() == numberButtons[i]) {
				 textfield.setText(textfield.getText().concat(String.valueOf(i)));
			 }
		 }
		 // Decimal Point IF Statement
		 if(e.getSource()==decButton) {
			 textfield.setText(textfield.getText().concat("."));
		 }
		// Addition IF Statement
		 if(e.getSource()==addButton) {
			 num1 = Double.parseDouble(textfield.getText());
			 operator = '+';
			 textfield.setText("");
		 }
		 // Subtraction IF Statement
		 if(e.getSource()==subButton) {
			 num1 = Double.parseDouble(textfield.getText());
			 operator = '-';
			 textfield.setText("");
		 }
		 // Multiply IF Statement
		 if(e.getSource()==mulButton) {
			 num1 = Double.parseDouble(textfield.getText());
			 operator = '*';
			 textfield.setText("");
		}
		 // Division IF Statement
		 if(e.getSource()==divButton) {
			 num1 = Double.parseDouble(textfield.getText());
			 operator = '/';
			 textfield.setText("");
		}
		 // EQUALS IF Statement
		 if(e.getSource()==equButton) {
			 num2 = Double.parseDouble(textfield.getText());
			 
			 // Switch Statement for the Operators & their functions
			 switch(operator) {
			 //ADDITION
			 case'+':
				 result = num1 + num2;
				 break;
			 //SUBTRACTION
			 case'-':
				 result = num1 - num2;
				 break;
			 //MULTIPLICATION
			 case'*':
				 result = num1 * num2;
				 break;
			 //DIVISION
			 case'/':
				 result = num1 / num2;
				 break;
			 }
			 textfield.setText(String.valueOf(result));
			 // Push result to num1 so that we can use it again.
			 num1 = result;
		}
		// CLEAR Button IF Statement
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		// DELETE Button IF Statement
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for (int i = 0; i < string.length()-1; i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		// NEGATIVE Number Button IF STatement
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	 }
}