package main.java.by.epam.shapetask.util;

public class GenerationId {
    private static long id;

    public static long generateId(){
        return ++id;
    }
}
