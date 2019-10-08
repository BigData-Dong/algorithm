package com.jerryD.stack

import scala.io.StdIn

object ArrayStackMain {

  def main(args: Array[String]): Unit = {
      val arrayStack = new ArrayStack(5)
      var key = ""
      while (true){
        println("show:显示栈")
        println("exit: 退出栈")
        println("push: 添加")
        println("pop: 取出栈数据")

        key = StdIn.readLine()
        key match {
          case "show" => arrayStack.list()
          case  "exit" => System.exit(0)
          case  "push" => {
            println("请输入一个数:")
            val value = StdIn.readInt()
            arrayStack.push(value)
          }
          case  "pop" => {
            val res = arrayStack.pop()
            if (res.isInstanceOf[Exception]){
              println(res.asInstanceOf[Exception].getMessage)
            }else{
              printf("取出的数为 %d \n",res)
            }
          }
        }
      }

  }
}
