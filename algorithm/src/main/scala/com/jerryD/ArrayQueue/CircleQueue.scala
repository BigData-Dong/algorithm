package com.jerryD.ArrayQueue


class CircleQueue(arrMaxSize:Int) {

  val maxSize = arrMaxSize
  val arr = new Array[Int](maxSize) // 该数组存放数据，模拟队列

  var front = 0 // 指向队列头部 ,
  var rear = 0 // 指向队列的尾部,

  // 判断队列满
  def isFull():Boolean = {
    (rear + 1) % maxSize == front
  }

  // 判断队列空的条件
  // 队列容量空出一个坐位约定
  def isEmpty():Boolean = {
    rear == front
  }

  // 添加队列
  def addQueue(n:Int):Unit = {
    // 判断是否满
    if (isFull()){
      println("队列满,无法加入")
      return
    }
    // 将数据加入
    arr(rear) = n
    // 然后将rear 后移 , 这里必须考虑取模
    rear = (rear + 1) % maxSize
  }

  // 取数据(按先进先出的原则)
  def getQueue():Any = {
    if(isEmpty()){
      return new Exception("队列空")
    }
    // 这里我们需要分析处理  front 已经指向了第一个队列的头元素
    // 1. 先把front  对应的数据保存到变量
    // 2. 将front后移
    // 3. 返回前面保存的变量值
    val value = arr(front)
    front = (front + 1) % maxSize
    return value
  }

  // 显示队列
  def showQueue():Unit = {
    if(isEmpty()){
      println("队列为空，没有数据...")
      return
    }
    // 思路: 从front 取, 取出几个元素
    for (i <- front until front + size){
      printf("arr[%d]=%d\n",i % maxSize,arr(i % maxSize))
    }
  }

  // 查看队列的头元素，但是不是改变队列
  def headQueue(): Any = {
    if (isEmpty()){
      return new Exception("队列为空")
    }
    // 不要改变front的值
    return arr(front)
  }

  // 求出当前环形队列有几个元素
  def size():Int = {
    (rear + maxSize - front) % maxSize
  }

}
