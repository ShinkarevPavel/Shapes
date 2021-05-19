package main.java.by.epam.shapetask.observer;

import main.java.by.epam.shapetask.action.impl.SphereAction;
import main.java.by.epam.shapetask.entity.Characteristic;
import main.java.by.epam.shapetask.entity.Point;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.exception.ShapeException;
import main.java.by.epam.shapetask.observer.impl.SphereObserver;
import main.java.by.epam.shapetask.warehouse.SphereWarehouse;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SphereObserverTest {
    private Sphere sphere;
    private Characteristic characteristic;
    private SphereAction action;
    private SphereEvent sphereEvent;

    @BeforeTest
    public void before() throws ShapeException {
        action = new SphereAction();
        sphere = new Sphere(new Point(11.0, 2.0, -3.0), 12.0);
        characteristic = new Characteristic(action.findVolume(sphere), action.findSurfaceSquare(sphere),
                action.isSphere(sphere), action.isTouchCoordinatePlane(sphere));
        SphereWarehouse.getInstance().putCharacteristic(sphere.getId(), characteristic);
    }

    @Test
    public void testUpdate() {
        sphere.setRadius(2);
        sphereEvent = new SphereEvent(sphere);
        SphereObserver.getInstance().update(sphereEvent);
        double actual = SphereWarehouse.getInstance().getCharacteristic(sphere).getVolume();
        double expected = 33.5103;
        double delta = 0.0001;
        Assert.assertEquals(actual, expected, delta);
    }
    @AfterTest
    public void after() {
        action = null;
        sphere = null;
        characteristic = null;
    }
}