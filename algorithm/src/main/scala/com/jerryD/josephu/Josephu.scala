package com.jerryD.josephu

object Josephu {

  def main(args: Array[String]): Unit = {

    val boyGame = new BoyGame()
    boyGame.addBoy(7)
    boyGame.showBoy()
    boyGame.countBoy(4,3,7)
  }

}
