package main.java.by.epam.shapetask.repository.impl;

import main.java.by.epam.shapetask.action.impl.SphereAction;
import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.repository.Specification;

public class VolumeSpecification implements Specification {
    private double minVolume;
    private double maxVolume;

    public VolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(AbstractShape shape) {
        SphereAction action = new SphereAction();
        double volume = action.findVolume((Sphere) shape);
        return volume >= minVolume && volume <= maxVolume;
    }
}
