package com.jerryD.LinkedList


/*
    包含head的单链表
 */
object SingleLinkedListMain {

  def main(args: Array[String]): Unit = {

    val h1 = new HeroNode(1,"松江","及时雨")
    val h2 = new HeroNode(3,"卢俊义","玉麒麟")
    val h3 = new HeroNode(4,"武松","行者")
    val h4 = new HeroNode(2,"石阡","鼓上蚤")
    // 创建一个单向链表
    val singleLinkedList = new SingleLinkedList()
//    singleLinkedList.add(h1)
//    singleLinkedList.add(h2)
//    singleLinkedList.add(h3)
//    singleLinkedList.add(h4)
//
//    singleLinkedList.list()

    println("-------------------------------------------")
    singleLinkedList.addTo(h1)
    singleLinkedList.addTo(h2)
    singleLinkedList.addTo(h3)
    singleLinkedList.addTo(h4)

    singleLinkedList.list()
    val h5 = new HeroNode(1,"张三","zs")
    println("------------------------------------------------")
    singleLinkedList.updateTo(h5)
    singleLinkedList.list()
    println("--------------------------------------------")
    singleLinkedList.del(2)
    singleLinkedList.list()
  }

}
