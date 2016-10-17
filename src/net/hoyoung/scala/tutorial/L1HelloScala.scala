package net.hoyoung.scala.tutorial
/**
 * scala包和Java的java.lang包被自动引入
 * 基本类型：
 * Byte
 * Char
 * Short
 * Int
 * Long
 * Float
 * Double
 * String
 * Boolean
 */
class HelloScala {

}
object HelloScala {
  def hello(name: String) {
    println(name)
  }
  def helloScala() {
    println("Hello scala,this is hoyoung")
  }
  def add = (x: Int, y: Int) => x + y
  // 函数是一等公民，可以把函数赋值给一个常量
  val sum = (x: Int, y: Int) => x + y
  // 函数柯里化
  def sum2(x: Int)(y: Int) = x + y
  // 可变参数
  def variableParameter(s: String*) {
    s.foreach { x => println(x) }
  }
  // 默认参数
  def defaultParameter(s: String = "hello") {
    println(s)
  }
  def main(args: Array[String]) {
    helloScala()
    // 如果函数不带参数，调用时可以不带括号
    helloScala
    hello("this is with the arg")
    // 定义匿名函数
    println(add(1, 2))
    println(sum(1, 2))
    println(sum2(1)(2))
    variableParameter("a", "b", "c")
    defaultParameter()//尽管参数有默认值，但依旧要带上括号调用
    defaultParameter("word")
  }
}