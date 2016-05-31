package notes;
// 10. An interface is a list of the methods that a class has to contain, in order
// to be considered the type of object defined in the interface.
// Once a class is considered to be of the same type as another object, it can be 
// interacted with by other classes, as if it were that type of object. 
// In other words, it forces the programmer to provide methods which will be
// accessed and used by other classes.

public class ThingV4 implements Comparable<ThingV4>{

	private int val;
	
	public ThingV4(int v) { 
		val = v; 
	}
	
	public String toString() {
		return "I am thing " + val;
	}
	
	// 11. Why does this make something comparable? Because other classes or methods
	// (such as Collections sort) interacts with this method in order to items -
	// it needs the information provided by this method to do the sorting.
	// As types are defined by their behaviour, if a class has the same behaviour
	// as other type, it IS that type. 
	
	// If this method returns a negative value, then other methods (such as sort)
	// will consider this class to be ordered BEFORE the class which has been passed in.
	
	// Example:
	/* Thing thing1 = new Thing();
	 * Thing thing2 = new Thing()
	 * 
	 * thing1.compareTo(thing2) - if the result of this is NEGATIVE, thing1 will be
	 * considered to be before thing2. If the result is POSITIVE, thing2 will be
	 * considered to be before thing1. And if they are equal, they will be considered
	 * to be the same.
	 * 
	 * Must MAKE it negative or positive to control ordering.
	 * 
	 * If we want an ordering like 1, 2, 3 and 4. We must make sure that when we call
	 * 1.compareTo(2) we get a negative value, because, as the API says, this says
	 * that 1 precedes 2. 
	 * When something is compared to something else higher in the list, must return -,
	 * lower must return +.
	 */
	@Override
	public int compareTo(ThingV4 t) {
		
		// Putting the method in is only part of the work, still need to return
		// something to complete the functionality.
		
		// 12. Returns a negative value if THIS object is smaller than the parameter:
		// If this < t = -1
		// If this = t = 0
		// If this > t = 1
		
		// return val - t.val;
		// If t is bigger than this number, then minusing will give negative, hence
		// t.val > t
		// Eg. t = 4, this = 3 -> 3 - 4 = -1
		// If the value in the other class is bigger, we will always get a negative, so it
		// will place it in ascending order.
		// This is for ASCENDING; we want DESCENDING. So just switch.
		
		return t.val - val;
		// e.g. val = 9, t.val = 8 (9 comes before 8 in descending) so 8 - 9 = -1
		// return is correct.
	}
}
