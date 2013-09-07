package core;

public class CallFunction extends Simbolo {
	
	private final Funcao f;
	
	public CallFunction(Funcao f) {
		super(f.getLexema(), f.getType(), null);
		this.f = f;
	}
	
	

}
