package main;

import java.io.File;
import java.io.FileReader;

import cup.parser;
import flex.LexicalAnalysisC;
import core.CodeGen;
import core.TabelaSimbolos;

public class Main {

	public static void main(String argv[]) {

		LexicalAnalysisC s;

		for (int i = 0; i < argv.length; i++) {

			File file = new File(argv[i]);

			if (!file.exists()) {
				String filepath = System.getProperty("user.dir") + "\\"
						+ argv[i];
				System.out.println(filepath);
				file = new File(filepath);

				if (!file.exists()) {
					System.out.println("Arquivo " + argv[i]
							+ " não encontrado.");
					continue;
				}
			}

			try {
				System.out.println("Parsing [" + argv[i] + "]");
				s = new LexicalAnalysisC(new FileReader(file));
				parser p = new parser(s);
				p.parse();
				
//				TabelaSimbolos.getInstance().showAll();
				System.out.println( CodeGen.Go() ); 
				

			} catch (Exception e) {
				System.err.print(e.getMessage());
			}

		}
	}

}
