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
    }

    @Test
    fun deleteAll() {
        val list = LinkedList<Any>()
    }

    @Test
    fun get() {
        val list = LinkedList<Any>()
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
    }

    @Test
    fun reverse() {
        val list = LinkedList<Any>()
    }

    @Test
    fun clear() {
        val list = LinkedList<Any>()
    }

    @Test
    fun extend() {
        val list = LinkedList<Any>()
    }
}