package com.jerryD.ArrayQueue

import scala.io.StdIn

/*
    队列
 */
object ArrayQueueMain {

  def main(args: Array[String]): Unit = {
    var key = ""
    //初始化一个队列
    val queue = new ArrayQueue(3)
    while (true){
      println("add : 表示添加数据")
      println("get : 表示取出数据")
      println("show : 表示显示队列")
      println("exit : 表示退出程序")


      key = StdIn.readLine()
      key match {
        case  "add"  => {
          println("请输入一个数:")
          val value = StdIn.readInt()
          queue.addQueue(value)
        }
        case  "get"  => {
          val res = queue.getQueue()
          if (res.isInstanceOf[Exception]){
            println(res.asInstanceOf[Exception].getMessage)
          }else{
            println(s"取出数据是$res" )
          }
        }
        case  "show" => queue.showQueue()
        case  "exit" => System.exit(0)
      }
    }
  }
}
