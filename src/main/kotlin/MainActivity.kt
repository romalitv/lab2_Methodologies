package com.example.lab2

fun main() {
    val list = DoubleLinkedList<Any>()
    list.append("r")
    list.append("p")
    list.append("a")
    list.insert("O", 2)
    list.insert("d", 1)
    list.delete(1)
    println(list)

}

