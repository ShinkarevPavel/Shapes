package main.java.by.epam.shapetask.parser;

import main.java.by.epam.shapetask.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DigitParser {
    private static Logger logger = LogManager.getLogger();
    private final String STRING_DELIMITER = "\\s+";
    private final String STRING_ON_DIGIT_VALIDATOR = "((-?\\d+.\\d+\\s+){3})(\\d+.\\d+){1}";
    private List<Double> sphereParameters;


    public DigitParser() {
        this.sphereParameters = new ArrayList<>();
    }

    public List<Double> parser(String currentString) throws ShapeException{
        if (currentString.matches(STRING_ON_DIGIT_VALIDATOR)){
            String[] temp = currentString.split(STRING_DELIMITER);
            for (String s : temp){
                sphereParameters.add(Double.parseDouble(s));
            }
            return sphereParameters;
        }
        throw new ShapeException("Provided string not valid for creating sphere");
    }
}
