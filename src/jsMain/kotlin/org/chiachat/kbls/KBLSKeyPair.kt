package org.chiachat.kbls

actual class KBLSKeyPair actual constructor(seedPhrase: String) {
    actual val secretKey by lazy {
        ByteArray(32)
    }
    actual val publicKey by lazy {
        ByteArray(32)
    }
    actual val privateKeyString: String by lazy {
        ""
    }
    actual val publicKeyString: String by lazy {
        ""
    }
}