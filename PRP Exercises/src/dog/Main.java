package dog;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Dog myDog = new Dog();
		
		myDog.setDogsHeight(100);
		
		////////
		
		Dog mySecondDog = new Dog();
		
		mySecondDog.setDogsHeight(50);
	
		
		///////
		
		int myDogsHeight = myDog.getDogsHeight();
		
		int mySecondDogsHeight = mySecondDog.getDogsHeight();
		
		System.out.println(myDogsHeight);
		
		System.out.println(mySecondDogsHeight);
		
		/// Which dog is taller?
		
		if ( myDogsHeight > mySecondDogsHeight ) {
			
			System.out.println("My dog is taller");
		
		} else {
			
			System.out.println("My second dog is taller");
			
		}
		
		myDog.compareDogsHeight(mySecondDog);
		
		mySecondDog.setDogsHeight(1000);
		
		myDog.compareDogsHeight(mySecondDog);
		
		
		
	}

}
