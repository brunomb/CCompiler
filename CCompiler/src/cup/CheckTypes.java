package cup;

public class CheckTypes {
	
	static CheckTypes instance = null;
	
	private CheckTypes() {
	}
	
	public void checkAssignment(Object var, Object var2) {
    	if (var != "IDENTIFIER") {
    		System.out.println("ERROR");
    	}
    }
	
	public static CheckTypes getInstance() {
		if (instance == null) {
			instance = new CheckTypes();
		}
		
		return instance;		
	}
	
}
