package net.hoyoung.scala.tutorial

class OOPInScala {

}
class Person {
  var name: String = _
  val age = 25
  // private[类名]允许指定类访问
  private[this] val gender = "male"
}
class Person2(val name: String, val age: Int) {
  // 1.主构造器直接跟在类名后面，主构造器中的参数被编译成类的字段
  // 2.主构造器在执行的时候会执行所有不包含在方法体中的语句
  // 3.如果主构造器函数中的参数没有声明为val或者var，则默认是private[this]级别的
  println("这是Person2主构造器")

  var gender: String = _
  // 定义附属构造器
  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }
  val university = "xidian"
}
class Student(name: String, age: Int, gender: String) extends Person2(name, age) {

  // override必须要有
  override def toString = "this is student class " + this.name
  // 重写字段
  override val university = "tsinghua"
}
object OOPInScala {
  def main(args: Array[String]): Unit = {
    val p1 = new Person
    p1.name = "hoyoung"
    println(p1.name + ":" + p1.age)
    // 主构造器
    val p2 = new Person2("hoyoung", 25)
    println(p2.name)
    // 继承
    val s1 = new Student("hoyoung", 25, "male")
    // 重写函数
    println(s1.toString())
    // 重写字段
    println(s1.university)
  }
}