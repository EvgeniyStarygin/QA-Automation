package ui_task.loggers;

import org.apache.log4j.Logger;

public class MailRuLogger {

    private static Logger fileLogger = Logger.getLogger("FileLogger");

    public static void logInfo(String message){
        fileLogger.info(message);
    }

    public static void logDebug(String message){
        fileLogger.debug(message);
    }
}
