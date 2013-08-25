package core;

import java.util.ArrayList;


public class TabelaSimbolos {
	
	String nomeContexto;
	ArrayList<Node> listaNos = new ArrayList<Node>();
	ArrayList<Function> listaFuncoes = new ArrayList<Function>();
	
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
		
		String[] lista = list.split(",");
		for (int i = 0; i < lista.length; i++) {
			
			Node no = new Node(lista[i].replace(" ", ""), type, null); // Cria o no
			if(checkSym(no)){ // Check se o no ja esta na tabela
				listaNos.add(no);
				//System.out.println("ADICIONEI NA TAB: " + lista[i].replace(" ", "") + " DO TIPO: " + type);
			}			
		} 	
	}
	
	public void add(String sym, String type) {
		Node no = new Node(sym, type, null); // Cria o no
		if(checkSym(no)){ // Check se o no ja esta na tabela
			listaNos.add(no);
			System.out.println("ADICIONEI NA TAB: " + sym + " DO TIPO: " + type);
		}
	}
	
	public void addFunction(String name_parametros, String retorno) {
		name_parametros = name_parametros.replace(" ", "");
		name_parametros = name_parametros.replace(")", "");
		name_parametros = name_parametros.replace("(",",");
		String[] lista = name_parametros.split(",");
		String nome = lista[0];
		ArrayList<Node> nos = new ArrayList<Node>();
		
		for (int i = 1; i < lista.length; i = i+2) {
			nos.add(new Node(lista[i], lista[i+1],null));
		}
		
		Function funcao = new Function(nome, retorno, nos);
		if(checkFunc(funcao)){
			listaFuncoes.add(funcao);
			//System.out.println("ADICIONEI FUNC: " + name_parametros + " COM O RETORNO: " + retorno);
		}
	}
	
	//TODO Como deve ser o equals do simbolo da tabela? (Ver semantica de C)
	public boolean checkSym(Node simbolo){ // Check se ja existe um simbolo na tabela (um simbolo é igual a outro se tiver o mesmo nome o mesmo tipo)
		for (int i = 0; i < listaNos.size(); i++) {	
			if(simbolo.equals(listaNos.get(i))){
				System.err.println("Variavel já cadastrada");
				System.exit(0);
			}
		}
		return true;
	}
	
	public boolean checkFunc(Function funcao){ // Check se ja existe uma funca na tabela (como tem sobrecarga uma funcao so vai ser considerada igual a outra se tiver o mesmo nome e o mesmo numero e tips de parametros
		for (int i = 0; i < listaFuncoes.size(); i++) {
			if (funcao.equals(listaFuncoes.get(i))){
				System.err.println("ERROR - Sobrecarga " + funcao.getNome() + " " + funcao.getNome() );
				System.exit(0);
			}
		}
		return true;
	}
}
