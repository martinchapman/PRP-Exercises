package misc;

public class Thing extends Object {

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
	
	public boolean equals(Object o) {
		
		if (value == ((Thing)o).value()) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
