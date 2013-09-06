package core;

import java.util.ArrayList;

public class CheckTypes {
	
	private CheckTypes() {}
	
	
//	public static Variavel existVar(Simbolo s) {
//		Variavel v = TabelaSimbolos.getInstance().searchVar(s);
//		
//		return v;
//	}
	
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
		
		if (v.getType().equalsIgnoreCase(("int"))) {
			v.setValue(Integer.parseInt(s2.getLexema()));
			LogHandler.showInfo("Int with value: " + v.getLexema() + " = " + v.getValue().toString());
		} else if (v.getType().equalsIgnoreCase("float")) {
			v.setValue(Float.parseFloat(s2.getLexema()));
			LogHandler.showInfo("Float with value: " + v.getLexema() + " = " + v.getValue().toString());
		} else if (v.getType().equalsIgnoreCase("double")) {
			v.setValue(Double.parseDouble(s2.getLexema()));
			LogHandler.showInfo("Double with value: " + v.getLexema() + " = " + v.getValue().toString());
		} else if (v.getType().equalsIgnoreCase("char")) {
			
			if (s2.getLexema().length() != 3) {
				LogHandler.showError("Char invalid: " + s2.getLexema());
			} else {
				v.setValue(s2.getLexema().charAt(1));
				
				LogHandler.showInfo("Char with value: " + v.getLexema() + " = " + v.getValue().toString());
			}
		}
			
		return true;
	}
	
	public static void checkIfFuncaoExist(String namespace, String strParametros) {
		
		namespace = namespace.substring(0, namespace.indexOf("("));
		ArrayList<Variavel> parametros = new ArrayList<Variavel>();
		
		Funcao f = TabelaSimbolos.getInstance().searchFun(new Simbolo(namespace, null, null));
		
		if (f == null) {
			LogHandler.showError("Funcao não existe: " + namespace);
		} else {
		
			String[] par = strParametros.split(",");
			Variavel varTemp = null;
			
			for (int i = 0; i < par.length; i++) {
				if (par[i].equals(""))
					continue;
				
				String temp =  par[i].substring(par[i].indexOf("(")).replace("(","").replace(")","");
				
				if (temp.equalsIgnoreCase("IDENTIFIER")) {
					String id = par[i].substring(0, par[i].indexOf("(")).trim();
					varTemp = TabelaSimbolos.getInstance().searchVar(id);
					if(varTemp == null) {
						LogHandler.showError("Variavel não existe: " + id);
					} else {
						parametros.add(varTemp);
					}
					
				} else {
					try {
						parametros.add(new Variavel(null, temp.toLowerCase(), null, null));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			if (f.getParametros().size() != parametros.size()) {
				LogHandler.showError("Quantidade de parametros incorreto: " + f.getLexema());
			} else {
				for (int j = 0; j < f.getParametros().size(); j++) {
					if (!(f.getParametros().get(j).getType().equalsIgnoreCase(parametros.get(j).getType()))) {
						LogHandler.showError("Função com parametro incorreto: " + parametros.get(j));
					}
				}
			}
		}
	}
	
}
