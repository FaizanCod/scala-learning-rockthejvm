package com.learning.scala

object Test extends App {
  // This can also be executed independently (standalone) because it is an object and extends 'App'
  println("Hello world")

  // Values in scala are like 'const', ie, cannot be reassigned
  val anInt: Int = 42

  // not necessary to mention the type of the value, Scala compiler is smart enough to find out what datatype the RHS is
  // ie, compiler automatically assigns the type
  val aBool = false

  println(anInt)
}
