package org.chiachat.kbls.util

private const val hexCode = "0123456789ABCDEF"

fun Int.toHexString(): String {
    var number = this
    val builder = StringBuilder()
    while (number > 0) {
        val hexDigit: Int = number % 16
        builder.append(hexCode[hexDigit])
        number /= 16
    }
    return "0x" + builder.reverse().toString()
}