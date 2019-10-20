package com.jerryD.stack
import util.control.Breaks._
/*
  计算器
 */
object CalculatorMain{

  def main(args: Array[String]): Unit = {

    val expression = "7*2*2-5+1-5+3-4"
    // 数字栈
    val numStack = new ArrayStackTo(10)
    // 符号栈
    val operStack = new ArrayStackTo(10)
    // 循环的取出expression 字符
    var index = 0
    var num1 = 0
    var num2 = 0
    var oper = 0
    var res = 0
    var ch = ' '
    var keepNum = "" // 再进行扫描时，保存上次的数字ch, 并进行凭借
    breakable{
      while (true){

        // 开始扫描 expression
        ch = expression.substring(index,index+1)(0)
        if(operStack.isOper(ch)){
          // 如果是操作符
          if(!operStack.isEmpty()){
            if(operStack.piority(ch) <= operStack.piority(operStack.stack(operStack.top))){
              //开始及计算
              num1 = numStack.pop().toString.toInt
              num2 = numStack.pop().toString.toInt
              oper = operStack.pop().toString.toInt
              res = numStack.cal(num1,num2,oper)
              // 入数栈
              numStack.push(res)
              // 把当前ch入符号栈
              operStack.push(ch)
            }else{
              // 如果当前的符号的优先级大于符号栈顶的 直接入符号栈
              operStack.push(ch)
            }
          }else{
            // 符号直接入栈
            operStack.push(ch)
          }
        }else{
          // 是一个数
          // 处理多位数的逻辑
          keepNum += ch

          // 如果ch 已经是expression的最后一个字符
          if (index == expression.length - 1){
            numStack.push(keepNum.toInt)
          }else{
            // 判断ch 的下一个字符是不是数字,如果是数字,则进行一次扫描,如果是操作符,就直接入栈
            // 看到expresson的下一个字符时,不要真正的移动index,只是探测一下
            if (operStack.isOper(expression.substring(index+1,index+2)(0))){
              numStack.push(keepNum.toInt)
              keepNum = "" // 清空
            }
          }
          //numStack.push((ch + "").toInt)
        }
        index += 1
        // 判断是否到表达式的最后
        if(index >= expression.length){
          break()
        }
      }
    }

    breakable{
      while (true){
        if(operStack.isEmpty()){
          break()
        }else{
          //开始及计算
          num1 = numStack.pop().toString.toInt
          num2 = numStack.pop().toString.toInt
          oper = operStack.pop().toString.toInt
          res = numStack.cal(num1,num2,oper)
          numStack.push(res)
        }
      }
    }

    // 将数字栈的最后结果pop
    val res2 = numStack.pop()
    printf("表达式%s = %d",expression,res2)
  }

}

class ArrayStackTo(size:Int) {

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

  // 返回运算符的优先级 自己定义
  // + - => 0  * / => 1 数字越大优先级越高
  def piority(oper: Int): Int = {
    if(oper == '*' || oper == '/'){
      1
    }else if(oper == '+' || oper == '-'){
       0
    }else{
       -1 //错误字符
    }
  }

  // 计算方法
  def cal(num1:Int,num2:Int,oper:Int):Int = {
    var res = 0
    oper match {
      case '+' => res = num1 + num2
      case '-' => res = num2 - num1
      case '*' => res = num1 * num2
      case '/' => res = num2 / num1
    }
    res
  }

  // 是否是操作符
  def isOper(value: Int):Boolean = {
    value == '+' || value == '-' || value == '*' || value == '/'
  }
}