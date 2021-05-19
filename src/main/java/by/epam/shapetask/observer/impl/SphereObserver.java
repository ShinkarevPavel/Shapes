package main.java.by.epam.shapetask.observer.impl;

import main.java.by.epam.shapetask.entity.Characteristic;
import main.java.by.epam.shapetask.action.impl.SphereAction;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.observer.Observer;
import main.java.by.epam.shapetask.observer.SphereEvent;
import main.java.by.epam.shapetask.warehouse.SphereWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereObserver  implements Observer {
    private static Logger logger = LogManager.getLogger();
    private static SphereObserver instance;

    private SphereObserver() {
    }

    public static SphereObserver getInstance(){
        if (instance == null){
            instance = new SphereObserver();
        }
        return instance;
    }

    @Override
    public void update(SphereEvent event) {
        Sphere sphere = event.getSource();
        SphereAction action = new SphereAction();
        SphereWarehouse sphereWarehouse = SphereWarehouse.getInstance();
        Characteristic characteristic;
        double square = action.findSurfaceSquare(sphere);
        double volume = action.findVolume(sphere);
        boolean isSphere = action.isSphere(sphere);
        boolean isTouchCoordinatePlane = action.isTouchCoordinatePlane(sphere);
        characteristic = new Characteristic(volume, square, isSphere, isTouchCoordinatePlane);
        sphereWarehouse.putCharacteristic(sphere.getId(), characteristic);
    }
}
