package core;

public class Node {
	String lexema;
	String type;
	Node parent = null;
	
	public Node(String lexema, String type, Node parent) {
		this.lexema = lexema;
		this.type = type;
		
		this.parent = parent;
	}

	public String getLexema() {
		return lexema;
	}

	public void setLexema(String lexema) {
		this.lexema = lexema;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public String toString() {
		return this.lexema + "(" + this.type + ")";
	}
	
	
}
