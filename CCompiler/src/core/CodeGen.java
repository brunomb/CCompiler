package core;

import java.util.ArrayList;

public class CodeGen {
	
//	private static ArrayList<Simbolo> registradores = new ArrayList<Simbolo>();
	private static ArrayList<Simbolo> funcoes = new ArrayList<Simbolo>();
	
	public static String getNextLabel(Simbolo s) {
		funcoes.add(s);
		
		return "L" + funcoes.indexOf(s);
	}
	
	public static String Go() {
		String result = "";
		
		for (Simbolo s : TabelaSimbolos.getInstance().getSimbolos()) {
			result += getNextLabel(s) + "(" + s.getLexema() +"):\n" + GenContext(s);
			
			if (s.getLexema().equalsIgnoreCase("main")){
				result = result + "halt;\n";
			}
			else {
				result = result + "BR *(0)SP;\n";
			}
			
		}
		return result;
	}
	
	public static String GenContext(Simbolo s) {
		String result = "";
		ArrayList<Simbolo> registradores = new ArrayList<Simbolo>();
		
		Funcao f = (Funcao) s;
		
		for (Simbolo a : f.getContexto()) {
			if (a instanceof Variavel) {
				result += GenAttrInitializer(a, registradores);
			} else if (a instanceof CallFunction) {
				result += GenCallFun(a, registradores);
			} else if (a instanceof Attr) {
				result += GenAttr(a, registradores);
			}
		}
		return result;
	}
	
	
	private static String GenAttr(Simbolo s, ArrayList<Simbolo> registradores) {
		String result = "";
		
		Attr t = (Attr) s;
		Variavel v = t.getVar();
		
		result += "ST " + v.getLexema() + ", #" + v.getValue() + "\n"; 
		
		return result;
	}

	private static String getLabel(Simbolo s) {
		for (int i = 0; i < funcoes.size(); i++) {
			if (funcoes.get(i).getLexema().equals(s.getLexema())) {
				return "L" + i;
			}
		}
		
		return null;
	}
	
	private static String GenCallFun(Simbolo s, ArrayList<Simbolo> registradores) {
		registradores.add(s);
		
		String result = "";
		
		result += "ADD SP, SP, #" + s.getLexema() + "size;\n";
		result += "ST *SP, #here+16" + ";\n";
		result += "BR " + getLabel(s) + ";\n";
		result += "SUB SP, SP, #" + s.getLexema() + "size;\n";
		
		return result;
	}

	public static String GenAttrInitializer(Simbolo s, ArrayList<Simbolo> registradores) {
		registradores.add(s);
		
		String result = "";
		
		result += "ST R" + registradores.indexOf(s) + ", " + s.getLexema() + ";\n"; 
		
		return result;
	}
}

