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
    }

    @Test
    fun get() {
    }

    @Test
    fun reverse() {
    }

    @Test
    fun findFirst() {
    }

    @Test
    fun findLast() {
    }

    @Test
    fun testClone() {
    }

    @Test
    fun clear() {
    }

    @Test
    fun extend() {
    }
}