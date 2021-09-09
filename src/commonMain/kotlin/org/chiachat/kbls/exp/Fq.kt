package org.chiachat.kbls.exp

import com.ionspin.kotlin.bignum.integer.*;

class Fq(private var Q: BigInteger, private var value: BigInteger) {

    init {
        value %= Q
    }

    fun neg(): Fq {
        return Fq(Q, -value)
    }

    operator fun plus(other: Fq): Fq {
        return Fq(Q, value + other.value)
    }

    operator fun minus(other: Fq): Fq {
        return Fq(Q, value - other.value)
    }

    operator fun times(other: Fq): Fq {
        return Fq(Q, value * other.value)
    }

    operator fun div(other: Fq): Fq {
        return this * other.invert()
    }

    operator fun div(other: BigInteger): Fq {
        return this * Fq(Q, other).invert()
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Fq) {
            (value == other.value) && Q == other.Q
        } else {
            false
        }
    }

    operator fun compareTo(other: Fq): Int {
        return if (value > other.value) {
            1
        } else if (value < other.value) {
            -1;
        } else {
            0;
        }
    }

    fun pow(exponent: Int): Fq {
        if (exponent == 0)
            return Fq(Q, BigInteger.ONE)
        else if (exponent == 1)
            return Fq(Q, value)
        else if (exponent % 2 == 0)
            return Fq(Q, value * value).pow(exponent / 2)
        else {
            return Fq(Q, value * value).pow(exponent / 2) * this
        }
    }

    fun qiPower(i: Int): Fq {
        return this
    }

    fun invert(): Fq {
//        Extended euclidian algorithm for inversion.
        var x0 = 1
        var x1 = 0
        var y0 = 0
        var y1 = 0
        var a = Q
        var b = value
        while (a != 0){
            val q = b / a
            b = a
            a = b % a
            x0 = x1
            x1 = x0 - q * x1
            y0 = y1
            y1 = y0 - q * y1
        }
        return Fq(Q, x0)
    }

    fun modSqrt



    override fun toString(): String {
        val s = value.toHexString()
        val s2 =
            if (s.length > 10)
                s.slice(0..7) + ".." + s.slice((s.lastIndex - 5)..(s.lastIndex))
            else s
        return "Fq($s2)"
    }

    fun toStringFull(): String {
        return "Fq(${value.toHexString()})"
    }

    fun toBytes(): ByteArray {
        TODO()
    }


    companion object {
        fun fromBytes(bytes: ByteArray): Fq {
            TODO()
        }
    }
}