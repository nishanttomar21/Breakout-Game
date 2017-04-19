package breakout2;

// All Import Files.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Play extends JPanel implements ActionListener, KeyListener
{
	
	// All Data Member Declarations.
    // Calls paintComponent() & actionPerformed() After Every 20 Milliseconds.
    Timer time = new Timer(20, this);
    public final int width = 400;
    private final int height = 600;
    private final double paddle_offset = 70;
    private final double width_paddle = 10;
    private final double brick_offset = 30;
    private final double length_paddle = 70;
    private final double number_bricks_per_row = 10;
    private final double number_rows_brick = 10;
    private final double brick_seperation = 4;
    private final double brick_height = 8;
    private final double brick_width = (width - (number_rows_brick - 1) * brick_seperation) / (number_bricks_per_row);
    private double velocity_ball = 3.0;
    private double velocity_paddle = 30;
    private double h = velocity_ball;
    private final double diameter_ball = 11;
    private double paddlex = ((width/2) - (length_paddle/2));
    private double paddley = (height - paddle_offset);
    private double velPaddlex = 0;
    private double velBallx = 0;
    private double velBally = 0;
    private double ballx = (paddlex + (length_paddle/2 - diameter_ball/2));
    private double bally = ((paddley - diameter_ball) - 1);
    private int e = 1;
    private int i = 0;
    private int j = 1;
    private int k = 1;
    private int l = 1;
    private int d = 0;
    private int a = 0;
    private int f = 0;
    private double w;
    private double x;
    private double y;
    private double z;
    private int temp = 0;
    private int temp1 = 0;
    private int level1 = 1;
    private int level2 = 0;
    public int lives = 3;
    private Ellipse2D ball;
    private ImageIcon icon;
    public int score = 0;
    private int[][] array = new int[100][2];
    private int[][] array2 = new int[20][2]; 
	private static final Exception InvalidKeyPreseed = null;
	Login log;
    
    
    
// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    

	
    
    // Default Constructor.
    public Play()
    {
        
        // Timer Starts.
        time.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);      
           
    }


	// Function Where All The Graphics Are Done.
    public void paintComponent( Graphics g )
    {
        
        super.paintComponent(g);
        setLayout(null);
        Graphics2D g2 = (Graphics2D) g;
        this.setBackground(Color.white);
        g.setColor(Color.BLUE);
        g.fillRoundRect((int)paddlex, (int)paddley, (int)length_paddle, (int)width_paddle, 10, 10);
        g.setColor(Color.BLACK);
        ball = new Ellipse2D.Double(ballx, bally, (int)diameter_ball, (int)diameter_ball);
        g2.fill(ball);
        
        // To Make Bricks ( Level 1 ).
        if( level1 == 1 )
        {
        
        	for( int rows = 0 ; rows < 2 ; rows += 1 )
        		for( int columns = 0 ; columns < number_bricks_per_row ; columns += 1 )
        		{
            	
        			switch( rows )
        			{
            	
            			case 0: g.setColor(Color.RED);
            				break;
                
            			case 1: g.setColor(Color.GREEN);
            				break;
            	
        			}
            	
        			// To Check If The Brick Is Already Hit Before.
        			for( int d = 0 ; d < f ; d++ )
        			{
                    
        				if( array2[d][0] == rows && array2[d][1] == columns )
        					temp1 = 1;
        				
                    
        				if( temp1 == 1 )
        					break;
                    
        			}
                
        			// If All The Bricks Are Broken.
        			if( f == 20 )
        			{
                	
        				velocity_ball = h;
        				
        				// Resetting The Position Of Ball.
        				resetBall();
        		        
        				level2 = 1;
        				level1 = 0;
        				score = 0;
        				icon = new ImageIcon("/Users/nishanttomar21/Documents/workspace/breakout2/src/images/7.jpg");
        				JOptionPane.showMessageDialog(null, "LEVEL 1 COMPLETE!|\nPRESS SPACE-BAR TO PLAY!", "Well Done!", JOptionPane.INFORMATION_MESSAGE, icon); 
        				break;
                	
        			}
                
        			// If Brick Is Already Hit Then Don't Make The Brick Again.
        			else if( temp1 == 1 )
        				temp1 = 0;
                
        			// Checks Which Brick Is Hit.
        			// Speed Of The Ball Will Boost Each Time You Break A Brick.
        			else if( ballx >= (int)(brick_width + brick_seperation) * columns && ballx <= (int)(brick_width + brick_seperation) * columns + brick_width && bally >= (int) ((int) brick_offset + (brick_height + brick_seperation) * rows) && bally <= (int) ((int) brick_offset + (brick_height + brick_seperation) * rows) + brick_width )
        			{
                    
        				score += 1;
        				velBally = - (velBally);								// Reverses The Direction.
        				
        				// Increases The Speed Of The Ball.
        				velBally += 0.5;
        				
        				velocity_ball +=  0.15;
        				array2[f][0] = rows;
        				array2[f][1] = columns;
        				f++;
                    
        			}
                
        			// Makes The Brick.
        			else
        				g.fill3DRect ((int)(brick_width + brick_seperation) * columns , (int) ((int) brick_offset + (brick_height + brick_seperation) * rows)+20 ,(int) brick_width , (int)brick_height, true);
            	
        		}
        
        }
    
        // To Make Bricks ( Level 2 ).        
        else if( level2 == 1 )
        {
        	 
        	for( int rows = 0 ; rows < number_rows_brick ; rows += 1 )
            	for( int columns = 0 ; columns < number_bricks_per_row ; columns += 1 )
            	{
                        	
                	// To Set The Color Of The Bricks.
                	switch( rows )
                	{
                        
                    	case 0: g.setColor(Color.BLACK);
                        	break;
                        
                    	case 1: g.setColor(Color.MAGENTA);
                        	break;
                        
                    	case 2: g.setColor(Color.CYAN);
                        	break;
                        
                    	case 3: g.setColor(Color.RED);
                        	break;
                        
                    	case 4: g.setColor(Color.GREEN);
                        	break;
                        
                    	case 5: g.setColor(Color.RED);
                        	break;
                        
                    	case 6: g.setColor(Color.YELLOW);
                        	break;
                        
                   		case 7: g.setColor(Color.LIGHT_GRAY);
                    		break;
                        
                    	case 8: g.setColor(Color.ORANGE);
                    		break;
                        
                    	case 9: g.setColor(Color.PINK);
                        	break;
                        
                    	default: break;
                        
                	}
                
                	// To Check If The Brick Is Already Hit Before.
                	for( int d = 0 ; d < a ; d++ )
                	{
                    
                    	if( array[d][0] == rows && array[d][1] == columns )
                        	temp = 1;
                    
                    	if( temp == 1 )
                    		break;
                    
                	}
                	
                	// If You Break All The Bricks.
                	if( a == 100 )
                	{
                		
        				// Resetting The Position Of Ball.
                		resetBall();
                		
                		icon = new ImageIcon("/Users/nishanttomar21/Documents/workspace/breakout2/src/images/7.jpg");
                		JOptionPane.showMessageDialog(null, "LEVEL 2 COMPLETE!|\n\nTHANK YOU FOR PLAYING!", "Well Done!", JOptionPane.INFORMATION_MESSAGE, icon);
                		
                		// Aggregation Property.
                		log = new Login();
                		
                		break;
                		
                	}
                
                	// If Brick Is Already Hit Then Don't Make The Brick Again.
                	else if( temp == 1 )
                		temp = 0;
                
                	// Checks Which Brick Is Hit.
                	// Speed Of The Ball Will Boost Each Time You Break A Brick.
                	else if( ballx >= (int)(brick_width + brick_seperation) * columns && ballx <= (int)(brick_width + brick_seperation) * columns + brick_width && bally >= (int) ((int) brick_offset + (brick_height + brick_seperation) * rows) && bally <= (int) ((int) brick_offset + (brick_height + brick_seperation) * rows) + brick_width )
                	{
                    
                		// Updating Score.
                    	score += 1;
                    	velBally = - (velBally);										// Reverses The Direction.
                    	velBally += 0.5;
                    	velocity_ball +=  0.15;
                    	array[a][0] = rows;
                    	array[a][1] = columns;
                    	a++;            
                    	
                	}
                
                	// Makes The Brick.
                	else
                		g.fill3DRect ((int)(brick_width + brick_seperation) * columns , (int) ((int) brick_offset + (brick_height + brick_seperation) * rows)+20 ,(int) brick_width , (int)brick_height, true);
                
            }
        
        }
       
    }
    
    
    // Function Where All The Actions Are Done.
    public void actionPerformed( ActionEvent e )
    {
        
        // If The Ball Hits The Paddle, Then Deflects It.
        if( ballx >= paddlex && ballx <= (paddlex + length_paddle) && bally >= (paddley - diameter_ball) )
        	velBally = - (velBally);												// Reverses The Direction.
        	    
        // If Paddle Hits The Side-Wall, Then Cannot Move Further.
        else if( PADDLEX() )
        {
            
            // So That The Paddle Doesn't Go Outside ( Left-Side ).
            if( paddlex < 0 && velPaddlex > 0 )
                velPaddlex = - (velPaddlex);										// Reverses The Direction.
            
            // So That The Paddle Doesn't Go Outside ( Right-Side ).
            else if( paddlex > (width - length_paddle) && velPaddlex < 0 )
                velPaddlex = - (velPaddlex);										// Reverses The Direction.
            
            velPaddlex = - (velPaddlex);											// Reverses The Direction.
            
        }
        
        // If Ball Hits On The Side-Wall, Then Deflects It.
        if( BALLX() )
        	velBallx = - (velBallx);												// Reverses The Direction.
        
        // If Ball Doesn't Hit The Paddle ( You Miss ).
        else if( bally > (height - 50) )
            gameOver();
        
        // If Ball Hits On The Top-Wall, Then Deflects It.
        else if( BALLY() )
        {
        
        	velBally = - (velBally);												// Reverses The Direction.
        	velBally += 0.5;
        	
        }
        	
        // Function Overloading.
        // New Position Of Ball.
        newPosition( ballx , bally );
        
        // New Position Of Paddle.
        newPosition( paddlex );
        
        // Re-Paints The Whole Application.
        repaint();
        
        if( i == 0 )
        {
            
            icon = new ImageIcon("/Users/nishanttomar21/Documents/workspace/breakout2/src/images/6.jpg");
            JOptionPane.showMessageDialog(null, "CLICK OK AND THEN HIT SPACE-BAR TO PLAY!\nPRESS UP ARROW: PAUSE\nPRESS DOWN ARROW: PLAY\n\n\nNOTE: SPEED OF THE BALL WILL BOOST EACH TIME YOU BREAK A BRICK!", "GO AHEAD!", JOptionPane.INFORMATION_MESSAGE, icon);
            i = 1;
            
        }
        
    }
    
    
    // New Position For The Ball.
    // Function Overloading.
    // Changing The Position Of The Paddle And The Ball After Every 20 milliseconds.
    private void newPosition( double x , double y )
    {
    	
        ballx += velBallx;
        bally += velBally;
    	
    }
    
    
    // New Position For The Paddle.
    public void newPosition( double z )
    {
    	
    	paddlex += velPaddlex;
    	velPaddlex = 0;
    	
    }
    
    // Function For Right Arrow key.
    public void right()
    {
        
        velPaddlex = velocity_paddle;
        
        // So That Ball Could Move Along The Paddle.
        if( l == 1 )
            ballx += velPaddlex;
        
    }
    
    
    // Function For Left Arrow key.
    public void left()
    {
        
        velPaddlex = -(velocity_paddle);
        
        // So That Ball Could Move Along The Paddle.
        if( k == 1 )
            ballx += velPaddlex;
        
    }
    
    
    // Function To Pause The Game.
    public void up()
    {
    	
        d = 1;
        
        // Saving The Velocities In Temporary Variables.
        if( e == 1 )
        {
            
            e = 0;
            w = velocity_paddle;
            x = velBallx;
            y = velBally;
            z = velPaddlex;
            
        }
        
        // Making All Velocities 0.
        velocity_paddle = 0;
        velBallx = 0;
        velBally = 0;
        velPaddlex = 0;
        
        JOptionPane.showMessageDialog(null, "GAME PAUSED!!\nPRESS DOWN ARROW TO CONTINUE!");
        
    }
    
    
    // Function To Play The Game.
    public void down()
    {
        
        // Retrieving All The Velocities Back.
        if( d == 1 )
        {
            
            velocity_paddle = w;
            velBallx = x;
            velBally = y;
            velPaddlex = z;
            d = 0;
            e = 1;
            
        }
        
    }
    
    
    // Function For SpaceBar.
    public void space()
    {
        
        // Only If New Game.
        if( ballx == (paddlex + (length_paddle/2 - diameter_ball/2)) && bally == ((paddley - diameter_ball) - 1) )
        {
            
            velBally = -(velocity_ball);
            velBallx = -(velocity_ball);
            System.out.println("GAME STARTED!!");
            
        }
        
        k = 0;
        l = 0;
        
    }
    
    
    // Function To Check Which Key Is Hit ( It Will Fire Once You Press The Key ).
    public void keyTyped( KeyEvent e ) {}
    
    
    // Function To Tell You Which Key Is Released ( It Will Only Fire When You Lift Your Finger Up ).
    public void keyReleased( KeyEvent e ) {}
    
    
    // Function To Check Which Key Is Hit ( It Will Fire Once You Press The Key ).
    public void keyPressed( KeyEvent e )
    {
    	
    	// Exception Handling.
        try
        {
        	
        	// Each Character Has Unique Code.
        	int code = e.getKeyCode();
        
        	// If Key Pressed Is Right Arrow.
        	if( code == KeyEvent.VK_RIGHT )  					// VK : Virtual Key
        		right();
        
        	// If Key Pressed Is Left Arrow.
        	else if( code == KeyEvent.VK_LEFT )					// VK : Virtual Key
        		left();
        
        	// If Key Pressed Is SpaceBar.
        	else if( code == KeyEvent.VK_SPACE )				// VK : Virtual Key
        		space();
        
        	// If Key Pressed Is Up.
        	else if( code == KeyEvent.VK_UP )					// VK : Virtual Key
        	{
        		
        		System.out.println("GAME PAUSED!");
        		up();
        		
        	}
        	
        
        	// If Key Pressed Is Down.
        	else if( code == KeyEvent.VK_DOWN )					// VK : Virtual Key
        	{
        		
        		System.out.println("GAME RESUMED!");
        		down();
        		
        	}
        
        	// If Any Key Other Than All The Above Is Fired.
        	else
        		throw InvalidKeyPreseed;
        
        }	
        
        // Catching The Error.
        catch(Exception error)
        {
        	
        	System.out.println("Exception: " + error);
        
        }
        
    }
    
    
    // Function To Check Side-Walls For The Paddle.	
    public boolean PADDLEX()
    {
        
        if( paddlex < 0 || paddlex > (width - paddle_offset) )
            return true;
        
        else
            return false;
        
    }
    
    
    // Function To Check Side-Walls For The Ball.	
    public boolean BALLX()
    {
        
        if( ballx < 0 || ballx > (width - diameter_ball) )
            return true;
        
        else
            return false;
        
    }
    
    
    // Function To Check Top-Wall For The Ball.	
    public boolean BALLY()
    {
        
        if( bally < 0 )
        	return true;
        
        else
            return false;
        
    }
    
    
    // Function To Reset The Ball Back On The Paddle. 	
    public void resetBall()
    {
        
        velBallx = 0;
        velBally = 0;
        ballx = (paddlex + (length_paddle/2 - diameter_ball/2));
        bally = ((paddley - diameter_ball) - 1);
        i = 0;
        resetBallPosition();
        
    }
    
    
    // Function To Resets The Position Of The Ball After End-Game.	
    public void resetBallPosition()
    {
        
        k = 1;
        l = 1;
        
    }
    
    
    // Function To End The Game.	
    public void endGame()
    {
        
        System.out.println("YOU LOST!!");
        System.out.println("LIVES REMAINING: " + lives);
        
        // Giving Memory To Login Page. 		
        Login a = new Login();
        
        a.setVisible(true);
        
    }
    
    
    // Function To Check Lives-Left.
    public void gameOver()
    {
        
        lives--;
        
        // If No Lives Are Left.
        if( lives == 0 )
        {
            
            icon = new ImageIcon("/Users/nishanttomar21/Documents/workspace/breakout2/src/images/4.gif");
            JOptionPane.showMessageDialog(null, "YOU LOST!!\nYOUR SCORE: "+score, "About", JOptionPane.INFORMATION_MESSAGE, icon);
            ballx = paddlex + (length_paddle/2 - diameter_ball/2);
            bally = (paddley - diameter_ball);
            velBallx = 0;
            velBally = 0;
            endGame();
            
        }
        
        // If You Have Lives-Left.
        else if( lives > 0 )
        {
            
            // If 2 Life Is Left.
            if( j == 1 )
                icon = new ImageIcon("/Users/nishanttomar21/Documents/workspace/breakout2/src/images/1.jpg");
            
            // If 1 Lives Are Left.
            else if( j == 2 )    
                icon = new ImageIcon("/Users/nishanttomar21/Documents/workspace/breakout2/src/images/2.jpg");
            
            System.out.println("GAME-OVER!\n"+"LIVES REMAINING: "+lives+"\nSCORE: "+score+"\n");
            JOptionPane.showMessageDialog(null, "GAME-OVER!\n"+"LIVES REMAINING: "+lives+"\nYOUR SCORE: "+score, "About", JOptionPane.INFORMATION_MESSAGE, icon);
            resetBall();
            
        }
        
        j++;
        
    }
    

}