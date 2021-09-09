package org.chiachat.kbls

import okio.ByteString.Companion.decodeHex
import org.chiachat.jbls.BLSKeyPair
import org.chiachat.kbls.crypto.ripemd160.extensions.digestRipemd160
import org.chiachat.kbls.crypto.sha256.extensions.sha256
import org.chiachat.kbls.util.hexToUByteArray
import org.junit.jupiter.api.Test
import java.security.SecureRandom
import kotlin.test.junit5.JUnit5Asserter.assertEquals


class KBLSTest {
    val kbls = KBLS()
    val seedphrase = "Super Secret Seed Phrase"
    val keypair = kbls.generateKeyPair(seedphrase)
//    val epk = "0xaac08e3b2102d33ef0c4158390bfaae330b105795ff354f416e8b640da90e3397e2621ddeebe4ef1e7bc2df7b91e1817",

    @Test
    fun testKeyGeneration() {
        val key = keypair.publicKey.toString()
        val random = SecureRandom()
        random.setSeed(seedphrase.toByteArray())
        val keypair = BLSKeyPair.random(random)
        val bytes = keypair.publicKey.toSSZBytes()
//        val convertedBytes = bytes.
//        assertEquals(
//            "Validate key determinism",
//            "0xaac08e3b2102d33ef0c4158390bfaae330b105795ff354f416e8b640da90e3397e2621ddeebe4ef1e7bc2df7b91e1817",
//            key
//        )
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    @Test
    fun testBech32Encoding(){
        val pk = "ebdae24c2760038ca20d1aac3ed6876a1158a5269169b952ac8c46f2a99e1512"
        val pkarr = pk.hexToUByteArray()
        pkarr.forEach { print("$it,") }
        val encoded = Bech32.encode(humanReadablePart = "xch", pkarr)
        assertEquals("Check keys match", "", encoded)
    }

    @Test
    fun testSignature(){
        val message = "Super Duper Authentic Message"
        val signature = keypair.sign(message)
//        assertTrue(KBLS.)
    }

    @Test
    fun testAggregatedSignature(){

    }
}