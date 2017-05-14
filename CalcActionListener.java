package com.GreenDragon.Calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalcActionListener implements ActionListener {
	
	private Calc calc = null;
	
	public CalcActionListener(Calc c) {
		this.calc	= c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!(e.getSource() instanceof JButton)) {
			return;
		}
		JButton button = (JButton) e.getSource();
		switch (button.getText()) {
		case "1":
			this.calc.addNumber(1);
			break;
		case "2":
			this.calc.addNumber(2);
			break;
		case "3":
			this.calc.addNumber(3);
			break;
		case "4":
			this.calc.addNumber(4);
			break;
		case "5":
			this.calc.addNumber(5);
			break;
		case "6":
			this.calc.addNumber(6);
			break;
		case "7":
			this.calc.addNumber(7);
			break;
		case "8":
			this.calc.addNumber(8);
			break;
		case "9":
			this.calc.addNumber(9);
			break;
		case "0":
			this.calc.addNumber(0);
			break;
		case "+/-":
			this.calc.changeSingNumber();
			break;
		case ".":
			this.calc.setPartNumber(false);
			break;
		case "+":
			this.calc.setSing('+');
			break;
		case "-":
			this.calc.setSing('-');
			break;
		case "*":
			this.calc.setSing('*');
			break;
		case "/":
			this.calc.setSing('/');
			break;
		case "sqrt":
			this.calc.setSing('q');
			break;
		case "=":
			this.calc.showResult();
			break;
		}
 	}

}
