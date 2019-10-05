package com.jerryD.DoubleLinkedList
import util.control.Breaks._

class DoubleLinkedList {

  // 先初始化一个头结点,头结点一般不会动
  val head = new HeroNode(0,"","")

  // 添加-遍历-修改-删除
  def add(heroNode: HeroNode):Unit = {

    var temp = head
    breakable{
      while (true){
        if(temp.next == null){
          break()
        }
        // 如果没有找到
        temp = temp.next
      }
    }
    // 当退出while循环后,temp就是链表的最后
    temp.next = heroNode
    heroNode.pre = temp
    heroNode.next = null
  }

  // 遍历
  def list(): Unit = {
    // 因为头结点不能动,因此我们需要有一个临时结点,作为辅助
    // 因为head 结点数据, 我们不关心, 因此这里 temp = head.next
    var temp = head.next

    // 判断当前链表是否为空
    if (temp == null){
      println("当前链表为空!!！")
      return
    }

    breakable{
      while (true) {
        printf("结点信息 : no=%d name=%s nickname=%s \n",temp.no,temp.name,temp.nickname)
        // 判断是否到最后
        if(temp.next == null){
          break()
        }
        temp = temp.next

      }
    }
  }

  // 修改
  def updateTo(newHeroNode: HeroNode) : Unit = {
    // 先找到节点
    var temp = head.next
    if (temp == null){
      println("链表为空")
      return
    }

    var flag = false

    breakable{
      while (true){
        if (temp == null){
          break()
        }
        if (temp.no == newHeroNode.no){
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    // 判断是否找到
    if (flag){
      temp.pre.next = newHeroNode
      newHeroNode.pre = temp.pre
      newHeroNode.next = temp.next
      if(temp.next.pre != null){
        temp.next.pre = newHeroNode
      }
    }else{
      printf("没有找到 编号为%d 节点,不能修改",newHeroNode.no)
    }
  }

  // 删除
  // 思路,因为双向链表可以自我删除
  def del(no: Int):Unit = {
      var temp = head.next
      var flag = false
      // 判断当前链表是否为空
      if(temp == null){
        println("链表空")
        return
      }

      breakable{
        while (true){
          if(temp == null){
            break()
          }
          if(temp.no == no){
            flag = true
            break()
          }
          temp = temp.next
        }
      }

      if (flag) {
        // 可以删除
        temp.pre.next = temp.next
        if(temp.next != null){
          temp.next.pre = temp.pre
        }
      }else{
        printf("要删除的no=%d 不存在",no)
      }
  }


}
