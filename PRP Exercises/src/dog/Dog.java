package dog;
public class Dog {
	
	private int height;
	
	public Dog() {
		
		height = 700;
		
	}
	
	
	public void setDogsHeight(int dogsHeight) {
		
		height = dogsHeight;
		
	}
	
	public int getDogsHeight() {
		
		return height;
		
	}
	
	public void compareDogsHeight(Dog mySecondDog) {
		
		if ( height > mySecondDog.getDogsHeight() ) {
			
			System.out.println("My dog is taller");
		
		} else {
			
			System.out.println("My second dog is taller");
			
		}
		
	}
	
}