package org.chiachat.kbls

actual class KBLS {
    actual fun genKeyPair(seedPhrase: String): KBLSKeypair {
        return KBLSKeypair(PublicKey(""), KBLSKeyPair(""))
    }
    actual fun sign(privateKey: KBLSKeyPair, message: String): Signature {
        return Signature("")
    }
    actual fun verify(publicKey: PublicKey, message: String): Boolean {
        return true
    }
    actual fun aggregate(signatures: List<Signature>): Signature {
        return Signature("")
    }
    actual fun verifyAggregate(publicKeys: List<PublicKey>, messages: List<String>): Boolean {
        return false
    }
}
