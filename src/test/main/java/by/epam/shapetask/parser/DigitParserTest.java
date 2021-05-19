package main.java.by.epam.shapetask.parser;

import main.java.by.epam.shapetask.exception.ShapeException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DigitParserTest {
    private final String VALID_STRING = "1.0 2.0 3.0 1.0";
    private final String NOT_VALID_STRING = "1.0 2.0 3.0 -1.0";
    private DigitParser digitParser;

    @BeforeTest
    public void before() {
        digitParser = new DigitParser();
    }

    @Test
    public void testParser() throws ShapeException {
        int actual = digitParser.parser(VALID_STRING).size();
        int expected = 4;
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = ShapeException.class)
    public void testExceptionParser() throws ShapeException{
        digitParser.parser(NOT_VALID_STRING);
    }

    @AfterTest
    public void after(){
        digitParser = null;
    }
}