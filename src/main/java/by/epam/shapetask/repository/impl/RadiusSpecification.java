package main.java.by.epam.shapetask.repository.impl;

import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RadiusSpecification implements Specification {
    private static Logger logger = LogManager.getLogger();
    private double radius;

    public RadiusSpecification(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean specify(AbstractShape shape) {
        logger.info("RadiusSpecification was started");
        return ((Sphere)shape).getRadius() == radius;
    }
}
