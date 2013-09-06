package core;

public class CheckTypes {
	
	private CheckTypes() {}
	
	
	public static boolean checkAssignment(Object n1, Object n2) {
//		return checkAssignment((Node) n1, (Node) n2);
		
		if (!(n1 instanceof Simbolo) || !(n2 instanceof Simbolo)) {
			return false;
		}
		
		Simbolo s1 = (Simbolo) n1;
		Simbolo s2 = (Simbolo) n2;
		
		if (!(s1.getType().equalsIgnoreCase("IDENTIFIER"))) {
			LogHandler.showError("First argument must be IDENTIFIER");
			return false;
		}
			
		Variavel v = TabelaSimbolos.getInstance().searchVar(s1);
			
		if (v == null) {
			LogHandler.showError("Variavel não foi criada: " + s1.getLexema());
			return false;
		}
		
		if (!(v.getType().equalsIgnoreCase(s2.getType()))) {
			LogHandler.showError("Tipos não batem: " + v + " / " + s2);
		}
		return true;
	}
	
}
