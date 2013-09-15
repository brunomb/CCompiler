package core;

public class Variavel extends Simbolo {
	Object value;

	public Variavel(String lexema, String type, Object value) throws Exception {
		super(lexema, type, null);
		
		if (type.equalsIgnoreCase("int")) {
			this.value = (Integer) value;
		} else if (type.equalsIgnoreCase("float")) {
			this.value = (Float) value;
		} else if (type.equalsIgnoreCase("double")) {
			this.value = (Double) value;
		} else if (type.equalsIgnoreCase("char")) {
			this.value = value;
		}
		
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
