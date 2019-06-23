package com.iankoulski.problems.ccibook.sq;

import java.util.NoSuchElementException;

/*
Problem:
An animal shelter holds only dogs and cats and operates on first in, first out basis.
People can select either the oldest animal and get the oldest dog or cat, or they can
request the oldest dog or cat specifically. Oldest refers to the most time spent at the shelter
in waiting to be adopted.
Create the data structures to maintain this system. Implement methods: enqueue, dequeueAny,
dequeueDog, dequeueCat. You may use the built in LinkedList data structure.

Example:
Input: Cat(sally)<-Dog(bob)<-Dog(ruf)<-Cat(kit)
dequeueAny Output: Cat(kit)
dequeueDog Output: Dog(ruf)
dequeueCat Output: Cat(kit)

Algo:
#1
Maintain a queue of Animals
Search for Dog or Cat 

#2
Maintain a queue of Animals
Maintain a queue of Dogs
Maintain a queue of Cats
Remove Dog or Cat from Animals when dequeued

Will implement #1

*/

class Animal {
    public String name;
    public int order;
    public Animal(String name){
        this.name=name;
    }

    public String toString(){
        return name;
    }
}

class Dog extends Animal{
    public Dog(String name){
        super(name);
    }
}

class Cat extends Animal{
    public Cat(String name){
        super(name);
    }
}

public class AnimalShelter {

    Queue<Animal> cats = new Queue<Animal>();
    Queue<Animal> dogs = new Queue<Animal>();
    int index = 0;

    public static void main(String[] args){
        AnimalShelter shelter = new AnimalShelter();
        Cat kit = new Cat("Kit");
        shelter.enqueue(kit);
        Dog ruf = new Dog("Ruf");
        shelter.enqueue(ruf);
        Dog bob = new Dog("Bob");
        shelter.enqueue(bob);
        Cat sally = new Cat("Sally");
        shelter.enqueue(sally);
        System.out.println("Input:\n   Dogs: " + shelter.dogs.getString() + "\n   Cats: " + shelter.cats.getString());
        Animal animal = shelter.dequeueDog();
        System.out.println("dequeueDog Output: " + animal.name);
    }

    void enqueue(Animal a){
        index++;
        a.order=index;
        if (a instanceof Dog) dogs.add(a);
        else if (a instanceof Cat) cats.add(a);
    }

    Animal dequeueAny(){
        Animal c = cats.peek();
        Animal d = dogs.peek();
        Animal a = null;
        if (d.order <= c.order){
            a = dogs.remove();
        }else{
            a = cats.remove();
        }
        return a;
    }

    Animal dequeueDog(){
        if (dogs.isEmpty()) throw new NoSuchElementException();
        Animal a = dogs.remove();
        return a;
    }

    Animal dequeueCat(){
        if (cats.isEmpty()) throw new NoSuchElementException();
        Animal a = cats.remove();
        return a;
    }

}