package main.java.by.epam.shapetask.repository.impl;

import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IdSpecification implements Specification {
    private static Logger logger = LogManager.getLogger();
    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(AbstractShape shape) {
        logger.info("IdSpecification was started");
        return shape.getId() == this.id;
    }
}
