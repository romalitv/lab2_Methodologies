import com.example.lab2.DoubleLinkedList
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.math.exp

class DoubleLinkedListTest {

    @Test
    fun length() {
        val list = DoubleLinkedList<Any>()
        list.append(1)
        assertEquals(1, list.size)
        list.insert(2,1)
        assertEquals(2, list.size)
    }

    @Test
    fun append() {
        val list = DoubleLinkedList<Any>()

        list.append(1)

        assertEquals(1, list.head?.value)
        assertEquals(1, list.tail?.value)

        list.append(2)

        assertEquals(1, list.head?.value)
        assertEquals(1, list.tail?.previous?.value)
        assertEquals(2, list.tail?.value)
        assertEquals(2, list.head?.next?.value)
    }

    @Test
    fun insert() {
        val list = DoubleLinkedList<Any>()

        list.insert(1,0)

        assertEquals(1, list.size)
        assertEquals(1 ,list.head?.value)
        assertEquals(1, list.tail?.value)

        list.insert(3,1)
        list.insert(4,2)

        list.insert(2,1)

        assertEquals(4, list.size)
        assertEquals(2 ,list.head?.next?.value)
        assertEquals(2, list.tail?.previous?.previous?.value)
    }

    @Test
    fun delete() {
        val list = DoubleLinkedList<Any>()

        list.append(1)
        list.insert(2,1)
        list.append(3)

        assertEquals(3, list.size)

        list.delete(1)

        assertEquals(2,list.size)
        assertEquals(1,list.tail?.previous?.value)
        assertEquals(1,list.head?.value)
        assertEquals(3,list.head?.next?.value)
        assertEquals(3,list.tail?.value)

    }

    @Test
    fun deleteAll() {
        val list = DoubleLinkedList<Any>()

        list.appendList(arrayOf(1,5,3,4,5).toList())

        assertEquals(5, list.size)

        list.deleteAll(5)

        assertEquals(3, list.size)
    }

    @Test
    fun get() {
        val list = DoubleLinkedList<Any>()
        list.appendList(arrayOf(1,2,3,4,5).toList())

        assertEquals(5, list.get(4))
        assertEquals(3, list.get(2))
        assertEquals(1, list.get(0))
    }

    @Test
    fun clone() {
        val list = DoubleLinkedList<Any>()
    }

    @Test
    fun reverse() {
        val list = DoubleLinkedList<Any>()
        list.appendList(arrayOf(1,2,3,4,5).toList())
        list.reverse()

        assertEquals(1, list.get(4))
        assertEquals(5, list.get(0))
        assertEquals(3, list.get(2))
    }

    @Test
    fun findFirst() {
        val list = DoubleLinkedList<Any>()
        list.appendList(arrayOf(1,2,3,3,3,4,2,5).toList())

        assertEquals(2, list.findFirst(3))
        assertEquals(1, list.findFirst(2))
        assertEquals(5, list.findFirst(4))
    }

    @Test
    fun findLast() {
        val list = DoubleLinkedList<Any>()
    }

    @Test
    fun clear() {
        val list = DoubleLinkedList<Any>()
    }

    @Test
    fun extend() {
        val list = DoubleLinkedList<Any>()
    }
}