package core;

import java.util.ArrayList;

import java_cup.sym;

public class CodeGen {
	
	private static int indexLabel = 0;
	private static ArrayList<Simbolo> labels = new ArrayList<Simbolo>();
	
	private static String getNextLabel() {
		indexLabel++;
		
		return "L" + indexLabel;
	}
	
	public static String Go() {
		String result = "";
		
		for (Simbolo s : TabelaSimbolos.getInstance().getSimbolos()) {
			labels.add(s);
			result += getNextLabel() + "(" + s.getLexema() +"):\n" + GenContext(s);
			
			if (s.getLexema().equalsIgnoreCase("main")){
				result = result + "halt;\n";
			}
			else {
				result = result + "BR SP;\n";
			}
			
		}
		return result;
	}
	
	public static String GenContext(Simbolo s) {
		String result = "";
		ArrayList<Simbolo> registradores = new ArrayList<Simbolo>();
		
		Funcao f = (Funcao) s;
		
		for (Simbolo a : f.getContexto()) {
			result += GenAttr(a, registradores);
		}
		return result;
	}
	
	
	public static String GenAttr(Simbolo s, ArrayList<Simbolo> registradores) {
		registradores.add(s);
		
		String result = "";
		
		result += "ST R" + registradores.indexOf(s) + ", " + s.getLexema() + ";\n"; 
		
		return result;
	}
}

