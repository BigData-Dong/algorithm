package com.jerryD.DoubleLinkedList

class HeroNode(hNo:Int, hName:String, hNickName:String) {

    val no: Int = hNo
    var name: String = hName
    var nickname: String = hNickName
    var pre: HeroNode = null     // pre 默认为null
    var next : HeroNode = null  //  next 默认为null
}
