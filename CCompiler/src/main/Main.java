package main;

import java.io.FileReader;

import cup.parser;
import flex.LexicalAnalysisC;
public class Main {

	public static void main(String argv[]) {

		LexicalAnalysisC s;
		int errors = 0;

		for (int i = 0; i < argv.length; i++) {
			try {
				System.out.println("Parsing [" + argv[i] + "]");
				s = new LexicalAnalysisC(new FileReader(argv[i]));
				parser p = new parser(s);
				p.parse();
				System.out.println("Number of semantics errors = " + errors
						+ ".");
				if (errors == 0) {
					System.out.println("OK :)");
				} else {
					System.out.println("Error :(");
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
				
				System.exit(1);
			}
		}
	}
	
}
