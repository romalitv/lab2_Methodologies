package com.example.lab2

data class SingleNode<T>(val value: T) {
    var next: Node<T>? = null
}