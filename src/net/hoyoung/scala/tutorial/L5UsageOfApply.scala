package net.hoyoung.scala.tutorial

class UsageOfApply {

}
class ApplyTest {
  def apply() = "this apply is in class"

  def test {
    println("this is test")
  }
}
// object中的方法和属性都是静态的
object ApplyTest {
  def apply() = new ApplyTest
  def static {
    println("this is a static method")
  }
}
object UsageOfApply extends App {
  // 这个会导致object ApplyTest中的apply()方法被调用并返回一个实例
  val a = ApplyTest()
  a.test

  // 这个会导致class ApplyTest中的apply方法被调用并返回
  val b = new ApplyTest
  println(b())
}