package net.hoyoung.scala.tutorial

class AbstractClass {

}
// 抽象类
abstract class People {
  def speak
  val name:String
  val age:Int
}
class Worker extends People {
  // 也可以不写override，override用于已经实现了的方法的重写
  override def speak {
    println("this is abstract")
  }
  val name = "hoyoung"
  val age = 25
}

object AbstractClass extends App {
  val w1 = new Worker
  w1.speak
}