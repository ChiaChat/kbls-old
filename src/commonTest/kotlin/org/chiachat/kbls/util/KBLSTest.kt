package org.chiachat.kbls.util

import org.chiachat.kbls.KBLS
import kotlin.test.Test

class KBLSTest {
    val kbls = KBLS()
    val seedphrase = "Super Secret Seed Phrase"
    val keypair = kbls.generateKeyPair(seedphrase)
//    val epk = "0xaac08e3b2102d33ef0c4158390bfaae330b105795ff354f416e8b640da90e3397e2621ddeebe4ef1e7bc2df7b91e1817",

    @Test
    fun testKeyGeneration() {
        val key = keypair.publicKey.toString()
//        assertEquals(
//            "0xaac08e3b2102d33ef0c4158390bfaae330b105795ff354f416e8b640da90e3397e2621ddeebe4ef1e7bc2df7b91e1817",
//            key
//        )
    }

    @Test
    fun testSignature() {
        val message = "Super Duper Authentic Message"
        val signature = keypair.sign(message)
//        assertTrue(KBLS.)
    }

    @Test
    fun testAggregatedSignature() {
    }
}
