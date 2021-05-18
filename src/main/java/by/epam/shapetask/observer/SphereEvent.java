package main.java.by.epam.shapetask.observer;

import main.java.by.epam.shapetask.entity.Sphere;

import java.util.EventObject;

public class SphereEvent extends EventObject {

    public SphereEvent(Object source) {
        super(source);
    }

    @Override
    public Sphere getSource() {
        return (Sphere) super.getSource();
    }
}
