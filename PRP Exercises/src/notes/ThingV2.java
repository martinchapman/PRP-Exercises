package notes;
// Key point: When something extends something, it BECOMES that thing, and is 
// thus treated by other classes and components of Java AS that thing. For example,
// with toString, it is accessed by methods such as 'System.out.print' in the same
// way, regardless of which object it is in. Almost like other classes are 
// looking for certain things, such as methods, and so long as you provide them, it doesn't
// matter what their return is.
public class ThingV2 {
// public class ThingV2 extends Object {

	// 5. When you extend something, you get a copy of the methods.
	// If you write the method SIGNATURE again, you can supply new
	// functionality for that method in the subclass -- you are
	// getting a copy of the code by SPECIALISING it in a certain
	// way. A way of passing code between classes.
	
	// Method signature is what is expected / looked for by other classes
	// that work with your inheriting class, but content is not - can be
	// changed to what you like, so long as return ('output') is the same.
	
	// By inhereting we gain a classes ability to interface with other classes. eg.
	// toString() is a method which allows classes to have a String representation,
	// and thus be treated as Strings.
	
	// All the expected functionality - all the interfacing with other functions
	// and classes - is already set up for you. For example, System.out.println
	// has to work with a String. By extending Object, all your classes have
	// access to default a toString method, which can be passed to methods like println,
	// without you having to do anything. This is nice!
	
	// To find out which methods you inherit, and which you can change,
	// you can check the API. Some from Object are the following:
	
	// 6. Example inheriting and editing the toString() method from object:
	// Always returns "I am a thing" for all String objects, not memory location.
	// Default functionality is 'overridden'. 
	// NOTE: Does not mean that object identifier gets changed. 
	public String toString() {
		// Still returning String and providing toString functionality
		// as is expected by all Objects (subclass of object) - so still
		// interfacing correctly - but exact functionality has been changed.
		return "I am a thing.";
	}
	
	// Inheriting and editing the equals method from object:
	// Same for equals, default functionality is overridden, and we actually
	// 'break' the method, by always returning true of false, regarldess of comparison. 
	public boolean equals(Object o) {
		return false;
	}
	
	// 7. Definition must be exact, or overriding doesn't work.
	// Need to match both return type and parameter type.
	
	// Contains works by invoking the .equals method of every object in a list,
	// to see if the identifier of the object passed to the list is EQUAL to the
	// identifiers of anything in that list. Contains is expecting to INTERACT
	// with a certain method - it is looking for a certain method signature -
	// if that signature is not found in the child class, then it will default to 
	// parent. Hence not putting the correct signature here returns to default
	// behaviour.
	
	// CALLS .EQUALS IN THE PARENT CLASS BECAUSE THAT'S NOW THE ONLY PLACE THAT IT EXISTS
	// LIKE CALLING TOSTRING WHEN NOT OVERRIDDEN
	// Changing the signatuere basically means that equals in its accepted form does not exist.
	// Can only call equals in the object
	public boolean equals(ThingV2 thing) {
		return false;
	}
	
}
