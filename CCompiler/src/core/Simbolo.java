package core;

import java.util.ArrayList;

public class Simbolo {
	String lexema, type;
	ArrayList<Simbolo> contexto;
	
	public Simbolo(String lexema, String type, ArrayList<Simbolo> contexto) {
		this.lexema = lexema;
		this.type = type;
		
		if (contexto == null) {
			this.contexto = new ArrayList<Simbolo>();
		} else {
			this.contexto = contexto;
		}
	}

	public String getLexema() {
		return lexema;
	}

	public void setLexema(String lexema) {
		this.lexema = lexema;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void addInContexto(Simbolo s) {
		contexto.add(s);
	}
	
	public ArrayList<Simbolo> getContexto() {
		return this.contexto;
	}
	
	public void showContext() {
		String result = getLexema() + ":contexto: ";
		for (Simbolo s : this.contexto) {
			result += s + ",";
		}
		
		LogHandler.showInfo(result);
	}
	
	public boolean removeFromContexto(Simbolo s) {
		for (int i = 0; i < this.contexto.size(); i++) {
			if (this.contexto.get(i).getLexema().equals(s.getLexema())) {
				this.contexto.remove(i);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		return lexema + "(" + type + ")";
	}
	
	
}
