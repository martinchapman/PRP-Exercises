package model;
import java.util.ArrayList;
import java.util.Collections;

public class Things {

	public static void main(String[] args) {
		
		ArrayList<Thing> things = new ArrayList<Thing>();
		
		for(int i = 0; i < 10; i++) { 
			
			things.add(new Thing((int)(Math.random()*10)));
			
		}
		
		for(Thing thingFromListLoop : things) {
			
			System.out.println(thingFromListLoop);
			
		}
		
		Thing thingFromList = things.get(0);
		System.out.println(things.contains(thingFromList));
		
		Thing thingNotFromList = new Thing((int)Math.random()*10);
		System.out.println("*" + thingNotFromList);
		System.out.println(things.contains(thingNotFromList));
		
		Collections.sort(things);
		
		System.out.println("Sorted:");
		for(Thing thingFromListLoop : things) {
			
			System.out.println(thingFromListLoop);
			
		}

	}

}
