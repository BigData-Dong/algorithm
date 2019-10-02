package com.jerryD.ArrayQueue


// 使用数组模拟队列
class ArrayQueue(araMaxSize:Int){

  val maxSize = araMaxSize
  val arr = new Array[Int](maxSize) // 该数组存放数据，模拟队列

  var front = -1 // 指向队列头部 , 分析出Front 是指向队列数据的前一个位置(不包含数据)
  var rear = -1 // 指向队列的尾部, 分析出rear 是指向队列最后数据(含数据)

  // 判断队列是否满
  def isFull():Boolean = {
    rear == maxSize - 1
  }

  // 判断队列是否为空
  def isEmpty():Boolean = {
    front == rear
  }

  // 添加队列
  def addQueue(n:Int):Unit = {
    // 判断是否满
    if (isFull()){
      println("队列满,无法加入")
      return
    }
    rear += 1 // 先让rear 后移一位
    arr(rear) = n
  }

  // 取数据
  def getQueue():Any = {
    if(isEmpty()){
      return new Exception("队列空")
    }
    front += 1
    return arr(front)
  }


  // 显示队列的所有数据
  def showQueue():Unit = {
    if(isEmpty()){
      println("队列空的,没有数据")
      return
    }
    for(i <- front + 1  to rear){
      printf("arr[%d]=%d\n",i,arr(i))
    }
  }



}