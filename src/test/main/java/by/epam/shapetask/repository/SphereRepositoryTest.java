package main.java.by.epam.shapetask.repository;

import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.entity.Point;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.exception.ShapeException;
import main.java.by.epam.shapetask.repository.impl.RadiusSpecification;
import main.java.by.epam.shapetask.repository.impl.SphereRepository;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SphereRepositoryTest {
    private Sphere sphere1;
    private Sphere sphere2;
    private Sphere sphere3;
    private Sphere sphere4;


    @BeforeTest
    public void before() throws ShapeException{
        sphere1 = new Sphere(new Point(1.0, 2.0, 3.0), 2.0);
        sphere2 = new Sphere(new Point(2.3, 2.1, 1.0), 1.0);
        sphere3 = new Sphere(new Point(34.0, 1.0, 3.1), 12.0);
        sphere4 = new Sphere(new Point(4.0, 5.0, 1.0), 22.0);
        SphereRepository.getInstance().add(sphere1);
        SphereRepository.getInstance().add(sphere2);
        SphereRepository.getInstance().add(sphere3);
        SphereRepository.getInstance().add(sphere4);
    }

    @Test
    public void testGetSpheres() {
        int actual = SphereRepository.getInstance().getSpheres().size();
        int expected = 4;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAdd() {
        Assert.assertFalse(SphereRepository.getInstance().add(sphere1));
    }

    @Test
    public void testFindById() {
        AbstractShape actual = SphereRepository.getInstance().findById(1L);
        Sphere expected = sphere1;
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testReplace() {
        Assert.assertTrue(SphereRepository.getInstance().replace(3L, sphere4));
    }

    @Test
    public void testRemove() {
        boolean actual = SphereRepository.getInstance().remove(sphere1);;
        Assert.assertTrue(actual);
    }

    @Test
    public void testQuery() {
        RadiusSpecification idSpecification = new RadiusSpecification(22);
        List<Sphere> spheres = SphereRepository.getInstance().query(idSpecification);
        double actual = spheres.size();
        double expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void after(){
        sphere1 = null;
        sphere2 = null;
        sphere3 = null;
        sphere4 = null;
    }
}