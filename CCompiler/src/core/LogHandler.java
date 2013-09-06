package core;

public class LogHandler {
//	OFF(0), TRACE(1), DEBUG(2), INFO(3), WARN(4), ERROR(5);
	static int TRACE = 5, DEBUG = 4, INFO = 3, WARN = 2, ERROR = 1, OFF = 0;
	static int LEVEL = DEBUG;
	
	public static void funcAlreadyExist(Funcao f) {
		showError("Funcao já existe: " + f.getLexema());
	}
	
	public static void varAlreadyExist(Variavel v) {
		showError("Variavel já existe: " + v.getLexema());
	}
	
	public static void showTrace(String msg) {
		if (LEVEL >= TRACE) {
			System.out.println("TRACE: " + msg);
		}
	}
	
	public static void showDebug(String msg) {
		if (LEVEL >= DEBUG) {
			System.out.println("DEBUG: " + msg);
		}
	}
	
	public static void showInfo(String msg) {
		if (LEVEL >= INFO) {
			System.out.println("INFO: " + msg);
		}
	}
	
	public static void showWarn(String msg) {
		if (LEVEL >= WARN) {
			System.out.println("WARN: " + msg);
		}
	}
	
	public static void showError(String msg) {
		if (LEVEL >= ERROR) {
			System.err.println("ERROR: " + msg);
		}
	}
	
}
