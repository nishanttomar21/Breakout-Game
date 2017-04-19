package breakout2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{

	// Default Package.
	JLabel enterName;
	JLabel a;
	JTextField name;
	JButton click;
	String storeName = "";
	ImageIcon icon;
		
	
	// Default Constructor.
	public Login()
	{
		
		setSize(300, 250);
		enterName = new JLabel("ENTER YOUR NAME: ");
		a = new JLabel("");
		click = new JButton("CLICK");
		name = new JTextField();
		enterName.setBounds(90, 50, 150, 30);
		a.setBounds(100, 100, 120, 30);
		name.setBounds(90, 80, 130, 30);
		click.setBounds(125, 150, 55, 35);
		click.addActionListener((ActionListener) this);
		setResizable(false);
		setLocationRelativeTo(null);
		add(click);
		add(name);
		add(enterName);
		add(a);
		
	}
	
	
	// Function To Do All The Actions.
	public void actionPerformed( ActionEvent e ) 
	{
		
		// If You Click On The Click Button.
		if( e.getSource() == click )
		{
		
			icon = new ImageIcon("/Users/nishanttomar21/Documents/workspace/breakout2/src/images/3.jpg");
			storeName = name.getText();
			JOptionPane.showMessageDialog(null, "Nice Play "+ storeName, "THE END!", JOptionPane.INFORMATION_MESSAGE, icon);
			
			// Creating Object For Generic Class().
			// Polymorphism Property.		
			Play gen = new Generic();
			
			// Exits The Game.
			System.exit(0);
		
		}
		
		
	}
	
	
}
