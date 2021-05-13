package main.java.by.epam.shapetask.entity;

import main.java.by.epam.shapetask.util.GenerationId;

public abstract class AbstractShape {
    private long id;

    public AbstractShape() {
        this.id = GenerationId.generateId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
