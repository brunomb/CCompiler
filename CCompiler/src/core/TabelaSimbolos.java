package core;

import java.util.ArrayList;

public class TabelaSimbolos {
	
	String nomeContexto;
	
	static TabelaSimbolos instance;
	
	private TabelaSimbolos(String nomeContexto) {
		this.nomeContexto = nomeContexto;
	
	}
	
	
	public static TabelaSimbolos getInstance() {
		if (instance == null) {
			instance = new TabelaSimbolos("main");
		}
		
		return instance;
	}
	
	
	public void addList(String list, String type) {
		System.out.println("ADICIONA LIST TAB: " + list + " DO TIPO: " + type );
	}
	
	public void add(String sym, String type) {
		System.out.println("ADICIONA TAB: " + sym + " DO TIPO: " + type);
	}
	
	
	
	
}
