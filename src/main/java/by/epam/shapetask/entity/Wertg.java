package main.java.by.epam.shapetask.entity;

public class Wertg {
   static class A{
        public void print(){
            System.out.println("a");
        }
    }

    static class B extends A{
        public void print(){
            System.out.println("b");
        }
    }

    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        a.print();
        b.print();

    }
}
