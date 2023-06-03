package com.example.lab2

class DoubleLinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0

    fun length(): Int {
        return size
    }

    fun append(value: T) {
        val newNode = Node(value)

        if (tail == null) {
            if (size != 0) {
                throw IllegalArgumentException("Length dont equal 0 when tail is null")
            }

            head = newNode
            tail = newNode
            size++
            return
        }

        tail!!.next = newNode
        newNode.previous = tail
        tail = newNode
        size++
    }

    fun appendList(list: List<T>) {
        for (node in list) {
            this.append(node)
        }
    }

    fun insert(value: T, index: Int) {
        if (index < 0) {
            throw IllegalArgumentException("Insert method have negative index")
        }
        if (index > size) {
            throw IllegalArgumentException("Insert method received index that more than size of list")
        }

        val newNode = Node(value)
        if (index == size) {
            append(value)
            return
        }
        if (index == 0) {
            head!!.previous = newNode
            newNode.next = head
            head = newNode
            size++
            return
        }

        var prevNode: Node<T>?
        var afterNode = head!!
        for (i in 0 until index) {
            afterNode = afterNode.next!!
        }
        prevNode = afterNode.previous
        prevNode!!.next = newNode
        afterNode.previous = newNode
        newNode.next = afterNode
        newNode.previous = prevNode
        size++
    }

    fun delete(index: Int): T {
        if (index < 0) {
            throw IllegalArgumentException("Delete method receive a negative index")
        }
        if (index >= size) {
            throw IllegalArgumentException("Delete method received index that more than size of list")
        }

        val value: T
        if (size == 1) {
            value = tail!!.value
            tail = null
            head = null
            size--
            return value
        }
        if (index == size - 1) {
            value = tail!!.value
            tail!!.previous!!.next = null
            tail = tail!!.previous
            size--
            return value
        }
        if (index == 0) {
            value = head!!.value
            head!!.next!!.previous = null
            head = head!!.next
            size--
            return value
        }

        var nowNode = head!!
        for (i in 0 until index) {
            nowNode = nowNode.next!!
        }
        value = nowNode.value
        nowNode.previous!!.next = nowNode.next
        nowNode.next!!.previous = nowNode.previous
        size--
        return value
    }

    fun deleteAll(value: T) {
        if (size == 0) {
            return
        }
        var nowNode = head
        var i = 0
        while (i < size) {
            if (nowNode!!.value == value) {
                delete(i)
                i--
            }
            if (i == size - 1) {
                return
            }
            nowNode = nowNode.next
            i++
        }
    }

    fun get(index: Int): T {
        val value: T

        if (index < 0) {
            throw IllegalArgumentException("Get method receive a negative index")
        }
        if (index >= size) {
            throw IllegalArgumentException("Get method received index that more than size of list")
        }
        if (size == 0) {
            throw IllegalArgumentException("Get method trying take value from empty list")
        }

        var nowNode = head!!
        for (i in 0 until index) {
            nowNode = nowNode.next!!
        }
        value = nowNode.value
        return value
    }

    fun clone(): DoubleLinkedList<T> {
        val copy = DoubleLinkedList<T>()
        if (size == 0) {
            return copy
        }

        var nowNode = head!!
        for (i in 0 until size) {
            copy.append(nowNode.value)
            if (i == size - 1) {
                return copy
            }
            nowNode = nowNode.next!!
        }

        throw IllegalArgumentException("DoubleLinkedList.clone is not returned clone")
    }

    fun reverse() {
        for (i in size - 1 downTo 0) {
            val value = delete(i)
            append(value)
        }
    }

    fun findFirst(value: T): Int {
        if (size == 0) {
            return -1
        }

        var nowNoded = head!!
        for (i in 0 until size) {
            if (nowNoded.value == value) {
                return i
            }
            if (i == size - 1) {
                return -1
            }
            nowNoded = nowNoded.next!!
        }

        throw IllegalArgumentException("FindFirst method returned nothing")
    }

    fun findLast(value: T): Int {
        if (size == 0) {
            return -1
        }

        var nowNode = tail!!
        for (i in size - 1 downTo 0) {
            if (nowNode.value == value) {
                return i
            }
            if (i == 0) {
                return -1
            }
            nowNode = nowNode.previous!!
        }

        throw IllegalArgumentException("FindLast method returned nothing")
    }

    fun clear() {
        if (size == 0) {
            return
        }

        val length = size
        for (i in 0 until length) {
            delete(0)
        }
    }

    fun extend(list: DoubleLinkedList<T>) {
        if (list.size == 0) {
            return
        }

        var nowNode = list.head!!
        for (i in 0 until list.size) {
            append(nowNode.value)
            if (i == list.size - 1) {
                return
            }
            nowNode = nowNode.next!!
        }
    }
}