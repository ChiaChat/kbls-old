package org.chiachat.kbls

import org.chiachat.amcljs.CTX

actual class KBLS {
    actual fun genPrivateKey(secretPhrase: String): PrivateKey {
        val ctx = CTX("BLS12381")
        return PrivateKey("")
    }
    actual fun sign(privateKey: PrivateKey, message: String): Signature {
        return Signature()
    }
    actual fun verify(publicKey: PublicKey, message: String): Boolean {
        return true
    }
    actual fun aggregate(signatures: List<Signature>): Signature {
        return Signature()
    }
    actual fun verifyAggregate(publicKeys: List<PublicKey>, messages: List<String>): Boolean {
        return false
    }
}
