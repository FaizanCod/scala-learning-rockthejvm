package com.learning.scala

object OOPs extends App {
  // Scala is an OO language

  // class and instance (instantiation is done with new keyword)
  // class definitions can be blank (without {})
  class Animal {
    val age: Int = 0
    def eat(): Unit = println("I am eating.")
  }
  val anAnimal = new Animal
  anAnimal.eat()

  // inheritance
  class Cat extends Animal
  val aCat = new Cat
  aCat.eat()

  // constructor definition (class definition with args)
  class Dog(name: String) extends Animal {
    override def eat(): Unit = println("I am a dog, eating")
  }
  val aDog = new Dog("Bob")

  // constructor arguments are NOT fields (internal data members)
  // aDog.name -> gives an ERROR since it is not a property associated with Dog class
  // the constructor is not visible outside the class definition
  // to allow the constructor to be a field, use "val" keyword before the constructor argument
  class Otter(val name: String) extends Animal
  val anOtter = new Otter("Jane")
  // accessible now
  println(anOtter.name)

  // subtype polymorphism (similar to run-time polymorphism in other languages, base class pointer pointing to derived class object)
  val anotherAnimal: Animal = new Dog("Haiku")
  // the eat() method here will be called from the most derived class ie, Dog here at runtime
  // at compile time, the compiler will treat it as a call from Animal object
  anotherAnimal.eat()
  // we can override the methods from base class in derived class using the override keyword before the method definition


  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true
    // this method has no definition, but only signature, therefore every class that inherits must override this method
    def walk(): Unit
  }

  class Penguin extends WalkingAnimal {
    override def walk(): Unit = println("Penguin is walking")
  }

  val penguin = new Penguin
  if (penguin.hasLegs) penguin.walk()
  else println("Penguin cannot walk")
}
