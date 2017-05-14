package com.GreenDragon.Calc;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class Calc {
	
	private long Inumber1	= 0;
	private long Fnumber1	= 0;
	
	private long Inumber2	= 0;
	private long Fnumber2	= 0;
	
	private boolean setFirstNumber	= true;
	private boolean setIntPartNumber	= true;
	
	private char selSing	= 0;
	
	JTextField txt1	= null;
	JTextField txt2	= null;
	JLabel txtResult	= null;

	public void showNumber1() {
		if (this.txt1==null) {
			return;
		}
		StringBuffer t	=  new StringBuffer();
		t.append(this.Inumber1);
		t.append('.');
		t.append(this.Fnumber1);
		this.txt1.setText(t.toString());
	}

	public void showNumber2() {
		if (this.txt2==null) {
			return;
		}
		StringBuffer t	=  new StringBuffer();
		t.append(this.Inumber2);
		t.append('.');
		t.append(this.Fnumber2);
		this.txt2.setText(t.toString());
	}
	
	public void addNumber(int n) {
		if (n>10) {
			return;
		}
		if (this.setFirstNumber) {
			if (this.Inumber1<0) {
				n	= -n;
				}
			if (this.setIntPartNumber) {
				this.Inumber1	= this.Inumber1*10;
				this.Inumber1	= this.Inumber1+n;
				}
			else {
				this.Fnumber1	= this.Fnumber1*10;
				this.Fnumber1	= this.Fnumber1+n;
				}
			showNumber1();
			}
		else {
			if (this.Inumber2<0) {
				n	= -n;
				}
			if (this.setIntPartNumber) {
				this.Inumber2	= this.Inumber2*10;
				this.Inumber2	= this.Inumber2+n;
				}
			else {
				this.Fnumber2	= this.Fnumber2*10;
				this.Fnumber2	= this.Fnumber2+n;
				}
			showNumber2();
		}
	}
	
	public void changeSingNumber() {
		if (this.setFirstNumber) {
			this.Inumber1	= -this.Inumber1;
			this.Fnumber1	= -this.Fnumber1;
			showNumber1();
		}
		else {
			this.Inumber2	= -this.Inumber2;
			this.Fnumber2	= -this.Fnumber2;
			showNumber2();
		}
	}

	public void setPartNumber(boolean b) {
		this.setIntPartNumber	= b;
	}

	public void setSelectNumber(boolean b) {
		this.setFirstNumber	= b;
	}
	
	public void setSing(char c) {
		this.selSing	= c;
		if (c=='q') {
			showResult();
		}
		else {
			setSelectNumber(false);
			setPartNumber(true);
			}
	}
	
	public void setNumber1(long l) {
		this.Inumber1	= l;
	}

	public void setNumber1(double d) {
		double rest	= d%1;
		this.Inumber1	= (long)(d-rest);
		while (rest%1!=0) {
			rest	= rest*10;
		}
		this.Fnumber1	= (long)rest;
	}
	
	public void setFNumber1(long l) {
		this.Fnumber1	= l;
	}
	
	public void setNumber2(long l) {
		this.Inumber2	= l;
	}

	public void setNumber2(double d) {
		double rest	= d%1;
		this.Inumber2	= (long)(d-rest);
		while (rest%1!=0) {
			rest	= rest*10;
		}
		this.Fnumber2	= (long)rest;
	}
	
	public void setFNumber2(long l) {
		this.Fnumber2	= l;
	}
	
	public double getResult() {
		double res = 0;
		long fn1	= this.Fnumber1;
		long fn2	= this.Fnumber2;
		long fn	= 0;
		if (fn1>fn2) {
			fn	= fn1;
		}
		else {
			fn	= fn2;
		}
		int ndn	= 0;
		long n1	= this.Inumber1;
		long n2	= this.Inumber2;	
		while (fn!=0) {
			fn	= fn/10;
			ndn	= ndn+2;
			n1	= n1*10;
			n2	= n2*10;
		}
		n1	= n1+fn1;
		n2	= n2+fn2;
		switch (this.selSing) {
		case '+':
			res	= n1+n2;
			break;
		case '-':
			res	= n1-n2;
			break;
		case '*':
			res	= n1*n2;
			break;
		case '/':
			res	= (double)n1/n2;
			break;
		case 'q':
			res	= Math.sqrt(n1);
			break;			
		}
		for (int i=0;i<ndn;i++) {
			res	= res/10;
		}
		return res;
	}
	
	public void showResult() {
		if (this.txtResult==null) {
			return;
		}
		double res	= getResult();
		if (this.selSing=='q') {
			StringBuffer t	=  new StringBuffer();
			t.append('s');
			t.append('q');
			t.append('r');
			t.append('t');
			t.append('(');
			t.append(this.Inumber1);
			t.append('.');
			t.append(this.Fnumber1);
			t.append(')');
			t.append('=');
			t.append(res);
			this.txtResult.setText(t.toString());
		}
		else {
			StringBuffer t	=  new StringBuffer();
			t.append(this.Inumber1);
			t.append('.');
			t.append(this.Fnumber1);
			t.append(this.selSing);
			t.append(this.Inumber2);
			t.append('.');
			t.append(this.Fnumber2);
			t.append('=');
			t.append(res);
			this.txtResult.setText(t.toString());
			}
		setSelectNumber(true);
		setPartNumber(true);
		this.Inumber1	= 0;
		this.Fnumber1	= 0;
		showNumber1();
		this.Inumber2	= 0;
		this.Fnumber2	= 0;
		showNumber2();
	}
	
	public void show() {
		try {
			LookAndFeel laf	= new MetalLookAndFeel();
			UIManager.setLookAndFeel(laf);
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame frame	= new JFrame("Calc");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		Container fc	= frame.getContentPane();
		
		BoxLayout blY	= new BoxLayout(fc,BoxLayout.Y_AXIS);
		frame.setLayout(blY);
		
		this.txt1	 = new JTextField('0');
		fc.add(txt1);

		this.txt2	 = new JTextField('0');
		fc.add(txt2);

		this.txtResult	 = new JLabel("Результат:");
		fc.add(txtResult);
		
		Border b_panel	= BorderFactory.createRaisedBevelBorder();
		
		JPanel panel	= new JPanel();
		panel.setBorder(b_panel);
		BoxLayout blX	= new BoxLayout(panel,BoxLayout.X_AXIS);
		panel.setLayout(blX);
		
		JPanel panelNumber	= new JPanel();
		panelNumber.setBorder(b_panel);
		GridLayout gl4x3	= new GridLayout(4,3);
		panelNumber.setLayout(gl4x3);
		
		CalcActionListener cal	= new CalcActionListener(this);
		
		JButton button1	= new JButton("1");
		button1.addActionListener(cal);
		panelNumber.add(button1);
		JButton button2	= new JButton("2");
		button2.addActionListener(cal);
		panelNumber.add(button2);
		JButton button3	= new JButton("3");
		button3.addActionListener(cal);
		panelNumber.add(button3);
		JButton button4	= new JButton("4");
		button4.addActionListener(cal);
		panelNumber.add(button4);
		JButton button5	= new JButton("5");
		button5.addActionListener(cal);
		panelNumber.add(button5);
		JButton button6	= new JButton("6");
		button6.addActionListener(cal);
		panelNumber.add(button6);
		JButton button7	= new JButton("7");
		button7.addActionListener(cal);
		panelNumber.add(button7);
		JButton button8	= new JButton("8");
		button8.addActionListener(cal);
		panelNumber.add(button8);
		JButton button9	= new JButton("9");
		button9.addActionListener(cal);
		panelNumber.add(button9);
		JButton button0	= new JButton("0");
		button0.addActionListener(cal);
		panelNumber.add(button0);
		JButton buttonP	= new JButton(".");
		buttonP.addActionListener(cal);
		panelNumber.add(buttonP);
		JButton buttonPM	= new JButton("+/-");
		buttonPM.addActionListener(cal);
		panelNumber.add(buttonPM);
		
		panel.add(panelNumber);

		JPanel panelAction	= new JPanel();
		panelAction.setBorder(b_panel);
		GridLayout gl3x2	= new GridLayout(3,2);
		panelAction.setLayout(gl3x2);
		
		JButton buttonPlus	= new JButton("+");
		buttonPlus.addActionListener(cal);
		panelAction.add(buttonPlus);
		JButton buttonMinus	= new JButton("-");
		buttonMinus.addActionListener(cal);
		panelAction.add(buttonMinus);
		JButton buttonMultiply	= new JButton("*");
		buttonMultiply.addActionListener(cal);
		panelAction.add(buttonMultiply);
		JButton buttonDivide	= new JButton("/");
		buttonDivide.addActionListener(cal);
		panelAction.add(buttonDivide);
		JButton buttonSqrt	= new JButton("sqrt");
		buttonSqrt.addActionListener(cal);
		panelAction.add(buttonSqrt);
		JButton buttonCalc	= new JButton("=");
		buttonCalc.addActionListener(cal);
		panelAction.add(buttonCalc);
	
		panel.add(panelAction);
		
		fc.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		
		showNumber1();
		showNumber2();
	}
}
