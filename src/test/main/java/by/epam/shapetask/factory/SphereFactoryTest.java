package main.java.by.epam.shapetask.factory;

import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.entity.Point;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.exception.ShapeException;
import main.java.by.epam.shapetask.factory.impl.SphereFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SphereFactoryTest {
    private SphereFactory sphereFactory;
    private List<Double> correctData;
    private List<Double> wrongData;

    @BeforeTest
    public void before() {
        sphereFactory = new SphereFactory();
        correctData = new ArrayList<>();
        correctData.add(1.0);
        correctData.add(-2.3);
        correctData.add(-3.3);
        correctData.add(3.0);
        wrongData = new ArrayList<>();
        wrongData.add(-1.0);
        wrongData.add(-2.3);
        wrongData.add(-3.3);
        wrongData.add(-1.0);
    }

    @Test
    public void testCreate() throws ShapeException {
        AbstractShape sphere = sphereFactory.create(correctData);
        Sphere sphere1 = new Sphere(new Point(1.0, -2.3, -3.3), 3.0);
        Assert.assertEquals(sphere, sphere1);
    }

    @Test (expectedExceptions = ShapeException.class)
    public void testCreateException() {
        sphereFactory.create(wrongData);

    }
    @AfterTest
    public void after() {
        correctData = null;
        wrongData = null;
    }
}