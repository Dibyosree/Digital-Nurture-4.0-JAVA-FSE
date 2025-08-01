public class SingletonPatternExample {
    static class Logger {
        private static Logger instance;
        private Logger() {
            System.out.println("Logger instance created.");
        }
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }
        public void log(String message) {
            System.out.println("[LOG]: " + message);
        }
    }
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");
        if (logger1 == logger2) {
            System.out.println("only one Logger instance exists.");
        } else {
            System.out.println("Different Logger instances exist.");
        }
    }
}

