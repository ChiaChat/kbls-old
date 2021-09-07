package org.chiachat.kbls.util

import java.io.IOException
import java.io.UncheckedIOException

private const val hexCode = "0123456789ABCDEF"

fun Int.toHexString(): String {
    var number = this
    val builder = StringBuilder()
    while (number > 0) {
        val hexDigit: Int = number % 16
        builder.append(hexCode[hexDigit])
        number /= 16
    }
    return builder.reverse().toString()
}

fun ByteArray.toHex(): String = asUByteArray().joinToString("") {
    it.toString(radix = 16).padStart(2, '0')
}