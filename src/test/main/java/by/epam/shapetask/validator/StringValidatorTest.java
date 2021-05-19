package main.java.by.epam.shapetask.validator;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringValidatorTest {
    private final String VALID_STRING = "1.0 2.0 3.0 1.0";
    private final String NOT_VALID_STRING = "1.0 2.0 3.0 -1.0";
    private StringValidator stringValidator;

    @BeforeTest
    public void before(){
        stringValidator = new StringValidator();
    }
    @Test
    public void testIsValid() {
        boolean actual = stringValidator.isValid(VALID_STRING);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsNotValid(){
        boolean actual = stringValidator.isValid(NOT_VALID_STRING);
        Assert.assertFalse(actual);
    }

    @AfterTest
    public void after(){
        stringValidator = null;
    }
}