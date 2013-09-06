package core;

public class Simbolo {
	String lexema, type;
	Simbolo parent;
	
	public Simbolo(String lexema, String type, Simbolo parent) {
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

	public Simbolo getParent() {
		return parent;
	}

	public void setParent(Simbolo parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return lexema + "(" + type + ")";
	}
	
	
}
