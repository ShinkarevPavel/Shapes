package main.java.by.epam.shapetask.main;

import main.java.by.epam.shapetask.exception.ShapeException;
import main.java.by.epam.shapetask.parser.DigitParser;
import main.java.by.epam.shapetask.reader.DocumentReader;
import main.java.by.epam.shapetask.repository.ShapeRepository;
import main.java.by.epam.shapetask.repository.impl.SphereRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        DocumentReader documentReader = new DocumentReader();
        List<String> list = null;
        try {
            list = documentReader.readStringsFromFile("./src/resources/data/sphereData.txt");
        } catch (ShapeException e) {
            logger.info("issue");
        }

        SphereRepository.getInstance();

    }
}
