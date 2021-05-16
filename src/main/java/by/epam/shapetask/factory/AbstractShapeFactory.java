package main.java.by.epam.shapetask.factory;

import main.java.by.epam.shapetask.entity.AbstractShape;

import java.util.List;

public interface AbstractShapeFactory {
    AbstractShape create(List<Double> parameters);
}
