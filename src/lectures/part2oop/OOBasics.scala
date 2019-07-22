package lectures.part2oop

/**
  * Created by Daniel.
  */
object OOBasics extends App {

  // constructor
  // class parameters are not fields, the way to convert into that is to add a val (or var) so we can say person.age
  class Person(name: String, val age: Int = 0) {
    // body, you can do inside everything you would do in a class, every single expression will be evaluated in every instantiation
    val x = 2


    println(1 + 3)

    // method
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")  //using this we refer to the parameter, it is not a field but available as a parameter within the class definition

    // overloading  -- methods with the same name but different signatures, the compiler will know who to call and won't complain
    def greet(): Unit = println(s"Hi, I am $name")  // "name" is implied as this.name, the conversion is automatic

    // multiple constructors (overloading constructors)
    def this(name: String) = this(name, 0) //calls default constructor
    def this() = this("John Doe")  // forces to call another constructor only use in practice for default parameters, so most practical to just define val age: Int = 0
  }

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()


  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))  // equality is a very interesting problem in OO!!!

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print


  val counterLazy = new CounterLazy
  counterLazy.inc.print
  counterLazy.inc.inc.inc.print
  counterLazy.inc(10)
}



/*
  Novel and a Writer

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel


 */

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */
class Counter(val count:  Int = 0) {

//  def count = n unnecessary, val creates getter

  def inc = {
    println("incrementing")
    new Counter(count + 1)  // immutability  -- same principle of declaring vals to primitive... here means instances cannot be modify
  }

  def dec = {
    println("decrementing")  //side effect
    new Counter(count - 1) // immutability
  }

  //new Counter(n+count) but if it is a source of logging we want to increment N times, looping with recursion
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1) //it is tail recursive because we call the function the last time ... stack safe
  }

  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n-1)

  def print = println(count)
}

// class parameters are NOT FIELDS


class CounterLazy( count: =>  Int = 0) {

  //  def count = n unnecessary, val creates getter

  def inc: CounterLazy = {
    println("incrementing")
    new CounterLazy(count + 1)  // immutability  -- same principle of declaring vals to primitive... here means instances cannot be modify
  }

  def dec: CounterLazy = {
    println("decrementing")  //side effect
    new CounterLazy(count - 1) // immutability
  }

  //new Counter(n+count) but if it is a source of logging we want to increment N times, looping with recursion
  def inc(n: Int): CounterLazy = {
    if (n <= 0) this
    else inc.inc(n-1) //it is tail recursive because we call the function the last time ... stack safe
  }

  def dec(n: Int): CounterLazy =
    if (n <= 0) this
    else dec.dec(n-1)

  def print = println("laaaazy  "+
    count)
}