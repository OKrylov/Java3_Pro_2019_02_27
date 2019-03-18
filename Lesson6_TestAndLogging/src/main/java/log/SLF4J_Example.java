package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class SLF4J_Example {

    private static Logger logger = LoggerFactory.getLogger(SLF4J_Example.class);

    public static void main(String[] args) throws IOException {
        InputStream propertiesStream = JUL_Example.class.getClassLoader().getResourceAsStream("jul.properties");
        LogManager.getLogManager().readConfiguration(propertiesStream);

        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.info("{}, {}!", "Hello", "World");
        logger.error("Error log message");
    }
}