package com.jerryD.DoubleLinkedList

object DoubleLinkedListMain {

  def main(args: Array[String]): Unit = {

    val h1 = new HeroNode(1,"松江","及时雨")
    val h2 = new HeroNode(3,"卢俊义","玉麒麟")
    val h3 = new HeroNode(4,"武松","行者")
    val h4 = new HeroNode(2,"石阡","鼓上蚤")
    // 创建一个单向链表
    val doubleLinkedList = new DoubleLinkedList()
    doubleLinkedList.add(h1)
    doubleLinkedList.add(h2)
    doubleLinkedList.add(h3)
    doubleLinkedList.add(h4)
    doubleLinkedList.list()
    println("-------------------------------------------------------")
    val h5 = new HeroNode(1,"张三","zs")
    doubleLinkedList.updateTo(h5)
    doubleLinkedList.list()
    println("-------------------------------------------------------")
    // 删除测试
    doubleLinkedList.del(1)
    doubleLinkedList.del(2)
    doubleLinkedList.del(3)
    doubleLinkedList.list()
    println("-------------------------------------------------------")
    doubleLinkedList.add(h1)
    doubleLinkedList.add(h2)
    doubleLinkedList.list()

  }
}
