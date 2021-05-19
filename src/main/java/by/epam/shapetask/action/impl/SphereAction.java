package main.java.by.epam.shapetask.action.impl;

import main.java.by.epam.shapetask.action.ShapeAction;
import main.java.by.epam.shapetask.entity.Sphere;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereAction implements ShapeAction {
    private static Logger logger = LogManager.getLogger();

    @Override
    public double findSurfaceSquare(Sphere sphere) {
        return 4.0 * Math.PI * Math.pow(sphere.getRadius(), 2.0);
    }

    @Override
    public double findVolume(Sphere sphere) {
        return (4 * Math.PI * Math.pow(sphere.getRadius(), 3)) / 3 ;
    }

    @Override
    public double findRatioOfVolume(Sphere sphere) {
        double differenceOfSphereParts = 0.0;
        double high = lengthToPlane(sphere);
        if (high < 0){
            logger.info("High of a hemisphere was set");
            double radius = Math.sqrt(Math.pow(sphere.getRadius(), 2) - Math.pow(Math.abs(high), 2));
            double capacityOfShape = (4 * Math.PI * Math.pow(radius, 3)) / 3;
            differenceOfSphereParts = findVolume(sphere) - capacityOfShape;
        }
        logger.info("Difference of a volume of hemispheres ratios was calculate");
        return differenceOfSphereParts;
    }

    @Override
    public boolean isSphere(Sphere sphere) {
        boolean flag = false;
        if (sphere.getRadius() > 0){
            logger.info("Shape is sphere");
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean isTouchCoordinatePlane(Sphere sphere) {
        boolean flag = false;
        if (lengthToPlane(sphere) <= 0){
            logger.info("Sphere is touch or crossing the plane");
            flag = true;
        }
        return flag;
    }

    private double lengthToPlane(Sphere sphere){
        double length = 1.0;
        if (Math.abs(sphere.getPoint().getCoordinateX()) - sphere.getRadius() <= 0){
            length = Math.abs(sphere.getPoint().getCoordinateX()) - sphere.getRadius();
            logger.info("Sphere is touch or crossing XY plane");
            return length;
        }
        if (Math.abs(sphere.getPoint().getCoordinateY()) - sphere.getRadius() <= 0){
            length = Math.abs(sphere.getPoint().getCoordinateY()) - sphere.getRadius();
            logger.info("Sphere is touch or crossing YZ plane");
            return length;
        }
        if (Math.abs(sphere.getPoint().getCoordinateZ()) - sphere.getRadius() <= 0){
            length = Math.abs(sphere.getPoint().getCoordinateZ()) - sphere.getRadius();
            logger.info("Sphere is touch or crossing ZX plane");
            return length;
        }
        return length;
    }
}
