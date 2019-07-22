package lectures.part2oop

/**
  * Created by Daniel.
  */
object Inheritance extends App {

  // single class inheritance
  sealed class Animal {
    protected val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
      println("pepeeeeeeeeee   " + cat.creatureType)

    }
  }

  val cat = new Cat
  cat.crunch
  cat.eat


  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)  // This is valid because the compiler found a constructor with just the name as a parameter, if not Person(name,age)

  // overriding
  class Dog(override val creatureType: String) extends Animal {  // we can override fields in the construcor
//    override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  class Lion(tipo: String) extends Animal {  // we can override fields in the construcor
    override val creatureType = tipo  //hace lo mismo que antes overrride fields from superclasses directly in the constructor
    override def eat = {
      super.eat  // CALL A METHOD IN PARENT
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

// main idea of overriding is use the overriden

  //what is interesting is type substitution

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat  //after removing the protected modifier
  // it uses Dog instead of Animal, compiler uses the most overriden version, power of polimorphism, Collection[Animal], it will know for each who to call

  // overRIDING vs overLOADING  (diff implementation, multile methods with different signatures same name in same class

  // super   WHEN WE WANT TO CALL A METHOD IN THE PARENT CLASS (Only one parent)

  // preventing overrides (if you want)
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files
}
