package core;

import java.util.ArrayList;

public class CheckTypes {
	
	private CheckTypes() {}
	
	
//	public static Variavel existVar(Simbolo s) {
//		Variavel v = TabelaSimbolos.getInstance().searchVar(s);
//		
//		return v;
//	}
		
	public static void checkSwitchEx(Object ex){
		Simbolo s = (Simbolo) ex;
		if (s.getType().equalsIgnoreCase("CONSTANT") && s.getLexema().contains(".")){
			LogHandler.showError("Expressão do SWITCH deve ser do tipo inteiro");
		}
		else if (s.getType().equalsIgnoreCase("STRING")){
			LogHandler.showError("Expressão do SWITCH deve ser do tipo inteiro");
		}
		else if (s.getType().equalsIgnoreCase("IDENTIFIER")){
			Variavel v = TabelaSimbolos.getInstance().searchVar(s);
			if (v == null) {
				LogHandler.showError("Variavel não foi criada: " + s.getLexema());
			}
			else if(!(v.getType().equalsIgnoreCase("INT"))){
				LogHandler.showError("Expressão do SWITCH deve ser do tipo inteiro");
			}
		}
	}
	
	public static void checkCaseEx(Object ex){
		Simbolo s = (Simbolo) ex;
		if (s.getType().equalsIgnoreCase("CONSTANT") && s.getLexema().contains(".")){
			LogHandler.showError("CASE deve ser do tipo inteiro");
		}
		else if (s.getType().equalsIgnoreCase("STRING")){
			LogHandler.showError("CASE deve ser do tipo inteiro");
		}
		else if (s.getType().equalsIgnoreCase("IDENTIFIER")){
			Variavel v = TabelaSimbolos.getInstance().searchVar(s);
			if (v == null) {
				LogHandler.showError("CASE deve ser do tipo inteiro");
			}
			else if(!(v.getType().equalsIgnoreCase("INT"))){
				LogHandler.showError("CASE deve ser do tipo inteiro");
			}
		}
	}
		
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
		
		// Nome de função não existe;
		if (f == null) {
			LogHandler.showError("Funcao não existe: " + namespace);
			return;
		}
		
		String[] par = null;
		
		if (strParametros.contains(",")) {
			par = strParametros.split(",");
		} else {
			par = new String[0];
		}
		
		Variavel varTemp = null;
		
		// Quantidade de parametros incorreto;
		if (f.getParametros().size() != par.length) {
			LogHandler.showError("Quantidade de parametros incorreto: " + f.getLexema());
			return;
		}

		for (int i = 0; i < par.length; i++) {
			String temp =  par[i].substring(par[i].indexOf("(")).replace("(","").replace(")","");
			
			System.out.println("f: " + f.getParametros().get(i) + " t: " + par[i].substring(0, par[i].indexOf("(")).trim() + "(" + temp +")");
			
			String id = par[i].substring(0, par[i].indexOf("(")).trim();
			
			if (temp.equalsIgnoreCase("CONSTANT") && (f.getParametros().get(i).getType().equalsIgnoreCase("CHAR"))) {
				LogHandler.showError("1Função com parametro incorreto: " + id + "(" + temp + ") deveria ser " + f.getParametros().get(i).getType());
//				try {
//					parametros.add(new Variavel(null, f.getParametros().get(i).getType(), null, null));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			} else if (temp.equalsIgnoreCase("STRING") && !(f.getParametros().get(i).getType().equalsIgnoreCase("CHAR"))) {
				System.err.println(f.getParametros().get(i).getType());
				LogHandler.showError("2Função com parametro incorreto: " + id + "(" + temp + ") deveria ser " + f.getParametros().get(i).getLexema() + ":" + f.getParametros().get(i).getType());
//				try {
//					parametros.add(new Variavel(null, "CHAR", null, null));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			} else if (temp.equalsIgnoreCase("IDENTIFIER")) {
				varTemp = TabelaSimbolos.getInstance().searchVar(id);
				
				// Variável usada como parametro não existe;
				if(varTemp == null) {
					LogHandler.showError("Variavel não existe: " + id);
					return;
				} 
				
				System.out.println("var: " + varTemp.getType());
				
				if (varTemp.getType().equalsIgnoreCase("CHAR") && !f.getParametros().get(i).getType().equalsIgnoreCase("CHAR")) {
					LogHandler.showError("3Função com parametro incorreto: " + varTemp + " deveria ser " + f.getParametros().get(i).getType());
				} else if (!varTemp.getType().equalsIgnoreCase("CHAR") && f.getParametros().get(i).getType().equalsIgnoreCase("CHAR")) {
					LogHandler.showError("3Função com parametro incorreto: " + varTemp + " deveria ser " + f.getParametros().get(i).getType());
				}
			}
		}
		
		// Tipos de parametros incorreto;
//		for (int j = 0; j < f.getParametros().size(); j++) {
//			if (!(f.getParametros().get(j).getType().equalsIgnoreCase(parametros.get(j).getType())))
//				LogHandler.showError("Função com parametro incorreto: " + parametros.get(j));
//		}
		
	}
	
}
