package net.hoyoung.scala.tutorial

class T6ScalaControl {

}
object T6ScalaControl {
  def main(args: Array[String]): Unit = {

    /**
     * Scala取消了break和continue
     */
    var found = false
    var i = 1
    while (i < 5 && !found) {
      if (i % 2 == 0) {
        found = true
      }
      println(i)
      i += 1
    }
    
    val str = "hello"
    str match {
      case "hello" => println("match hello")
      case "word" => println("match word")
    }
    // 可以返回值
    val matchResult = str match{
      case "hello" => "match hello"
      case "word" => "match word"
    }
    println(matchResult)
  }
}