package main.java.by.epam.shapetask.repository;

import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.entity.Sphere;

import java.util.List;

public interface ShapeRepository {
    boolean add(AbstractShape shape);
    AbstractShape findById(Long id);
    boolean replace(Long id, AbstractShape shape);
    boolean remove(AbstractShape shape);
    List<Sphere> query(Specification specification);
}
