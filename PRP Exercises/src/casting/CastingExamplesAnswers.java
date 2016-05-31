package casting;
import java.util.Scanner;


public class CastingExamplesAnswers {

	public static void main(String[] args) {
		
		// Mix of primitive and class types:
		int anInt = 1;
		double aDouble = 1.5;
		float aFloat = 1.0f;
		boolean aBoolean = true;
		Integer anotherInt = 1;
		String aString = "String";
		Object anObject = new Object();
		Scanner aScanner = new Scanner(System.in);
		
		// 'Implicit' casting:
		// Not allowed because you lose precision (5.0 -> 5)
		// Java looks after you, doesn't let you accidentally lose data. 
		anInt = aDouble;
		
		// Not allowed for same reasons as above
		anInt = 1.0 / 2.0;
		
		// OK, because you can only gain precision.
		aDouble = anInt;
		
		// Not allowed because you lose precision (double can express more than float)
		aFloat = aDouble;
		
		// OK, for the same reasons as above.
		aDouble = aFloat;
		
		////////
		
		// 'Explicit' casting:
		// When we explicitly cast, we attempt to FORCE data to change type.
		
		// Now ok, because we have stated that we are happy to lose precision.
		anInt = (int)aDouble;
		
		aFloat = (float)aDouble;
		
		// Straight-up can't do this, even with casting. 
		aDouble = (double)aBoolean;
		
		////////
		
		// 'Implicit' Class Casting:
		// Ok, because all Strings are Objects.
		anObject = aString;
		
		// Not ok, because all objects are not necessarily Strings.
		aString = anObject;
		
		// Straight-up type mismatch
		aScanner = aString;
		
		////////
		
		// 'Explicit' Class Casting:
		
		// We're allowed to try this, because our object could be a String, 
		// but if this doesn't work, we'll receive a Runtime ClassCastException.
		aString = (String)anObject;
		
		// Again, even with our explicit class cast, some things just won't work together
		aScanner = (Scanner)aString;
		
	}
	
}
