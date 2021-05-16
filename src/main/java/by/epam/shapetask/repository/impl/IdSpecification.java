package main.java.by.epam.shapetask.repository.impl;

import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.repository.Specification;

public class IdSpecification implements Specification {
    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(AbstractShape shape) {
        return shape.getId() == this.id;
    }
}
