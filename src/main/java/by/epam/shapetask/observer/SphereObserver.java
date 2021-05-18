package main.java.by.epam.shapetask.observer;

import main.java.by.epam.shapetask.entity.Characteristic;
import main.java.by.epam.shapetask.action.impl.SphereAction;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.warehouse.SphereWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereObserver implements Observer {
    private static Logger logger = LogManager.getLogger();
    private static SphereObserver instance;

    private SphereObserver() {
    }

    public SphereObserver getInstance(){
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
        if (sphereWarehouse.contains(sphere.getId())){
            characteristic = sphereWarehouse.getCharacteristic(sphere);
            logger.info(String.format("Characteristics with id %s are present", sphere.getId()));
        } else {
            logger.info("Created new Characteristics");
            characteristic = new Characteristic();
        }
        characteristic.setSurfaceSquare(square);
        characteristic.setVolume(volume);
        characteristic.setSphere(isSphere);
        characteristic.setIsTouchCoordinatePlane(isTouchCoordinatePlane);
        sphereWarehouse.putCharacteristic(sphere.getId(), characteristic);
    }
}
