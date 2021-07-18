package Scrabble;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class ScrabbleCheater {
	public static void main(String[] args) throws FileNotFoundException {	
		String SEARCH_TERM = "Actress";
		int STRING_LIMITER = 7;
		
		Dictionary dictionary = new Dictionary();
		dictionary.ht.getEntry();
		dictionary.ht.getCollisions();
		System.out.println("The search term '" + SEARCH_TERM + "' has following results: " + Arrays.toString( dictionary.lookup(SEARCH_TERM)));
		
		
		System.out.println("The longest chain is "+ Arrays.toString( dictionary.longestChain()));
		System.out.println("It's length is "+ dictionary.longestChain().length );
		
		System.out.println("");
		System.out.println("The following dictionary is limited to words with the length of " + STRING_LIMITER);
		
		Dictionary limitedDic = new Dictionary(STRING_LIMITER);
		dictionary.ht.getEntry();
		dictionary.ht.getCollisions();
		
		System.out.println("The search term '" + SEARCH_TERM + "' has following results: " + Arrays.toString( limitedDic.lookup(SEARCH_TERM)));
		System.out.println("The longest chain is "+ Arrays.toString( limitedDic.longestChain()));
		System.out.println("It's length is "+ limitedDic.longestChain().length );
	}
}