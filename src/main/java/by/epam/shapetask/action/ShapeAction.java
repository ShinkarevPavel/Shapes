package main.java.by.epam.shapetask.action;

import main.java.by.epam.shapetask.entity.Sphere;

public interface ShapeAction {
    double findSurfaceSquare(Sphere sphere);
    double findVolume(Sphere sphere);
    double findRatioOfVolume(Sphere sphere);
    boolean isSphere(Sphere sphere);
    boolean isTouchCoordinatePlane(Sphere sphere);

}
