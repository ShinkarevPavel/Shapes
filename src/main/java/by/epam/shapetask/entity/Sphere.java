package main.java.by.epam.shapetask.entity;

import main.java.by.epam.shapetask.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sphere extends AbstractShape {

    private Logger logger = LogManager.getLogger();
    private Point point;
    private double radius;

    public Sphere(Point point, double radius) throws ShapeException{
        super();
        if (point == null){
            throw new ShapeException("Null in Point coordinates");
        }
        if (radius <= 0){
            throw new ShapeException("0 or negative value into radius parameter");
        }
        this.point = point;
        logger.info("Sphere object was created");
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 &&
                point.equals(sphere.point) && super.getId() == sphere.getId();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result + point.hashCode() * 31;
        result = result + (int)radius * 31;
        result = result + (int)super.getId() * 31;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                            .append("Sphere{")
                            .append(point.toString())
                            .append(" radius=")
                            .append(radius)
                            .append("}")
                            .toString();
    }
}
