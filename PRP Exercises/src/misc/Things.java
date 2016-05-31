package misc;
import java.util.ArrayList;

public class Things {

	
	public static void main(String[] args) {
		
		ArrayList<Thing> things = new ArrayList<Thing>();
		
		for(int i = 0; i < 10; i++) {
		
			things.add(new Thing(1));
		
		}
		
		for(int i = 0; i < 10; i++) {
			
			System.out.println(things.get(i));
			
		}
		
		Thing thingFromList = things.get(0);
		System.out.println(things.contains(thingFromList));

		Thing thingNotFromList = new Thing(1);
		System.out.println("*" + thingNotFromList);
		System.out.println(things.contains(thingNotFromList));
		
		Thing thing1 = new Thing(1);
		Thing thing2 = new Thing(1);
		thing1.equals(thing2);
		
	}

}
