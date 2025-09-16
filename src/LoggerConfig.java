import java.util.logging.*;

public class LoggerConfig {
    public static Logger getLogger() {
        Logger logger = Logger.getLogger("LibraryLogger");
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
        logger.setLevel(Level.INFO);
        return logger;
    }
}
