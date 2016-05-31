package misc;

public class CarClass {

	public String colour;
	
	private final static int wheels = 4;
	
	
	public void setColour(String colour) {
		
		if ( colour.equals("pink") ) {
			
			System.out.println("Don't do it! He'll punch you!");
			
		} else {
			
			this.colour = colour;
			
		}
		
	}

	public String getColour() {
		
		return colour;
		
	}
	
}

/**/






