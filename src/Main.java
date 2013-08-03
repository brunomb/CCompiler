import java.io.FileReader;
import java_cup.runtime.*;
import java.io.FileReader;

public class Main {
//	public static void main (String[] args) {
//		try {
//			LexicalAnalysisCalculator scanner = new LexicalAnalysisCalculator( new java.io.FileReader(args[0]) );
//			parser p = new parser(scanner);
//			System.out.println(p.parse());
//		} catch (Exception e) {	
//			System.out.println(e);
//		}
//	}
	  public static void main(String argv[]) {
		    
		  LexicalAnalysisCalculator s;
		    int errors = 0;
		    
		    for (int i = 0; i < argv.length; i++) {
		      try {
		        System.out.println("Parsing ["+argv[i]+"]");
		        s = new LexicalAnalysisCalculator(new FileReader(argv[i]));
		        parser p = new parser(s);
		        p.parse();
		        System.out.println("Number of semantics errors = " + errors + ".");
		        if(errors == 0) {
		                System.out.println("OK :)");
		        }
		        else {
		                System.out.println("Error :(");
		        }
		      }
		      catch (Exception e) {
		        e.printStackTrace(System.out);
		        System.exit(1);
		      }
		    }
		  }
}

