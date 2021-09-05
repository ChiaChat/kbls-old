package org.chiachat.amcljs

import org.chiachat.kbls.KBLS
import kotlin.test.Test

class AMCLTest {
    @Test
    fun testCtx(){
        val kbls = KBLS()
        kbls.genPrivateKey("Test private key");
    }
}