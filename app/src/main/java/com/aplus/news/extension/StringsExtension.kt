package com.aplus.news.extension

fun String.isPhone(): Boolean {
    val p = "^1([34578])\\d{9}\$".toRegex()
    return matches(p)
}

fun String.isEmail(): Boolean {
    val p = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)\$".toRegex()
    return matches(p)
}

fun String.isNumeric(): Boolean {
    val p = "^[0-9]+$".toRegex()
    return matches(p)
}

fun String.removeFirst(): String {
    return substring(1, this.length)
}

fun String.removeLast(): String {
    return substring(0, this.length-1)
}

fun String.removeFirstAndLast(): String {
    return substring(1, this.length-1)
}