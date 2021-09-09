package org.chiachat.kbls.crypto

class HexString(val value: String) {
    constructor(intValue: Int) : this(intToHex(intValue))

//    fun toInt(): Int {
//
//    }

//    fun toBigInt(): BigInteger {
//
//    }

    fun toByteArray(): ByteArray {
        if (value.length % 2 == 0) throw IllegalStateException("Hex string must have an even length");
        return value.chunked(2)
            .map { it.toInt(16).toByte() }.toByteArray()
    }
    companion object {
        private const val HEXCODE = "0123456789ABCDEF"

        private fun intToHex(intValue: Int): String{
            var num = intValue
            val builder = StringBuilder()
            while (num > 0) {
                val hexDigit: Int = num % 16
                builder.append(HEXCODE[hexDigit])
                num /= 16
            }
            return builder.reverse().toString()
        }
    }
}