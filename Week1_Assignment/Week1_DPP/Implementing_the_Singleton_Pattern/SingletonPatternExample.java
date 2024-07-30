public class SingletonPatternExample {

    // Singleton Logger class
    public static class Logger {
        // Private static instance of the class
        private static Logger instance;
        
        // Private constructor to prevent instantiation
        private Logger() {
            // Initialization code (if any)
        }
        
        // Public static method to provide the single instance
        public static Logger getInstance() {
            if (instance == null) {
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }
        
        // Example method to simulate logging
        public void log(String message) {
            System.out.println(message);
        }
    }

    // Main method to test the Singleton Logger
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        // Test if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
        
        // Use the logger to log messages
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
    }
}
