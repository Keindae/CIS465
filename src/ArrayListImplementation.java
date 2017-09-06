
/**
 * Write a description of class LanguageArrayList here.
 *	GenerateStrings to create an array list of strings.
 * @author Matt Noblett
 * @version 9/5/2017
 */
import java.util.ArrayList;
public class ArrayListImplementation
{
	private String[ ] alphabet;
	private Object[ ] language;
	private int       generations;


	public ArrayListImplementation( String[ ] alphabet, int generations )
	{
		this.alphabet    = alphabet;
		this.generations = generations;

		this.language = new Object[ this.generations + 1];
		for (int n = 0; n <= this.generations; n++ )
		{
			this.language[ n ] = new ArrayList<String>( );            
		}

		this.generateStrings( );
	}


	private void generateStrings( )
	{
		//TO DO.  Implement this method to generate the languages given in the homework description.
		//        Implement this method with language defined as a field for a generic array of
		//        rows so that this.Object[ row ] is an ArrayList of Strings.
		
		//Create a blank new array list to add each piece of the words that are being created. 
		ArrayList<String> newArray = new ArrayList<String>(1);
		newArray.add("");
		
		for(int i = 0; i<= this.generations; i++){
			if(i == 0){
				this.language[i] = newArray;
			}
			else{
				ArrayList<String> newWordArray = new ArrayList<String>();
				//For each loop to loop through the language
				for(String word : (ArrayList<String>)this.language[i-1]){
					//Foreach loop to loop through the alphabet that is created
					for(String letter : this.alphabet){
						//Adds the new created word to the neWordArray
						newWordArray.add(word+letter);
					}
				}
				//Setting the language[i] to the newly created word
				this.language[i] = newWordArray;
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
			System.out.println( (ArrayList<String>)this.language[ n ] );
		}                
	}

	public static void main( String[] args )
	{
		String[ ] alphabet1 = { "$" };        
		ArrayListImplementation language1 = new ArrayListImplementation( alphabet1, 9 );
		language1.print( );
		System.out.println( );

		String[] alphabet2 = { "0", "1" };        
		ArrayListImplementation language = new ArrayListImplementation( alphabet2, 4 );
		language.print( );
		System.out.println( );

		String[ ] alphabet3 = { "a", "b", "c" };        
		ArrayListImplementation language3 = new ArrayListImplementation( alphabet3, 3 );
		language3.print( );
	}
}