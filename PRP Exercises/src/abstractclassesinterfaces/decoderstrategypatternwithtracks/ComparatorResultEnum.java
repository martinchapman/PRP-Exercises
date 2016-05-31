package abstractclassesinterfaces.decoderstrategypatternwithtracks;

/**
 * 
 * 
 * @author Martin
 *
 */
public enum ComparatorResultEnum {

	/**
	 * 
	 */
	BEFORE(-1),
    
	/**
	 * 
	 */
	EQUAL(0),
    
    /**
     * 
     */
    AFTER(1);
    
    /**
  	 * 
  	 */
  	private int value;
  	
    /**
     * @param result
     */
    private ComparatorResultEnum( int result ) {
    	
    	this.value = value;
    	
    }
    
	/**
	 * @return
	 */
	public int getValue() {
    
		return value;
	
	}
	
}