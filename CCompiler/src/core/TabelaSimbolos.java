package core;

import java.util.ArrayList;


public class TabelaSimbolos {
	
	private ArrayList<Simbolo> simbolos;
	private ArrayList<Simbolo> newContexto = new ArrayList<Simbolo>();
	
	static TabelaSimbolos instance;
	
	private TabelaSimbolos(String nomeContexto) {
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
	
	public ArrayList<Simbolo> getNewContexto() {
		return this.newContexto;
	}
	
	public Variavel searchVar(Simbolo s) {
		
		for (int i = 0; i < newContexto.size(); i++) {
			if (newContexto.get(i).getLexema().equals(s.getLexema()) && (newContexto.get(i) instanceof Variavel)) {
				return (Variavel) newContexto.get(i);
			}
		}
		
		return null;
	}
	
	public Variavel searchVar(String s) {
		for (int i = 0; i < newContexto.size(); i++) {
			if (newContexto.get(i).getLexema().equals(s)) {
				if (newContexto.get(i) instanceof Variavel)
					return (Variavel) newContexto.get(i);
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
		for (int i = 0; i < newContexto.size(); i++) {
			if (newContexto.get(i).getLexema().equals(v.getLexema())) {
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
	
	public void addCallFunction(Object o) {
		Funcao f = (Funcao) o;
		
		newContexto.add(new CallFunction(f));
	}
	
	public void addSimbolo(Simbolo s) {
		if (s instanceof Variavel && existVar((Variavel) s)) {
			LogHandler.varAlreadyExist((Variavel) s); 
		} else if (s instanceof Funcao && existFunc((Funcao) s)) {
			LogHandler.funcAlreadyExist((Funcao) s);
		} else {
			if (s instanceof Funcao) {
				simbolos.add(s);
			} else if (s instanceof Variavel) {
				newContexto.add(s);
			}
		}
	}
	
	public void addContexto(Object o) {
		Funcao f = (Funcao) o;
		for (Simbolo s : newContexto) {
			if (s.getLexema().equals(f.getLexema())) {
				LogHandler.showError("Variavel com o mesmo nome da função: " + s.getLexema());
			} else {
				f.addInContexto(s);
			}
		}
	}
	
	public void showAll() {
		for (Simbolo s : simbolos) {
			s.showContext();
		}
	}
	
	public void eraseContexto() {
		newContexto.clear();
	}
	
	public void addVariavel(String lexema, String type, Object value) {
		Simbolo newSimbolo;
		try {
			newSimbolo = (Simbolo) new Variavel(lexema, type, value);
			addSimbolo(newSimbolo);
			LogHandler.showInfo("Variavel criada: " + newSimbolo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void addListaVariavel(String list, String type) {
		String[] lista = list.split(",");
		
		for (int i = 0; i < lista.length; i++) {
			addVariavel(lista[i].replace(" ", ""), type, null);
		} 	
	}
	
	
	public Object addFuncao(String stringParametros, String returnType) {
		
		Funcao newF = Utils.string2Funcao(stringParametros, returnType);
		addSimbolo(newF);
		LogHandler.showInfo("Funcao adicionada: " + newF);
		
		return (Object) newF;
	}
	
}
