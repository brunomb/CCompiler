package core;
import java.util.ArrayList;
import java.util.Collections; 

public class Function {
	String nome;
	String retorno;
	ArrayList<Node> parametros;
	
	public Function(String nome, String retorno, ArrayList<Node> parametros){
		this.nome = nome;
		this.retorno = retorno;
		this.parametros = parametros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRetorno() {
		return retorno;
	}

	public String getParametros() {
		String p = "";
		ArrayList<String> tipos = new ArrayList<String>();
		for (int i = 0; i < parametros.size(); i++) {
			tipos.add(parametros.get(i).getType());
		}
		Collections.sort(tipos);
		for (int i = 0; i < tipos.size(); i++) {
			p = p + tipos.get(i).replace(" ", "");
		}
		return p;		
	}

	public void setParametros(ArrayList<Node> parametros) {
		this.parametros = parametros;
	}
	
	public boolean equals(Function funcao){
		if(this.nome.equals(funcao.nome) && this.getParametros().equals(funcao.getParametros())){
			return true;
		}else{
			return false;
		}
	}

}
