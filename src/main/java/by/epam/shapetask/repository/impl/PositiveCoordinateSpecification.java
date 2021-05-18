package main.java.by.epam.shapetask.repository.impl;

import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PositiveCoordinateSpecification implements Specification {
    private static Logger logger = LogManager.getLogger();


    @Override
    public boolean specify(AbstractShape shape) {
        boolean flag = false;

        if (((Sphere)shape).getPoint().getCoordinateX() > 0 &&
            ((Sphere)shape).getPoint().getCoordinateY() > 0 &&
            ((Sphere)shape).getPoint().getCoordinateZ() > 0) {
            flag = true;
            logger.info("PositiveCoordinateSpecification was started");
        }
        return flag;
    }
}
