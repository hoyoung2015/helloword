package net.hoyoung.scala.tutorial

class ScalaExpression {

}
object ScalaExpression {
  def main(args: Array[String]): Unit = {
    val max = 1
    val result = if (max > 0) 1 else 0
    println(result)
    println
    var (n, r) = (10, 0) //这点类似于php
    while (n > 0) {
      // 10+9+8+7+...+1
      r = r + n
      n = n - 1
    }
    println(r)
    println
    for (i <- 1 to 3) {
      println(i)
    }
    println
    for (i <- 1 until 3) {
      // 不会输出最后的3
      println(i)
    }
    println
    for (i <- 1 to 3 if i % 2 == 0) {
      println(i)
    }
  }
}