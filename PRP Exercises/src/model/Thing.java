package model;

public class Thing implements Comparable<Thing> { 
	
	private int value;
	
	public Thing(int value) {
		
		this.value = value; 
		
	}
	
	public String toString() {
	
		return "My value is " + value;
		
	}
	
	public int value() {
		
		return value;
		
	}
	
	public boolean equals1(Object o) {
		
		Thing t = (Thing)o;
		return value == t.value();
		
	}

	@Override
	public int compareTo(Thing t) {
		
		return t.value() - value;
	
	}
	
}
