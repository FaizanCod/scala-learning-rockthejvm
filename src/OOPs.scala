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



}
