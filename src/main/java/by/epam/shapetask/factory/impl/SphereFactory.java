package main.java.by.epam.shapetask.factory.impl;

import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.entity.Point;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.exception.ShapeException;
import main.java.by.epam.shapetask.factory.AbstractShapeFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SphereFactory implements AbstractShapeFactory {
    private static Logger logger = LogManager.getLogger();
    private Sphere currentSphere;

    @Override
    public AbstractShape create(List<Double> parameters) {
        Point point = new Point();
        point.setCoordinateX(parameters.get(0));
        point.setCoordinateY(parameters.get(1));
        point.setCoordinateZ(parameters.get(2));
        try {
            currentSphere = new Sphere(point, parameters.get(3));
            logger.info("Sphere was created");
        } catch (ShapeException e){
            logger.info("Wrong data for Sphere creating");
        }
        return currentSphere;
    }
}
