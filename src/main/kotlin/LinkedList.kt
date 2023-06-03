package com.example.lab2

class LinkedList<T>(value: T? = null) {
    val array: MutableList<SingleNode<T>> = mutableListOf()

    fun length(): Int {
        return array.size
    }

    fun append(value: T) {
        val newNode = SingleNode(value = value)
        if (array.isNotEmpty()) {
            array.last().next = newNode
        }
        array.add(newNode)
    }

    fun appendList(list: List<T>){
        for (node in list){
            this.append(node)
        }
    }

    fun insert(value: T, index: Int){
        val newNode = SingleNode(value = value)

        if (index != 0){
            array.elementAt(index - 1).next = newNode
        }

        newNode.next = array.elementAtOrNull(index)
        array.add(index, newNode)
    }

}