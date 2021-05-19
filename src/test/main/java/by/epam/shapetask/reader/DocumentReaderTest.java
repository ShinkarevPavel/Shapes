package main.java.by.epam.shapetask.reader;

import main.java.by.epam.shapetask.exception.ShapeException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DocumentReaderTest {
    private final String CORRECT_PATH = "./src/test/main/resources/sphereData.txt";
    private final String WRONG_PATH = "./src/test/main/resources/spher.txt";
    private DocumentReader documentReader;

    @BeforeTest
    public void before(){
        documentReader = new DocumentReader();
    }

    @Test
    public void testReadStringsFromFile() throws ShapeException {
        int actual = documentReader.readStringsFromFile(CORRECT_PATH).size();
        int expected = 10;
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = ShapeException.class)
    public void testExpectException() throws ShapeException{
        int actual = documentReader.readStringsFromFile(WRONG_PATH).size();
    }

    @Test (expectedExceptions = ShapeException.class)
    public void testReaderGetNull() throws ShapeException{
        documentReader.readStringsFromFile(null);
    }

    @AfterTest
    public void after(){
        documentReader = null;
    }
}