import java.util.ArrayList;

public class ArrayImplementation
{
	private String[ ]    alphabet;
	private String[ ][ ] language;
	private int          generations;

	public ArrayImplementation(String[] alphabet, int generations )
	{
		this.alphabet    = alphabet;
		this.generations = generations;
		int columns = 1;
		this.language = new String[ this.generations + 1 ][ ];
		for (int row = 0; row <= this.generations; row++)
		{
			this.language[ row ] = new String[ columns ];
			columns             *= alphabet.length;
		}

		this.generateStrings();
	}

	private void generateStrings( )
	{

		//TO DO.  Implement this method to generate the languages given in the homework description.
		//        Implement this method with language defined as a field for a two-dimensional
		//        array of Strings, where the rows in this.language[ row ] are of variable length.
		//Set the base case.
		this.language[0][0] = "";
		//Loop through the size.
		for(int i = 1; i <= this.generations; i++){
			//Counter to increase the size of the "sliding window"
			int step = 0;
			//Loop through the row
			for(int j = 0; j < this.language[i-1].length; j++){
				//Loop through the alphabet part to create the words
				for(int h = 0; h < this.alphabet.length; h++){
					this.language[i][j+h+step] = this.language[i-1][j] + this.alphabet[h];
				}
				//Increment to increase the sliding window
				step+=this.alphabet.length-1;
			}
		}
	}

	private String stringFor( String[ ] str )
	{
		if (str.length == 0)
		{
			return "{ }";
		}

		String st = "{";
		for (String s: str)
		{
			st += " " + s + ",";
		}
		st = st.substring(0, st.length( )-1) + " }";
		return st;
	}

	public void print()
	{
		System.out.println( "A language with string lengths <= " + this.generations + " over alphabet " + stringFor( this.alphabet ) );
		for( int n = 0; n <= this.generations; n++ )
		{
			System.out.print( n + ": " );
			System.out.println( this.stringFor( this.language[ n ] ) );
		}                
	}

	public static void main( String[] args )
	{
		String[ ] alphabet1 = { "$" };        
		ArrayImplementation language1 = new ArrayImplementation( alphabet1, 9 );
		language1.print( );
		System.out.println( );
		System.out.println( );

		String[ ] alphabet2 = { "0", "1" };       
		ArrayImplementation language2 = new ArrayImplementation( alphabet2, 4 );
		language2.print( );
		System.out.println( );
		System.out.println( );

		String[ ] alphabet3 = { "a", "b", "c" };        
		ArrayImplementation language3 = new ArrayImplementation( alphabet3, 3 );
		language3.print( );
	}
}
