package com.jerryD.SparseArray

import java.io.{BufferedReader, BufferedWriter, File, FileReader, FileWriter, PrintWriter}

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/*
    稀疏数组
 */
object SparseArr {

  def main(args: Array[String]): Unit = {

    val filePath = "D:\\code\\github\\algorithm\\src\\main\\scala\\com\\jerryD\\SparseArray\\sparseArry.txt"
    val rowSize = 11
    val colSize = 11
    // 演示一个稀疏数组的使用
    val chessMap = Array.ofDim[Int](rowSize, colSize)
    // 初始化地图
    chessMap(1)(2) = 1 // 1 表示黑子
    chessMap(2)(3) = 2 //  2 表示白子

    // 输出原始的地图
    for (item <- chessMap) {
      for (item2 <- item) {
        printf("%d\t", item2)
      }
      println()
    }

    // 将chessmap转成稀疏数组
    // 思路：=>  效果是达到对数据的压缩
    //    class Node (row,col,value)
    //    save ArrayBuffer
    val sparseArr = ArrayBuffer[Node]()
    // 记录棋盘大小
    val node = new Node(rowSize, colSize, 0)
    sparseArr.append(node)
    for (i <- 0 until chessMap.length; j <- 0 until chessMap(i).length) {
      // 判断该值是否为0， if is 0 not save else save
      if (chessMap(i)(j) != 0) {
        val node = new Node(i, j, chessMap(i)(j))
        sparseArr.append(node)
      }
    }

    println("---------------稀疏数组---------------")
    // 输出稀疏数组
    for (node <- sparseArr) {
      printf("%d\t%d\t%d\n", node.row, node.col, node.value)
    }

    // 存盘
    val writer = new BufferedWriter(new FileWriter(filePath))
    for (node <- sparseArr) {
      writer.write(node.row + "\t" + node.col + "\t" + node.value)
      writer.newLine()
      writer.flush()
    }
    writer.close()

    // 读盘
    val source = Source.fromFile(filePath, "UTF-8")
    val it = source.getLines()
    val date = ArrayBuffer[Node]()
    it.foreach(line => {
      val strArr = line.split("\t")
      if(strArr.length == 3) date.append(new Node(strArr(0).toInt, strArr(1).toInt, strArr(2).toInt))
    })

    source.close()
    // 稀疏数组 -> 原始数组
    // 读取稀疏数组的第一个节点
    val newNode = date(0)
    val newRowSize = newNode.row
    val newColSize = node.col
    val newChessMap = Array.ofDim[Int](rowSize, colSize)

    for (i <- 1 until date.length) {
      val node = date(i)
      newChessMap(node.row)(node.col) = node.value
    }

    println("----------从稀疏数组恢复后-----------")
    for (item <- newChessMap) {
      for (item2 <- item) {
        printf("%d\t", item2)
      }
      println()
    }
  }
}
