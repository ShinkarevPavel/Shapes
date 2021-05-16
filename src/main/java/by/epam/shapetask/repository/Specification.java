package main.java.by.epam.shapetask.repository;

import main.java.by.epam.shapetask.entity.AbstractShape;

public interface Specification {
    boolean specify(AbstractShape shape);
}
