//package log;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class Log4j_Example {
//
//    private static final Logger log = LogManager.getLogger(Log4j_Example.class);
//
//    public static void main(String[] args)
//    {
//        // Trace < Debug < Info < Warn < Error < Fatal
//        log.debug("Debug Message Logged !!!");
//        String name = "Oleg";
//        log.info("Info Message Logged !!! My name is " + name);
//        log.info("Info Message Logged !!! My name is {}", name);
//        log.error("Error Message Logged !!!", new NullPointerException("NullError"));
//    }
//}
