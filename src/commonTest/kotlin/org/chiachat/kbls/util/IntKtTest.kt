package org.chiachat.kbls.util

import kotlin.test.Test
import kotlin.test.assertTrue

internal class IntKtTest {

    @Test
    fun toHexString() {
        assertTrue {
            10.toHexString() == "A"
        }
        assertTrue {
            5.toHexString() == "5"
        }
        assertTrue {
            15.toHexString() == "F"
        }
        assertTrue {
            16.toHexString() == "10"
        }
        assertTrue {
            17.toHexString() == "11"
        }
        assertTrue {
            33.toHexString() == "21"
        }
        assertTrue {
            11256099.toHexString() == "ABC123"
        }
    }
}