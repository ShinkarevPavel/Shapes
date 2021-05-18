package main.java.by.epam.shapetask.repository.impl;

import main.java.by.epam.shapetask.action.impl.SphereAction;
import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SurfaceSpecification implements Specification {
    private static Logger logger = LogManager.getLogger();
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
        logger.info("SurfaceSpecification was started");
        return sphereSurface >= minSurface && sphereSurface <= maxSurface;
    }
}
