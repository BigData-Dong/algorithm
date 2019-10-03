package com.jerryD.LinkedList
import util.control.Breaks._

/*
    单项链表
 */
// 定义单项链表管理Hero
class SingleLinkedList {

    // 先初始化一个头结点,头结点一般不会动
    val head = new HeroNode(0,"","")

    // 编写添加方法
    def add(heroNode: HeroNode):Unit = {
       // 因为头结点不能动,因此我们需要有一个临时结点,作为辅助
      var temp = head
      // 找到链表的最后
      breakable {
        while (true){
          if(temp.next == null){
            break()
          }
          // 如果没有到最后
          temp = temp.next
        }
      }
      // 当退出while循环后,temp就是链表的最后
      temp.next = heroNode
    }

    // 遍历单向链表
    def list(): Unit = {

      // 判断当前链表是否为空
      if (head.next == null){
        println("当前链表为空!!！")
        return
      }

      // 因为头结点不能动,因此我们需要有一个临时结点,作为辅助
      // 因为head 结点数据, 我们不关心, 因此这里 temp = head.next
      var temp = head.next
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

    // 第二种方式在添加英雄时,根据排名将英雄插入到制定位置(如果有这个英雄添加失败)
    // 如果有这个排名,则添加失败,并给出提示
    // 编号从小到大排序
    // 思路:
    def addTo(heroNode: HeroNode): Unit = {
      // 注: 我们在找这个添加位置时, 是将这个节点加入到temp的后面
      // 因为,在比较时,是将当前的heroNode 和 temp.next进行比较
      var temp = head
      var flag = false // flag 用于判断该位置的编号已经存在,默认为false
      breakable{
        while (true) {
          // 说明 temp 已经在最后的位置
          if(temp.next == null){
            break()
          }
          if(temp.next.no > heroNode.no){
             // 位置找到,当前这个节点,应该加入到temp后
            break()
          }else if(temp.next.no == heroNode.no){
            // 已经有这个节点
            flag = true
            break()
          }
          temp = temp.next
        }
      }

      if (flag){
        //不可以加
        printf("待插入的英雄编号 %d 已经存在不能加入 \n", heroNode.no)
      }else{
        // 注： 加入,注意顺序问题
        heroNode.next = temp.next
        temp.next = heroNode
      }
    }

    // 修改节点的值, 根据 no 编号为前提修改,即编号不能改
    def update(newHeroNode: HeroNode) : Unit = {
      if (head.next == null){
        println("链表为空")
        return
      }

      // 先找到节点
      var temp = head.next
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
        temp.name = newHeroNode.name
        temp.nickname = newHeroNode.nickname
      }else{
        printf("没有找到 编号为%d 节点,不能修改",newHeroNode.no)
      }
    }


  def updateTo(newHeroNode: HeroNode) : Unit = {
    if (head.next == null){
      println("链表为空")
      return
    }

    // 先找到节点
    var temp = head
    var flag = false

    breakable{
      while (true){
        if (temp.next == null){
          break()
        }
        if (temp.next.no == newHeroNode.no){
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    // 判断是否找到
    if (flag){
          newHeroNode.next = temp.next.next
          temp.next = newHeroNode
    }else{
      printf("没有找到 编号为%d 节点,不能修改",newHeroNode.no)
    }
  }

  // 删除节点
  /* 思路
      1. head 不能动
      2. 使用temp变量,我们要删除的应该是temp.next节点,即,我们在比较时,
        始终比较的是temp.next的节点中的值
      3. 一定要测边界值
   */
    def del(no: Int):Unit = {
      var temp = head
      var falg = false
      breakable{
        while (true){
          if(temp.next == null){
            break()
          }
          if(temp.next.no == no){
            falg = true
            break()
          }
          temp = temp.next
        }
      }
      if(falg){
        // 可以删除
        temp.next = temp.next.next
      }else{
        printf("要删除的no=%d 不存在 \n",no)
      }
  }

}
