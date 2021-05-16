package main.java.by.epam.shapetask.reader;

import main.java.by.epam.shapetask.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DocumentReader {
    private static Logger logger = LogManager.getLogger();
    private List<String> stringsFromFile;

    public List<String> readStringsFromFile(String pathToFile) throws ShapeException{
        if (pathToFile != null){
            try {
                Stream<String> stringStream = Files.lines(Paths.get(pathToFile));
                stringsFromFile = stringStream.collect(Collectors.toList());
                logger.info("List of strings was created");
            } catch (IOException e){
                throw new ShapeException("Provided wrong file");
            }
            return stringsFromFile;
        }
        throw new ShapeException(pathToFile + " file doesn't exist");
    }
}
