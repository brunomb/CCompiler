package core;


public class Attr extends Simbolo {
	
	private final Variavel v;
	
	public Attr(Variavel v) {
		super(v.getLexema(), v.getType(), null);
		this.v = v;
		
	}
	
	public Variavel getVar() {
		return this.v;
	}
}
