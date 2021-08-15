package com.javaprep.object_oriented_design.abstraction;

public class AbstractClassExample {
    public void execute() {
        Dog ob1 = new MyDog();
        ob1.action();
        ob1.bark();
        Dog ob2 = new StrayDog();
        ob2.bark();
        ob2.action();
    }

}

abstract class Dog{
    String type;
    Dog() {
        this.type = "Dog";
        System.out.println("this is a dog");
    }

    void bark(){
        System.out.println("woof");
    }
    abstract void action(); //this is an abstract method/pure virtual function.
}

class MyDog extends Dog{
    @Override
    void action(){
        System.out.println(type+" Jumps in the air");
    }
}

class StrayDog extends Dog {
    boolean isStray() {
        return true;
    }

    @Override
    void action() {
        System.out.println(type+" Walks on street");
    }
}

