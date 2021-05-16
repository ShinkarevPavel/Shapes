package main.java.by.epam.shapetask.repository.impl;

import main.java.by.epam.shapetask.action.impl.SphereAction;
import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.repository.Specification;

public class SurfaceSpecification implements Specification {
    private double minSurface;
    private double maxSurface;

    public SurfaceSpecification(double minSurface, double maxSurface) {
        this.minSurface = minSurface;
        this.maxSurface = maxSurface;
    }

    @Override
    public boolean specify(AbstractShape shape) {
        SphereAction action = new SphereAction();
        double sphereSurface = action.findSurfaceSquare((Sphere) shape);
        return sphereSurface >= minSurface && sphereSurface <= maxSurface;
    }
}
