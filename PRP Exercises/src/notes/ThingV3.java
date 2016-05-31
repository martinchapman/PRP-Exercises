package notes;
 public class ThingV3 {

	private int val;
	
	public ThingV3(int v) { 
		val = v; 
	}
	
	// Overriding is better here because there is something slightly
	// more unqiue and defining to represent the object in String form.
	public String toString() {
		return "I am thing " + val;
	}
	
	// 8. The specific requirement of having to match the method signature
	// exactly in order to override can provide a problem:
	// Want to override the behaviour of equals, to allow us to effectively
	// compare two ints, but we cannot change the parameter. 
	// * Don't want to compare objects, but the content of the object instead.
	// Need to somehow convert Object to 'Thing'.
	public boolean equals(Object o) {
		// Familiar with things such as parseInt.
		// In this case, do something similar, we CAST, which means
		// we roughly 'convert' from one type to the other. 
		// Because Thing is a subclass of Object - they are positioned
		// within the same inheritance hierarchy - we are permitted to do this:
		ThingV3 t = (ThingV3) o;
		// Rules of casting: can only do sensible things - can't cast unrelated
		// things, such as Strings to Things - too low down and specific in the
		// inheritance tree (despite deriving from Object) - no relation.
		// Can't cast primitive types in silly ways (i.e. Boolean to int etc.)
		// Also, more subtly, cannot lose precision such as double -> float or
		// long -> int.
		
		// Can't convert wrapper classes in the same way as primitives
		
		// Difference between implicit casting - attempts to assign literals or the
		// results of things to variable types which lose precision. eg. int x = 7.5 / 5.6
		// is not allowed. Nor is assigning between data types e.g.:
		// double x = 1.0; int y = x;
		
		// Casting with brackets, turning this from implicit to explicit, 
		// tells the compiler that you don't care about the loss, and is thus ok.
		
		// Class cast exception thrown if o isn't a Thing.
		
		// Boolean result
		return val == t.val;
	}
	
}
