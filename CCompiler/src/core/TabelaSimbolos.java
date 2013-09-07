package core;

import java.util.ArrayList;


public class TabelaSimbolos {
	
	String nomeContexto;
	private ArrayList<Simbolo> simbolos;
	
	static TabelaSimbolos instance;
	
	private TabelaSimbolos(String nomeContexto) {
		this.nomeContexto = nomeContexto;
		this.simbolos = new ArrayList<Simbolo>();
	}
	
	public static TabelaSimbolos getInstance() {
		if (instance == null) {
			instance = new TabelaSimbolos("main");
		}
		return instance;
	}
	
	public ArrayList<Simbolo> getSimbolos() {
		return this.simbolos;
	}
	
	public Variavel searchVar(Simbolo s) {
		
		for (int i = 0; i < simbolos.size(); i++) {
			if (simbolos.get(i).getLexema().equals(s.getLexema()) && (simbolos.get(i) instanceof Variavel)) {
				return (Variavel) simbolos.get(i);
			}
		}
		
		return null;
	}
	
	public Variavel searchVar(String s) {
		for (int i = 0; i < simbolos.size(); i++) {
			if (simbolos.get(i).getLexema().equals(s)) {
				if (simbolos.get(i) instanceof Variavel)
					return (Variavel) simbolos.get(i);
			}
		}
		
		return null;
	}
	
	public Funcao searchFun(Simbolo s) {
		for (int i = 0; i < simbolos.size(); i++) {
			if (simbolos.get(i).getLexema().equals(s.getLexema())) {
				if (simbolos.get(i) instanceof Funcao)
					return (Funcao) simbolos.get(i);
			}
		}
		
		return null;
	}
	
	public boolean existVar(Variavel v) {
		for (int i = 0; i < simbolos.size(); i++) {
			if (simbolos.get(i).getLexema().equals(v.getLexema())) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean existFunc(Funcao f) {
		for (int i = 0; i < simbolos.size(); i++) {
			
			if (simbolos.get(i) instanceof Variavel) {
				if (simbolos.get(i).getLexema().equals(f.getLexema())) {
					return true;
				}
			} else if (simbolos.get(i) instanceof Funcao) {
//				if (f.equals((Funcao) simbolos.get(i))) { // TODO: Implementar Sobrecarga
				if (simbolos.get(i).getLexema().equals(f.getLexema())) {
					return true;
				}
			}
		}

		return false;
	}
	
	public void addSimbolo(Simbolo s) {
		if (s instanceof Variavel && existVar((Variavel) s)) {
			LogHandler.varAlreadyExist((Variavel) s); 
		} else if (s instanceof Funcao && existFunc((Funcao) s)) {
			LogHandler.funcAlreadyExist((Funcao) s);
		} else {
			simbolos.add(s);
		}
	}
	
	public void addVariavel(String lexema, String type, Object value, Simbolo parent) {
		Simbolo newSimbolo;
		try {
			newSimbolo = (Simbolo) new Variavel(lexema, type, value, parent);
			addSimbolo(newSimbolo);
			LogHandler.showInfo("Variavel criada: " + newSimbolo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void addListaVariavel(String list, String type) {
		String[] lista = list.split(",");
		
		for (int i = 0; i < lista.length; i++) {
			addVariavel(lista[i].replace(" ", ""), type, null, null);
		} 	
	}
	
	
	public void addFuncao(String stringParametros, String returnType) {
		
		Funcao newF = Utils.string2Funcao(stringParametros, returnType);
		addSimbolo(newF);
		LogHandler.showInfo("Funcao adicionada: " + newF);
	}
	
}
