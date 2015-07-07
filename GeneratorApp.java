package password_Generator;

import javax.swing.JFrame;
import password_Generator.GeneratorPanel;

@SuppressWarnings("serial")
public class GeneratorApp extends JFrame
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Password Generator");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().add(new GeneratorPanel()); 
        frame.pack();
        frame.setVisible(true);
	}
	
}
