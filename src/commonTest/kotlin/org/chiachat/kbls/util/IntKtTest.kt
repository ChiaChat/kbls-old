package org.chiachat.kbls.util

import kotlin.test.Test
import kotlin.test.assertTrue

internal class IntKtTest {

    @Test
    fun toHexString() {
        assertTrue {
            10.toHexString() == "0xA"
        }
        assertTrue {
            5.toHexString() == "0x5"
        }
        assertTrue {
            15.toHexString() == "0xF"
        }
        assertTrue {
            16.toHexString() == "0x10"
        }
        assertTrue {
            17.toHexString() == "0x11"
        }
        assertTrue {
            33.toHexString() == "0x21"
        }
        assertTrue {
            11256099.toHexString() == "0xABC123"
        }
    }
}