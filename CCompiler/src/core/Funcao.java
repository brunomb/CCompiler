package core;

import java.util.ArrayList;

public class Funcao extends Simbolo {
	ArrayList<Variavel> parametros;
	ArrayList<Simbolo> contexto;
	
	
	public Funcao(String lexema, String returnType, ArrayList<Variavel> parametros, ArrayList<Simbolo> contexto) {
		super(lexema, returnType, contexto);
		
		this.parametros = parametros;
		this.contexto = contexto;
	}

	public ArrayList<Variavel> getParametros() {
		return parametros;
	}

	public void setParametros(ArrayList<Variavel> parametros) {
		this.parametros = parametros;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Funcao)) // Nao sao instancias de funcao
			return false;
		Funcao f = (Funcao) obj;
		
		if (!(f.getLexema().equals(getLexema()))) // Nome diferentes
			return false;
		
		if (!(f.getType().equalsIgnoreCase(getType()))) // Tipos diferentes
			return false;
		
		if (!(f.getParametros().size() == getParametros().size())) // Quantidade de parametros diferentes
			return false;
		
		for (int i = 0; i < f.getParametros().size(); i++) {
			if (!(f.getParametros().get(i).getType().equalsIgnoreCase(getParametros().get(i).getType()))) // Parametros com tipos diferentes
				return false;
		}
		
		return true;
	}
}
