package com.example.lab2

class LinkedList<T>(value: T? = null) {
    val array: MutableList<Node<T>> = mutableListOf()

    fun length(): Int {
        return array.size
    }

    fun append(value: T) {
        val newNode = Node(value = value)
        if (array.isNotEmpty()) {
            array.last().next = newNode
        }
        array.add(newNode)
    }


}