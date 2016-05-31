package abstractclassesinterfaces.interfacesimple;

public class Martin {

	public Martin() {
		
		AudioDevice car = new Car();
		
		AudioDevice iPhone = new iPhone();
		
		car.playMusic();
		
		iPhone.playMusic();
		
		((Drives)car).moveForward();
		
		car.playMusic();
		
		
	}

}
