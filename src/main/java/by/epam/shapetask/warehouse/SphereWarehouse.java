package main.java.by.epam.shapetask.warehouse;

import main.java.by.epam.shapetask.entity.Characteristic;
import main.java.by.epam.shapetask.action.impl.SphereAction;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class SphereWarehouse {
    private static SphereWarehouse instance;
    private static Logger logger = LogManager.getLogger();
    private Map<Long, Characteristic> characteristic;
    private SphereAction action;

    private SphereWarehouse(){
        characteristic = new HashMap<>();
        action = new SphereAction();
    }

    public static SphereWarehouse getInstance(){
        if (instance == null){
            instance = new SphereWarehouse();
        }
        return instance;
    }

    public void putCharacteristic(Long id, Characteristic characteristic) {
        logger.info("Characteristic was added to warehouse");
        this.characteristic.put(id, characteristic);
    }

    public Characteristic getCharacteristic(Sphere sphere) {
        return characteristic.get(sphere.getId());
    }

    public void removeCharacteristic(Long id) throws ShapeException{
        if (id == null){
            throw new ShapeException(String.format("Characteristic with %s id don`t exist", id));
        }
        logger.info("Characteristic was removed from warehouse");
        this.characteristic.remove(id);
    }

    public boolean contains(Long id){
        return characteristic.containsKey(id);
    }
}
