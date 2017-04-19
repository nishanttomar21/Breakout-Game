/*


Programme Conceptualised And Developed By:
Nishant Tomar	:  14103229	
Dipak Rai		:  14103214
Keshav Bansal	:  14103231
Anshika Singhal	:  14103253


Batch:     B7

UNIVERSITY :  JIIT, NOIDA SECTOR 62

Project Title: Break-Out Game
Copyright:  2015

Last Update On: 24.11.2015
All Rights Reserved To The 4 Programmers Of This Program Only

Concepts Used:

	Aggregation Relationship
	Polymorphism
	Generic Function
	Exception Handling
	Association Relationship
	Final Keyword
	Abstract Class
	Static Keyword
	Inheritance
	Multiple Inheritance
	Graphics
	Function Overloading


*/

package breakout2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BreakoutGame extends Application
{
	
	public double height;
	public double width;
	
	
	public static void main( String[] args )
	{
		
		System.out.print("TOTAL LIVES: 3\n\n");
		BreakoutGame b = new BreakoutGame();
		final ImageIcon icon = new ImageIcon("/Users/nishanttomar21/Documents/workspace/breakout2/src/images/5.jpg");
		JOptionPane.showMessageDialog(null, "", "GAME!", JOptionPane.INFORMATION_MESSAGE, icon);
		
		// Calling Abstract Function.
		b.getWidth();
		b.getHeight();
		
		// Creating Object.
		// Association Property.
		Play p = new Play();
		
		JFrame f = new JFrame();
		f.add(p);
		f.setSize((int)b.width , (int)b.height);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("BREAKOUT!");
		
	}
	
	// Function To Get Width Of The Application.
	public void getWidth()
	{
		
		width = 400;
	
	}
	
	// Function To Get Height Of The Application.
	public void getHeight()
	{
		
		height = 600;
		
	}
	

}