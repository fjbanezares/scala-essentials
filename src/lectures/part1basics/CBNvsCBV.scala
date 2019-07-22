package lectures.part1basics

/**
  * Created by Daniel on 07-May-18.
  */
object CBNvsCBV extends App {


   def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }


 /* def calledByValue(x: Long): Unit = {
    println("by value: " + 1257387745764245L)
    println("by value: " + 1257387745764245L)
  }*/


  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByName(System.nanoTime())
  calledByValue(System.nanoTime())

/*  def calledByName(x: => Long): Unit = {
    println("by name: " + System.nanoTime())
    println("by name: " + System.nanoTime())
  }*/

 // calledByValue(1257387745764245L)
 // calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

//  printFirst(infinite(), 34)  //Obvious StackOverflow error
  printFirst(34, infinite())  // No crashing as By Name delays the evaluation, surviving
}
