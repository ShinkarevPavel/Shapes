package main.java.by.epam.shapetask.entity;

public class Characteristic {
    private double volume;
    private double surfaceSquare;
    private boolean isSphere;
    private boolean isTouchCoordinatePlane;

    public Characteristic(double volume, double surfaceSquare, boolean isSphere, boolean isTouchCoordinatePlane) {
        this.volume = volume;
        this.surfaceSquare = surfaceSquare;
        this.isSphere = isSphere;
        this.isTouchCoordinatePlane = isTouchCoordinatePlane;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSurfaceSquare() {
        return surfaceSquare;
    }

    public void setSurfaceSquare(double surfaceSquare) {
        this.surfaceSquare = surfaceSquare;
    }

    public boolean isSphere() {
        return isSphere;
    }

    public void setSphere(boolean sphere) {
        isSphere = sphere;
    }

    public boolean getIsTouchCoordinatePlane() {
        return isTouchCoordinatePlane;
    }

    public void setIsTouchCoordinatePlane(boolean isTouchCoordinatePlane) {
        this.isTouchCoordinatePlane = isTouchCoordinatePlane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Characteristic that = (Characteristic) o;
        return Double.compare(that.volume, volume) == 0 &&
                Double.compare(that.surfaceSquare, surfaceSquare) == 0 &&
                isSphere == that.isSphere &&
                isTouchCoordinatePlane == that.isTouchCoordinatePlane;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result + (int) volume * 17;
        result = result + (int) surfaceSquare * 37;
        result = result + (isSphere? 1 : 0) * 39;
        result = result + (isTouchCoordinatePlane ? 1 : 0) * 31;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append("Characteristic{ volume=")
                .append(volume)
                .append(" surfaceSquare=")
                .append(surfaceSquare)
                .append("isSphere=")
                .append(" isTouchCoordinatePlane=")
                .append(isTouchCoordinatePlane)
                .append("}")
                .toString();
    }
}
