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
  class Dog(name: String) extends Animal
  val aDog = new Dog("Bob")

  // constructor arguments are NOT fields (internal data members)
  // aDog.name -> gives an ERROR since it is not a property associated with Dog class
  // the constructor is not visible outside the class definition
  // to allow the constructor to be a field, use "val" keyword before the constructor argument
  class Otter(val name: String) extends Animal
  val anOtter = new Otter("Jane")
  // accessible now
  println(anOtter.name)


}
