package main.java.by.epam.shapetask.repository.impl;

import main.java.by.epam.shapetask.entity.AbstractShape;
import main.java.by.epam.shapetask.entity.Sphere;
import main.java.by.epam.shapetask.repository.ShapeRepository;
import main.java.by.epam.shapetask.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SphereRepository implements ShapeRepository {
    private static SphereRepository instance;
    private static Logger logger = LogManager.getLogger();
    private Map<Long, Sphere> spheres = new HashMap<>();
    private Sphere currentSphere;

    private SphereRepository(){}

    public static SphereRepository getInstance(){
        if (instance == null){
            instance = new SphereRepository();
        }
        return instance;
    }

    public Map<Long, Sphere> getSpheres() {
        return spheres;
    }

    @Override
    public boolean add(AbstractShape shape) {
        boolean flag= false;
        if (spheres.put(shape.getId(),(Sphere)shape) != null){
            logger.debug("Sphere was added to repository");
            flag = true;
        }
        return flag;
    }

    @Override
    public AbstractShape findById(Long id) {
        if (spheres.containsKey(id)){
            currentSphere = spheres.get(id);
            logger.info("Sphere was found in collection");
        }
        return currentSphere;
    }

    @Override
    public boolean replace(Long id, AbstractShape shape) {
        boolean flag = false;
        if (spheres.containsKey(id)){
            spheres.put(id, (Sphere) shape);
            flag = true;
            logger.info("Sphere was replaced");
        }
        return flag;
    }

    @Override
    public boolean remove(AbstractShape shape) {
        boolean flag = false;
        if (spheres.remove(shape.getId()) != null){
            flag = true;
            logger.info("Sphere was removed");
        }
        return flag;
    }

    @Override
    public List<Sphere> query(Specification specification) {
        List<Sphere> queryList = new ArrayList<>();
        for (Map.Entry<Long, Sphere> sphere : spheres.entrySet()){
            if (specification.specify(sphere.getValue())){
                queryList.add(sphere.getValue());
                logger.info("Query was processed with " + specification.getClass().getName());
            }
        }
        return queryList;
    }
}
