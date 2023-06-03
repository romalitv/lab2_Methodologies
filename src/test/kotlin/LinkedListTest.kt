import com.example.lab2.DoubleLinkedList
import com.example.lab2.LinkedList
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LinkedListTest {

    @Test
    fun length() {
        val list = LinkedList<Any>()

        list.append(1)

        assertEquals(1, list.length())
        assertEquals(1, list.array[0].value)

        list.append(2)

        assertEquals(2, list.array[0].next?.value)
        assertEquals(2, list.array[1].value)
    }

    @Test
    fun append() {
        val list = LinkedList<Any>()

        list.append(1)

        assertEquals(1, list.array[0].value)

        list.append(2)

        assertEquals(2, list.array[0].next?.value)
        assertEquals(2, list.array[1].value)
        assertEquals(1, list.array[0].value)

    }

    @Test
    fun appendList() {
        val list = LinkedList<Any>()
        list.appendList(arrayListOf(1,2,3,4,5))

        assertEquals(1, list.array[0].value)
        assertEquals(2, list.array[1].value)
        assertEquals(3, list.array[2].value)
        assertEquals(4, list.array[3].value)
        assertEquals(5, list.array[4].value)
    }

    @Test
    fun insert() {
        val list = LinkedList<Any>()

        list.insert(1,0)

        assertEquals(1, list.array[0].value)

        list.append(3)
        list.insert(2,1)

        assertEquals(2, list.array[1].value)

        list.insert(0,0)

        assertEquals(0, list.array[0].value)
    }

    @Test
    fun delete() {
        val list = LinkedList<Any>()

        list.append(1)
        list.insert(2,1)
        list.append(3)

        assertEquals(3, list.array.size)

        list.delete(1)

        assertEquals(2,list.array.size)
        assertEquals(1,list.array[0].value)
        assertEquals(3,list.array[1].value)

        assertThrows(IndexOutOfBoundsException::class.java) { list.delete(5) }
        assertThrows(IndexOutOfBoundsException::class.java) { list.delete(-1) }

    }

    @Test
    fun deleteAll() {
        val list = LinkedList<Any>()

        list.appendList(arrayListOf(1,2,2,3,4,5))

        assertEquals(6, list.array.size)

        list.deleteAll(2)

        assertEquals(4, list.array.size)
    }

    @Test
    fun get() {
        val list = LinkedList<Any>()
        list.appendList(arrayListOf(1,2,3,4,5))

        assertEquals(5, list.get(4))
        assertEquals(3, list.get(2))
        assertEquals(1, list.get(0))
    }

    @Test
    fun findFirst() {
        val list = LinkedList<Any>()
    }

    @Test
    fun findLast() {
        val list = LinkedList<Any>()
    }

    @Test
    fun clone() {
        val list = LinkedList<Any>()

        list.appendList(arrayListOf(1,2,3,4,5))

        val listClone = list.clone()

        assertEquals(1,listClone.get(0))
        assertEquals(5,listClone.get(4))
        assertEquals(3,listClone.get(2))

        val listCloneCloned = listClone.clone()

        assertEquals(1,listCloneCloned.get(0))
        assertEquals(5,listCloneCloned.get(4))
        assertEquals(3,listCloneCloned.get(2))
    }

    @Test
    fun reverse() {
        val list = LinkedList<Any>()
        list.appendList(arrayListOf(1,2,3,4,5))
        list.reverse()

        assertEquals(1, list.get(4))
        assertEquals(5, list.get(0))
        assertEquals(3, list.get(2))
    }

    @Test
    fun clear() {
        val list = LinkedList<Any>()

        list.appendList(arrayListOf(1,2,3,4,5))

        list.clear()

        assertEquals(0, list.array.size)
    }

    @Test
    fun extend() {
        val list = LinkedList<Any>()
        list.appendList(arrayListOf(1,2,3,4,5))
        val list2 = LinkedList<Any>()
        list2.appendList(arrayListOf(6,7,8,9))

        list.extend(list2)
        assertEquals(9, list.array.size)
        assertEquals(6, list.get(5))
        assertEquals(7, list.get(6))
        assertEquals(8, list.get(7))
        assertEquals(9, list.get(8))
    }
}