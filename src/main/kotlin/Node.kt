package com.example.lab2

data class Node<T>(val value: T) {
    var next: Node<T>? = null
    var previous: Node<T>? = null
}