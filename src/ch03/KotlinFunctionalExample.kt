package ch03

import kotlin.math.roundToLong


data class Member(var name: String, var age: Int)

fun main() {
    val members: MutableList<Member> = ArrayList()
    members.add(Member("카리나", 24))
    members.add(Member("윈터", 23))
    members.add(Member("지젤", 24))
    members.add(Member("닝닝", 22))

    val chosenMembers = members
        .filter { it.age == 24 }
        .map { it.name }
        .sorted()

    println(chosenMembers)

    // ---

    val numbers1: List<Double> = mutableListOf(49.1, 25.5, 9.9)
    numbers1
        .map(Math::round)
        .forEach(System.out::println)

    // ---

    val numbers2: List<Double> = mutableListOf(49.1, 25.5, 9.9)
    numbers2
        .map { it.roundToLong() }
        .forEach { println(it) }
}