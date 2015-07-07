package password_Generator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")

public class GeneratorPanel extends JPanel implements ActionListener
{
	private final int HEIGHT = 50, WIDTH = 450, FONT_SIZE = 30;
	private JLabel call1, call2;
	private JButton controls[], create, clearField, clearPass;
	private JPanel controlsPad, callPad;
	static JTextField numbers;
	static int digit [];
	private JTextField display;
	private boolean foundKey;

	public GeneratorPanel()
	{
		call1 = new JLabel ("Please, specify the number");		
		call1.setFont(new Font ("Times New Roman", Font.BOLD, FONT_SIZE));
		call1.setVerticalAlignment(JLabel.CENTER);
		call1.setHorizontalAlignment(JLabel.CENTER);
		
		call2 = new JLabel ("of characters in your password");
		call2.setFont(new Font ("Times New Roman", Font.BOLD, FONT_SIZE));
		call2.setVerticalAlignment(JLabel.CENTER);
		call2.setHorizontalAlignment(JLabel.CENTER);
		
		numbers = new JTextField(16);							// displays user input
		numbers.setFont(new Font ("Times New Roman", Font.BOLD, FONT_SIZE));
		numbers.setHorizontalAlignment(JLabel.CENTER);
		numbers.setBorder (BorderFactory.createLineBorder (Color.black, 1));
		numbers.setPreferredSize (new Dimension (WIDTH, HEIGHT));
		numbers.setEditable(true);
		
		display = new JTextField(16);							// displays password
		display.setFont(new Font ("Times New Roman", Font.BOLD, FONT_SIZE));
		display.setHorizontalAlignment(JLabel.CENTER);
		display.setBorder (BorderFactory.createLineBorder (Color.black, 1));
		display.setPreferredSize (new Dimension (WIDTH, HEIGHT*2));
		display.setEditable(false);
		
		callPad = new JPanel();									// groups panels
		callPad.setLayout(new GridLayout(3,1));					// grid layout for top panels
		callPad.setBorder (BorderFactory.createLineBorder (Color.black, 3));
		callPad.setPreferredSize (new Dimension (WIDTH, HEIGHT*3));
		
		controlsPad = new JPanel();								// groups buttons
		controlsPad.setLayout(new GridLayout(1,3));		// grid layout for the keypad
		controlsPad.setBorder (BorderFactory.createLineBorder (Color.black, 3));
		controlsPad.setPreferredSize (new Dimension (WIDTH, HEIGHT*3));
		
		create = new JButton ("Create");						// enter button
		create.setFont(new Font ("Times New Roman", Font.BOLD, FONT_SIZE / 2));
		create.setBorder (BorderFactory.createLineBorder (Color.black, 2));
		create.setPreferredSize (new Dimension (WIDTH/3, HEIGHT));
		
		clearField = new JButton("Delete");						// clear user input button
		clearField.setFont(new Font ("Times New Roman", Font.BOLD, FONT_SIZE / 2));
		clearField.setBorder (BorderFactory.createLineBorder (Color.black, 2));
		clearField.setPreferredSize (new Dimension (WIDTH/3, HEIGHT));
		
		clearPass = new JButton("Clear Password");				// clear password field button
		clearPass.setFont(new Font ("Times New Roman", Font.BOLD, FONT_SIZE / 2));
		clearPass.setBorder (BorderFactory.createLineBorder (Color.black, 2));
		clearPass.setPreferredSize (new Dimension (WIDTH/3, HEIGHT));
		
		setBackground(Color.blue);
		setLayout(new BorderLayout());							// border layout for the whole		
		
		callPad.add(call1, BorderLayout.NORTH);
		callPad.add(call2, BorderLayout.CENTER);
		callPad.add(numbers, BorderLayout.SOUTH);
		
		controls = new JButton[3];								// key buttons
		
		controls[0] = clearField;						// creates buttons
		controls[1] = clearPass;
		controls[2] = create;
	
		for (int i = 0; i <= 2; i++)				
		{
			controlsPad.add(controls[i]);					// adds buttons
		}// end for
		
		add(callPad, BorderLayout.NORTH); 					// adds display field to the top
		add(display, BorderLayout.CENTER); 					// adds numbers field to the center
		add(controlsPad, BorderLayout.SOUTH);				// adds keypad to the center
		
		clearField.addActionListener(this);					// adds functionality to clear entry button
		create.addActionListener(this);						// adds functionality to enter button
		clearPass.addActionListener(this);					// adds functionality to clear password button
		
	}// end constructor
	
	public void actionPerformed(ActionEvent event)			// button listener
	{
		foundKey = false;
		
		if (event.getSource() == clearField)				// for clear entry button
		{
	        numbers.setText("");
	    }// end if
		
		if (event.getSource() == clearPass)					// for clear password button
		{
	        display.setText("");
	    }// end if
		
		if (event.getSource() == create && !foundKey)		// for enter button
		{
			display.setText(new String(Generator.generate(1, 1, 1)));
	    }// end if
						
	}// end method
	
}// end class

