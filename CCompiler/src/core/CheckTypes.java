package core;

public class CheckTypes {
	
	static CheckTypes instance = null;
	
	private CheckTypes() {}
	
	public boolean checkAssignment(Node n1, Node n2) {
    	if (!isIdentifier(n1)) {
    		return false;
    	} 
    	
    	return true;
    }
	
	public static CheckTypes getInstance() {
		if (instance == null) {
			instance = new CheckTypes();
		}
		
		return instance;		
	}
	
	public boolean isIdentifier(Node n) {
		if (n.getType().equalsIgnoreCase("IDENTIFIER")) {
			return true;
		}
		
		return false;
	}
	
	public boolean isString(Node n) {
		if (n.getType().equals("STRING")){
			return true;
		}
		
		return false;
	}
	
	public boolean isInteger(Node n) {
		if (n.getType().equals("INTEGER")) {
			return true;
		}
		
		return false;
	}
	
	public boolean isVoid(Node n) {
		if (n.getType().equals("VOID")) {
			return true;
		}
		
		return false;
	}
	
	public boolean isChar(Node n) {
		if (n.getType().equals("CHAR")) {
			return true;
		}
		
		return false;
	}
	
	public boolean isFloat(Node n) {
		if (n.getType().equals("FLOAT")) {
			return true;
		}
		
		return false;
	}
	
	public boolean isShort(Node n) {
		if (n.getType().equals("SHORT")) {
			return true;
		}
		
		return false;
	}
	
	public boolean isLong(Node n) {
		if (n.getType().equals("LONG")) {
			return true;
		}
		
		return false;
	}

}
