package core;

import java.util.ArrayList;

public class Utils {
	
	
	public static Funcao string2Funcao(String stringParametros, String returnType) {
		stringParametros = stringParametros.replace(" ", "");
		stringParametros = stringParametros.replace(")", "");
		stringParametros = stringParametros.replace("(",",");
		String[] lista = stringParametros.split(",");
		String nome = lista[0];
		
		ArrayList<Variavel> parametros = new ArrayList<Variavel>();
		
		for (int i = 1; i < lista.length; i = i+2) {
			try {
				parametros.add(new Variavel(lista[i], lista[i+1],null, null));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new Funcao(nome, returnType, parametros, null);
	}
}
