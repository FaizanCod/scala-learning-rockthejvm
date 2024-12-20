package com.learning.scala

object Basics extends App {
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


  // functions: the def keyword is used along with the parameter list (comma-separated) with param-name: param-type (for example, x: Int) and what type of value it returns
  // all params are "val"s
  def myFunc(x: Int, y: String): String = y + " " + x
  // RHS can be a single expression or a code-block
  println(myFunc(78, "People"))

  def anotherFunc(x: Int, y: Double): Double = {
    val t = x * 2

    y * t
  }
  println(anotherFunc(4, 2.1))


  // Scala doesnt use loops or iterations of any form, everything must be defined in functions or expressions, therefore RECURSION is used
  def fact(x: Int): Long = {
    if (x <= 1) 1
    else x * fact(x-1)
  }
  println("Factorial of 5 is " + fact(5))

  // Unit datatype: It has no meaningful value, similar to "void" in other languages
  // println is itself a Unit function
  def printFxn(): Unit = {
    println("This function can be used to print anything.")
  }
  printFxn()

  // internally Unit value is characterized by "()"
  val unit = ()
}
