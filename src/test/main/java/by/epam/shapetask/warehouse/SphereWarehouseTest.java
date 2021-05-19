package main.java.by.epam.shapetask.warehouse;

import main.java.by.epam.shapetask.action.impl.SphereAction;
import main.java.by.epam.shapetask.entity.Characteristic;
import main.java.by.epam.shapetask.entity.Point;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.exception.ShapeException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SphereWarehouseTest {
    private SphereAction action;
    private Characteristic characteristic;
    private Sphere sphere;

    @BeforeTest
    public void before() throws ShapeException {
        action = new SphereAction();
        sphere = new Sphere(new Point(1.0, 2.0, 3.0), 2.0);
        characteristic = new Characteristic(action.findVolume(sphere), action.findSurfaceSquare(sphere),
                action.isSphere(sphere), action.isTouchCoordinatePlane(sphere));
        SphereWarehouse.getInstance().putCharacteristic(sphere.getId(), characteristic);
    }

    @Test
    public void testPutCharacteristic() {
        SphereWarehouse.getInstance().putCharacteristic(sphere.getId(),characteristic);
        int actual = SphereWarehouse.getInstance().getAllCharacteristic().size();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetCharacteristic() {
        Characteristic actual = SphereWarehouse.getInstance().getCharacteristic(sphere);
        Characteristic expected = characteristic;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testRemoveCharacteristic() throws ShapeException {
        SphereWarehouse.getInstance().removeCharacteristic(sphere.getId());
        int actual = SphereWarehouse.getInstance().getAllCharacteristic().size();
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testContains() {
        Assert.assertTrue(SphereWarehouse.getInstance().contains(sphere.getId()));
    }

    @AfterTest
    public void after() {
        action = null;
        characteristic = null;
        sphere = null;
    }
}