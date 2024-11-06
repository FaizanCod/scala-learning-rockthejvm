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
    // all fields and methods are public by default, but can be changed to private/protected
    // private cannot be accessed outside the class and protected can only be accessed in same class or derived class
    private val canFly = false
    protected def fly(): Unit = println("Trying to fly")
    override def walk(): Unit = println("Penguin is walking")
  }

  val penguin = new Penguin
  if (penguin.hasLegs) penguin.walk()
  else println("Penguin cannot walk")


  // interfaces - pure abstract classes, use keyword "trait"
  // sometimes Scala does allow concrete methods inside "trait" but it should only be used for pure abstract fields and methods
  trait Carnivore {
    val haveIncisors: Boolean
    def eat(animal: Animal): Unit
  }

  trait Mammal {
    val haveMammaryGlands: Boolean
  }

  // extends keyword is only used to inherit traits
  class Lion extends Carnivore {
    override val haveIncisors: Boolean = true
    override def eat(animal: Animal): Unit = println("Eating animal")
  }

  // Scala allows only a single-class inheritance but multiple trait inheritance ("mixin")
  class Cheetah extends WalkingAnimal with Carnivore with Mammal {
    // we can also override concrete fields or methods
    override def walk(): Unit = true
    override val haveIncisors: Boolean = true
    override def eat(animal: Animal): Unit = println("Eating animal")
    override val haveMammaryGlands: Boolean = true
  }

  // Method notations & naming
  val aCheetah = new Cheetah();
  // another notation for the statement "aCheetah.eat(anOtter);" is
  aCheetah eat anOtter // infix notation (only for methods having one argument), of the form = "object method argument"
  // by providing this notation, Scala is expressive and very similar to natural language

  // method naming
  trait Philosopher {
    def ?!(thought: String): Unit
    // ?! is a VALID method name
    // ? is also used in method "aka" and ! is used when we want to communicate with actors async
  }

  class Human extends Philosopher {
    // need to override "?!" method
    override def ?!(thought: String): Unit = println(s"I was thinking...$thought")
  }

  val aHuman = new Human();
  aHuman ?! "What if we live in a simulation?"
  // operators in Scala are basically methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // both are equivalent
  println(basicMath == anotherBasicMath)

}
