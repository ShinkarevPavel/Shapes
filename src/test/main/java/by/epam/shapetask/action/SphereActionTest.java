package main.java.by.epam.shapetask.action;

import main.java.by.epam.shapetask.action.impl.SphereAction;
import main.java.by.epam.shapetask.entity.Point;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.exception.ShapeException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SphereActionTest {
    private SphereAction sphereAction;


    @BeforeTest
    public void before() {
        sphereAction = new SphereAction();
    }

    @Test
    public void testFindSurfaceSquare() throws ShapeException {
        Sphere sphere = new Sphere(new Point(1.0, 1.1, 2.0), 5.0);
        double actual = sphereAction.findSurfaceSquare(sphere);
        double expected = 314.1592;
        double delta = 0.0001;
        Assert.assertEquals(actual, expected, delta);
    }

    @Test
    public void testFindVolume() throws ShapeException {
        Sphere sphere = new Sphere(new Point(1.0, 1.1, 2.0), 5.0);
        double actual = sphereAction.findVolume(sphere);
        double expected = 523.5987;
        double delta = 0.0001;
        Assert.assertEquals(actual, expected, delta);
    }

    @Test
    public void testFindRatioOfVolume() throws ShapeException {
        Sphere sphere = new Sphere(new Point(1.0, 1.1, 2.0), 0.5);
        double actual = sphereAction.findRatioOfVolume(sphere);
        double expected = 0.0;
        double delta = 0.0001;
        Assert.assertEquals(actual, expected, delta);
    }

    @Test
    public void testIsSphere() throws ShapeException {
        Sphere sphere = new Sphere(new Point(1.0, 1.1, 2.0), 5.0);
        boolean actual = sphereAction.isSphere(sphere);
        Assert.assertTrue(actual);
    }

    @Test (expectedExceptions = ShapeException.class)
    public void testIsNotSphere() throws ShapeException {
        Sphere sphere = new Sphere(new Point(1.0, 1.1, 2.0), 0.0);
        sphereAction.isSphere(sphere);
    }

    @Test
    public void testIsTouchCoordinatePlane()throws ShapeException {
        Sphere sphere = new Sphere(new Point(1.0, 1.1, 2.0), 5.5);
        boolean actual = sphereAction.isTouchCoordinatePlane(sphere);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsNotTouchCoordinatePlane() throws ShapeException {
        Sphere sphere = new Sphere(new Point(1.0, 1.1, 2.0), 0.5);
        boolean actual = sphereAction.isTouchCoordinatePlane(sphere);
        Assert.assertFalse(actual);
    }

    @AfterTest
    public void after(){
        sphereAction = null;
    }
}