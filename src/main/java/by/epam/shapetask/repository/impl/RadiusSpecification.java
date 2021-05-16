package main.java.by.epam.shapetask.repository.impl;

import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.repository.Specification;

public class RadiusSpecification implements Specification {

    private double radius;

    public RadiusSpecification(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean specify(AbstractShape shape) {
        return ((Sphere)shape).getRadius() == radius;
    }
}
