package com.jerryD.josephu
import util.control.Breaks._

class BoyGame {

    // 初始化一个头结点,这个first内容会改
    var first:Boy = new Boy(-1)

    // 添加小孩【形成一个单向环形的链表】
    // nums: 表示共有几个小孩
    def addBoy(nums:Int):Unit = {
      if(nums < 1){
        println(s"nums的值不正确: $nums")
        return
      }

      // 在形成环形链表时，需要一个辅助指针
      var curBoy: Boy = null

      for (no <- 1 to nums){
        // 根据编号创建小孩对象
        val boy = new Boy(no)
        // 如果是第一个小孩
        if (no == 1){
          first = boy
          first.next = boy // 形成环形的链表
          curBoy = first
        }else{
          curBoy.next = boy
          boy.next = first
          curBoy = boy
        }
      }
    }

    // 遍历单向的环形链表
    def showBoy():Unit = {
      if(first.next == null){
        println("没有任何小孩~")
        return
      }
      // 因为first不能动，还是借助一个辅助指针完成遍历
      var curBoy = first
      breakable{
        while (true) {
          printf("小孩编号 %d \n",curBoy.no)
          if(curBoy.next == first){
            break()
          }
          curBoy = curBoy.next // curBoy后移
        }
      }
    }

    // 编写方法countBoy,完成游戏
    // startNo: 从第几个认开始数
    // countNum  数几下
    // nums 一共有多少人
    def countBoy(startNo:Int,countNum:Int,nums:Int):Unit = {

      if(first.next == null || startNo < 1 || startNo > nums){
        println("参数有误,重新输入")
        return
      }
      // 完成游戏的思路
      //1.在first前面设计一个辅助指针(helper),即将helper指针定位到first前面
      var helper = first
      // 即将helper 指针定位到first前面
      breakable{
        while (true){
          if(helper.next == first){
            break()
          }
          helper = helper.next
        }
      }
      //2.将first指针移动到startNo 这个小孩
      for (i <- 1 until startNo){
        first = first.next
        helper = helper.next
      }
      // 开始数数,按照给定的值,没数到一个小孩就出圈,直到环形链表只有一个节点就结束
      breakable{
        while (true){
          if(helper == first){
            // 只有一个人
            break()
          }
          //3. 开始数countNum 个数[first 和 helper 会对应的移动]
          for (i <- 1 until countNum){
            first = first.next
            helper = helper.next
          }
          // 输出出圈的人的信息
          printf("小孩[%d]出圈\t",first.no)
          // 将first 指向的节点删除
          first = first.next
          helper.next = first
        }
      }
      //4. 删除first指向的这个小孩节点
      // 当while结束后,只有一个人
      printf("\n最后留在圈的人是 小孩编号为 %d",first.no)
    }

}
