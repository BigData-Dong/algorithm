package com.jerryD.LinkedList


class HeroNode(hNo:Int,hName:String,hNickName:String) {

    val no: Int = hNo
    var name: String = hName
    var nickname: String = hNickName
    var next : HeroNode = null  // 默认为null
}
