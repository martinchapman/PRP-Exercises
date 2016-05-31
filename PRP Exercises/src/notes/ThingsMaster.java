package notes;
import java.util.ArrayList;
import java.util.Collections;

public class ThingsMaster {

	public static void main(String[] args) {
		
		// Remember, classes are just data types, therefore
		// we can use them (even our own self-defined ones!) in 
		// any place that we use primitive types. In this instance,
		// in an Array List.
		ArrayList<ThingV1> things = new ArrayList<ThingV1>();
		
		for(int i = 0;i < 5;++i) {
			things.add(new ThingV1());
		}
		
		for(int i = 0;i < things.size();++i) {
			System.out.println(things.get(i));
		}
		
		// 1. What does the output mean? NB. Leave 'how is it converted to a string',
		// for now.
		// This outputs the type and MEMORY LOCATION of our objects.
		
		
		// 2. How is this memory location used or, conversely, 
		// how does .contains tell if an object is in the Array List?
		// Comparison / location is based on the object identifier, which by default
		// is the memory location. (thing thing we've seen printed)
		ThingV1 t = things.get(1);
		// Prints true: clearly and trivially this object is in the array
		System.out.println("Is "+t+" there: "+things.contains(t));
		
		// Prints false: this new object is NOT in the array i.e. its memory
		// address / object identifier is not located in the array.
		t = new ThingV1();
		System.out.println("Is "+t+" there: "+things.contains(t));
		// Important: Contains is designed to LOOK FOR a certain method, equals in objects,
		// which is defined by its ENTIRE signature, not just the name.
		// This is DIFFERENT to how we the programmer would do it.
		// Important distinction between contains calling equals, and us calling
		// equals.
		// i.e. System.out.println(thingFromList.equals(thingNotFromList)); will
		// not default back to the parent method when overriding is not done correctly.
		// This case is not really anything to do with inheritance as its a completely different
		// method.
		
		//////////////////////////////////////////////////////////////////////
		
		// 3. Where does this identifier come from? How is it printed?
		
		// In order to convert our class to printable strings, 
		// what's really happening here is the following:
		for(int i = 0;i < things.size();++i) {
			System.out.println(things.get(i).toString());
		}
		// 4. Why can I call (even implicitly) .toString() on my object?
		// I haven't defined a method called toString()?
		// Clearly this is through inheritance, as all classes
		// you define inherently extend Object.
		// If one class extends another, you get a COPY of all the methods
		// in that class, thus we can access toString().
		
		// Shows beauty of inheritance because we gain some behaviour without
		// having to do any work -- our new classes become printable. 
	
		// The output you get is a memory location, as this is the
		// *default* behaviour of toString, inherited from the object
		// class
		
		////////////////////////////////////////////////////////////////////////
		
		// 9. Want to add a piece of functionality where I SORT the things
		// in my list.
		
		// The things in our list are not the 'type' of things that 
		// can be sorted, however, as the following gives an error:
		Collections.sort(things);
		
		// Must work with things that are comparable; no information given
		// about how Things should be compared.
		
		// We need to make our things class 'sortable'. How do we do this?
		// What can guide us? INTERFACES tell us the methods that an object
		// has to provide (behaviour) in order to be considered to be of a certain type.
		
		// If we want to turn one class into the type of another, interfaces
		// guide us in how to set up their functionality to do so.
		
		// For example if we want our Things to be 'comparable', implementing
		// the comparable interface will let us know what methods we need to
		// supply for our class to be of the type comparable. (By having certain
		// methods, classes effectively become certain types, given that types
		// are defined by their behaviour).
		
		// Eg. sort needs to access certain methods offered by comparable in order to work
		// Sort looks for objects with a compareTo method  
		
		// Why don't we extend? No RULES with inheritance - don't HAVE to implement
		// any methods. Could use abstract methods, but that's a whole other
		// story. In this case interfaces are better, and a convention, not to mention
		// a restriction from the API.
		
		ArrayList<ThingV4> thingsV2 = new ArrayList<ThingV4>();
		
		for(int i = 0; i < 10; i++) {
			thingsV2.add(new ThingV4((int)(Math.random()*10)));
		}
		
		Collections.sort(thingsV2);
		// We can make some assumptions about the functionality of sort, perhaps it passes
		// in each item in turn from the list to each item, and uses the value it gets back
		// as an ordering. 
		// Vitally though, this functionality is not important: we know what sort needs - 
		// objects which have a compareTo function (as shown be the requirement for them
		// to be comparable types), we have satisfied this requirement, and thus our 
		// items become sortable. 
		
		for(ThingV4 thing : thingsV2) {
			System.out.println(thing);
		}
		
	}
	
}
