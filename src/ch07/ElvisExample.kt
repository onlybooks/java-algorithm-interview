package ch07

import java.util.*

fun main() {
    fun rand(): Int? {
        return Random().nextInt(100 - 1) + 1
    }

    val x = rand() ?: 0
    println("x: $x")
}