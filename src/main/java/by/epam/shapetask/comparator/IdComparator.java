package main.java.by.epam.shapetask.comparator;

import main.java.by.epam.shapetask.entity.Sphere;

import java.util.Comparator;

public class IdComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere o1, Sphere o2) {
        return Double.compare(o1.getId(), o2.getId());
    }
}
