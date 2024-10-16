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

  // Datatypes: Int, Float, Double, Char, String, Boolean

  // String datatype
  val aString = "Hello"
  // string concatenation
  val bString = "Hello" + " " + "World"

  println(bString + aString)

  // supports interpolation with the "s" suffix and $ sign
  val interpolatedString = s"The value of anInt is: $anInt"
  println(interpolatedString)

  // Expressions: these are structures that can be reduced to a value
  val anExpression = 2 + 3
  println(anExpression)

  // Everything in Scala is a value (or everything is an expression that can be reduced to a value), and we don't think of instructional-based code, instead we think of values and other elements that compose values to form values
  // Scala is a functional programming language

  // "if" expression
  val ifExp =
    if (anInt > 50) 100
    else 50
  println(ifExp)

  // chained "if-else if" expression
  val chainedIfExp =
    if (anInt > 100) 150
    else if (anInt > 50) 100
    else 0
  println(chainedIfExp)

  // code-blocks, these also are a "value" essentially, delimited by {}
  val aCodeBlock = {
    // definitions
    val temp = 56

    // VALUE OF A CODE BLOCK IS THE VALUE OF THE LAST EXPRESSION OF THE CODE BLOCK
    temp + 4
  }
  println(aCodeBlock)

}
