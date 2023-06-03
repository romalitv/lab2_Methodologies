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

    fun delete(index: Int): T {
        val value : T

        if (index == 0){
            value = array.removeAt(0).value
            return value
        }

        if( index == array.size - 1){
            value = array.removeLast().value
            array.last().next = null
            return value
        }

        value = array.removeAt(index).value
        array.elementAt(index - 1).next = array.elementAt(index)
        return value
    }

    fun deleteAll(value: T) {
        if (array.isEmpty()) return
        var i = 0
        while ( i < array.size ){
            if (array[i].value == value) {
                delete(i)
                i--
            }
            i++
        }
    }

    fun get(index: Int): T {
        return array[index].value
    }

    fun findFirst(value: T): Int {
        return array.indexOfFirst { it.value == value }
    }

    fun findLast(value: T): Int {
        return array.indexOfLast { it.value == value }
    }

    fun clone(): LinkedList<T> {
        val clone = LinkedList<T>()
        clone.array.addAll(this.array)
        return clone
    }

    fun reverse(){
        array.reverse()
    }

    fun clear(){
        array.clear()
    }

    fun extend(list: LinkedList<T>){
        for ( node in list.array){
            this.append(node.value)
        }
    }
}