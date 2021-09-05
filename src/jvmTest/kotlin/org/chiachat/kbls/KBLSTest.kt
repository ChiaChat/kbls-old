package org.chiachat.kbls

import org.junit.jupiter.api.Test

class KBLSTest {
    val kbls = KBLS()

    @Test
    fun testGenKeypair(){
        kbls.genPrivateKey("Test phrase")
    }
}