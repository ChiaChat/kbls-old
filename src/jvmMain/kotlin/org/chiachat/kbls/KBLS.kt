package org.chiachat.kbls

import org.chiachat.jbls.*
import org.chiachat.util.toJBLS
import org.chiachat.util.toKBLS
import org.chiachat.util.wrap
import java.security.SecureRandom

actual class KBLS {
    actual fun generateKeyPair(seed: String): KBLSKeyPair {
        val rng = SecureRandom()
        rng.setSeed(seed.toByteArray())
        return BLSKeyPair.random(rng).toKBLS()
    }

    actual fun sign(privateKey: KBLSecretKey, message: String): KBLSignature {
        val msg = message.toByteArray().wrap()
        return BLS.sign(privateKey.toJBLS(), msg).toKBLS()
    }
    actual fun aggregate(signatures: List<KBLSignature>): KBLSignature {
        val sigs = signatures.map { it.toJBLS() }
        return BLS.aggregate(sigs).toKBLS()
    }
    actual fun validateSignature(publicKey: KBLSPublicKey, message: String, signature: KBLSignature): Boolean {
        return BLS.verify(publicKey.toJBLS(), message.toByteArray().wrap(), signature.toJBLS())
    }
    actual fun validateAggregate(publicKeys: List<KBLSPublicKey>, messages: List<String>, signature: KBLSignature,): Boolean {
        val pks = publicKeys.map { it.toJBLS() }
        val msgs = messages.map { it.toByteArray().wrap() }
        return BLS.aggregateVerify(pks, msgs, signature.toJBLS())
    }
}
