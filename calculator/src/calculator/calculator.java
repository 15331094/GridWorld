package calculator;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.border.TitledBorder;
public class calculator extends JFrame {
    JButton[] b = new JButton[10];
    
    public calculator(){ 
        super("Easy Calculator");
        final JTextField op1 = new JTextField("12",JTextField.CENTER);
        final JTextField op2 = new JTextField("2",JTextField.CENTER);
        op1.setHorizontalAlignment(JTextField.CENTER);
        op2.setHorizontalAlignment(JTextField.CENTER);
        final JLabel label = new JLabel("",JLabel.CENTER);
        final JLabel result = new JLabel("",JLabel.CENTER);
        JLabel equal = new JLabel("=", JLabel.CENTER);
        TitledBorder nameTitle =new TitledBorder(""); 
        label.setBorder(nameTitle);
        result.setBorder(nameTitle);
        equal.setBorder(nameTitle);
        b[0] = new JButton("12");
		b[1] = new JButton("");
		b[2] = new JButton("2");
		b[3] = new JButton("=");
		b[4] = new JButton("");
		b[5] = new JButton("+");
		b[6] = new JButton("-"); 
		b[7] = new JButton("*");
		b[8] = new JButton("/");
		b[9] = new JButton("OK"); 
        setLayout(new GridLayout(2,5,8,8));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        for(int i = 5; i < 9; i++) {
	        b[i].addActionListener(new ActionListener() {
	        	 @Override
	             public void actionPerformed(ActionEvent e) {
	                 JButton temp = (JButton)e.getSource();
	        		 //text[0].setText(temp.getLabel());
	                 label.setText(temp.getLabel());
	             }
	        });
        }
        b[9].addActionListener(new ActionListener() {
       	 @Override
            public void actionPerformed(ActionEvent e) {
       		   try{
	                if (label.getText().equals("*")) {
	                	result.setText(Double.parseDouble(op1.getText())*Double.parseDouble(op2.getText())+"");
	                }
	                else if (label.getText().equals("/")){
	                	result.setText(Double.parseDouble(op1.getText())/Double.parseDouble(op2.getText())+"");
	                }
	                else if (label.getText().equals("+")){
	                	result.setText(Double.parseDouble(op1.getText())+Double.parseDouble(op2.getText())+"");
	                }
	                else if (label.getText().equals("-")){
	                	result.setText(Double.parseDouble(op1.getText())-Double.parseDouble(op2.getText())+"");
	                }
	                else {
	                	result.setText("");
	                }
               } 
       		   catch(Exception err) {
       		 	    result.setText("wrong input!");
       		   }
       	    }
       	 
       });
        
        
        add(op1);
        add(label);
        add(op2);
        add(equal);
        add(result);
        add(b[5]);
        add(b[6]);
        add(b[7]);
        add(b[8]);
        add(b[9]);
        

        pack(); 
        setSize(500,200); 
        setLocation(100,200); 
        //setBounds(200.100,300,100);  
        setVisible(true);    
    }
    

    public static void main(String[] args) {
    	
        new calculator(); 
        
        return;
    } 
} 