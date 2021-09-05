package org.chiachat.kbls

import com.ionspin.kotlin.bignum.integer.BigInteger

data class Curve (
        // G1 is the order-q subgroup of E1(Fp) : y² = x³ + 4, #E1(Fp) = h1q, where
        // characteristic; z + (z⁴ - z² + 1)(z - 1)²/3
        val P: BigInteger,
        // order; z⁴ − z² + 1
        val r: BigInteger,
        val h: BigInteger,
        val Gx: BigInteger,
        val Gy: BigInteger,
        val b: BigInteger,
        val P2: BigInteger,
        val h2: BigInteger,
        val G2x: Pair<BigInteger, BigInteger>,
        val G2y: Pair<BigInteger, BigInteger>,
        val b2: Pair<BigInteger, BigInteger>,
        val x: BigInteger,
        val h2Eff: BigInteger,
        )