package main.java.by.epam.shapetask.entity;

import main.java.by.epam.shapetask.exception.ShapeException;

public class Point {
    private double coordinateX;
    private double coordinateY;
    private double coordinateZ;

    public Point() {
    }

    public Point(double coordinateX, double coordinateY, double coordinateZ) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double getCoordinateZ() {
        return coordinateZ;
    }

    public void setCoordinateZ(double coordinateZ) {
        this.coordinateZ = coordinateZ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        if (Double.compare(point.coordinateX, coordinateX) != 0) {
            return false;
        }
        if (Double.compare(point.coordinateY, coordinateY) != 0) {
            return false;
        }
        return Double.compare(point.coordinateZ, coordinateZ) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result + (int) coordinateX * 17;
        result = result + (int) coordinateY * 31;
        result = result + (int) coordinateZ * 39;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append("Point{")
                .append("x-coordinate=")
                .append(coordinateX)
                .append(" y-coordinate=")
                .append(coordinateY)
                .append(" z-coordinate=")
                .append(coordinateZ)
                .append("}")
                .toString();
    }
}
