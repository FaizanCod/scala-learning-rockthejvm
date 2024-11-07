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

  // Anonymous classes
  // for any Trait, they can't be instantiated by themselves (just like abstract classes in other languages) they must be used by a concrete class
  // but by use of anonymous classes we can provide concrete implementations of Traits too, like this
  val dinosaur = new Carnivore {
    override val haveIncisors: Boolean = true
    override def eat(animal: Animal): Unit = println("I can eat everything!")
  }
  dinosaur.eat(anAnimal);
  // typically what happens in the compiler is that the RHS is treated as a separate class like "Carnivore_anonymous_532-1" and dinosaur is an object of that class with the methods defined

  // singleton objects
  object MySingleton { // it is the only instance of MySingleton type
    val myVal = 54;
    def myMethod(): Unit = println(s"My value is $myVal")
    // special method, can be in any class, any object
    def apply(x: String): Unit = println(s"Apply method called with argument $x")
  }

  MySingleton.myMethod();
  // calling apply method, two ways
  MySingleton.apply("Hello there!")
  // this method call is also bound to the apply method, allows the instances to be called like functions
  // useful in functional programming
  MySingleton("How are you?")

  // if there is already a class/Trait by the name Animal, and we create a singleton by the same name
  // then these class-object/Trait-object pair is called companions, and this singleton object is called a companion object
  object Animal {
    // companions can access each other's private fields/methods
    // however the singleton Animal and instances of class Animal are different things
   val canLiveForever = false
  }
  // NOTE: normally never use the singleton Animal as an instance while other Animal instances are present in the code
  // normally use companion objects to access fields that DO NOT depend on the Animal instances
  // similar to "static" field in other languages
  val animalsCanLiveForever = Animal.canLiveForever

  // case classes - lightweight data structures with boilerplate
  // compiler auto-generates sensible equals and hashcode for the case class for inclusion into various collections that use equality and hashcode
  // also serialization to send data over the wire in distributed applications
  // also a companion object with apply (can instantiate classes without new keyword)
  // also helps in pattern matching
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 54) // can omit the new keyword because companion object with apply is present for a case class

  // exceptions - special objects treated by the JVM that disrupts the normal flow of the program
  // Scala is based on the JVM and gets compiled to a JVM bytecode
   try {
     // code that throws exception
     val x: String = null
     // accessing null string object's length
     println(x.length)
   } catch {
     case e: Exception => println(s"Exception caught! $e")
   } finally {
     // executed no matter what, closing connections and releasing resources
   }
}
