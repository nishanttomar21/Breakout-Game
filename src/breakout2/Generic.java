package breakout2;

public class Generic extends Play
{

	// Default Constructor.
	public Generic()
	{
		
		Integer[] a = { 1, 2, 3 };
		
		Character[] b = { 'a', 'b', 'c' };
		
		System.out.print("\n\n-------------------------------------------------------\n\nGENERIC FUNCTION:");
		System.out.println("\n\nInteger:");
		
		// Generic Function Calling ( Integer Type ).
		printMe( a );
		
		System.out.println("Character:");
		
		// Generic Function Calling ( Charavter Type ).
		printMe( b );
		
		System.out.print("-------------------------------------------------------\n\n");
				
	}
	
	
	// Generic Function.
	public static <T> void printMe( T[] x )
	{
		                                                                                                                                                                                                                                                                                                                                                                      
		// Enhanced For Loop.
		for( T b : x )
			System.out.printf("%s  ",b);
		
		System.out.print("\n\n");
		
	}	

}
