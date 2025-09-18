package utils;

public class Logger {
    public static final Logger LOGGER = new Logger();

    public void logInfo(String classe, String metodo, String mensagem){
        System.out.println("[INFO] [" + classe + "] [" + metodo + "] " + mensagem);
    }

    public void logError(String classe, String metodo, String mensagem){
        System.err.println("[ERROR] [" + classe + "] [" + metodo + "] " + mensagem);
    }

    public void logWarning(String classe, String metodo, String mensagem){
        System.out.println("[WARNING] [" + classe + "] [" + metodo + "] " + mensagem);
    }

    
}
