package main.java.by.epam.shapetask.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenerationId {
    private static Logger logger = LogManager.getLogger();
    private static long id;

    public static long generateId(){
        logger.info("Id was set");
        return ++id;
    }
}
