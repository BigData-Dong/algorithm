package com.jerryD.stack

class ArrayStack(size:Int) {

    val maxSize = size // 栈的大小
    var stack = new Array[Int](maxSize)

    // 栈顶,初始化为-1
    var top = -1

    // 栈满
    def isFull(): Boolean = {
      top == maxSize - 1
    }
   // 栈空
    def isEmpty():Boolean = {
      top == -1
    }

    // 入栈
    def push(value:Int):Unit = {
      if(isFull()){
        println("栈满")
        return
      }
      top += 1
      stack(top) = value
    }

    // 出栈
    def pop():Any = {
      if(isEmpty()){
        return new Exception("栈空")
      }
      val value = stack(top)
      top -= 1
      return value
    }

    // 遍历栈
    def list():Unit = {
      if(isEmpty()){
        println("栈空,没有数据")
        return
      }
      for (i <- 0 to top reverse){
        printf("stack[%d]=%d\n",i,stack(i))
      }
    }
}
