package lectures.part2oop

/**
  * Created by Daniel.
  */
object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance   -- SINGLETON INSTANCE
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method  whole purpose define objects given
    def apply(mother: Person, father: Person): Person = new Person("Bobbie") // very convenient Person(mary, john)  !!!

    def from(mother: Person, father: Person): Person = new Person("Bobbie")

  }
  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS --- It is a pattern for practical level we write the class with the same name, all the code will be acceses by a singleton or normal instance --- More OO than Java !!

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)   // they point to the same instance that is the object called Person, they are singleton instances BY DEFINITION

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    val bobbie = Person(mary, john)


  // Scala Applications = Scala object with a very important method called ...
  // def main(args: Array[String]): Unit

  // Unit bc it is turn into jvm app whitch entry point is p s v m (string[])


  val k = 6.67e-11

}
