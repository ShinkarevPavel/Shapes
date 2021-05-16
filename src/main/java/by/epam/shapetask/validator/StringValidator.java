package main.java.by.epam.shapetask.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringValidator {
    private static Logger logger = LogManager.getLogger();
    private final String STRING_ON_DIGIT_VALIDATOR = "((-?\\d+.\\d+\\s+){3})(\\d+.\\d+){1}";


    public boolean isValid(String currentString) {
        boolean isPresent = false;
        if (currentString.matches(STRING_ON_DIGIT_VALIDATOR)) {
            isPresent = true;
            logger.info("String is valid");
        }
        return isPresent;
    }
}
