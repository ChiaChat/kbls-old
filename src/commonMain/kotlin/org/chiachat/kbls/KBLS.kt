package org.chiachat.kbls

expect class KBLS() {
    fun generateKeyPair(seed: String): KBLSKeyPair
    fun sign(privateKey: KBLSecretKey, message: String): KBLSignature
    fun aggregate(signatures: List<KBLSignature>): KBLSignature
    fun validateSignature(publicKey: KBLSPublicKey, message: String, signature: KBLSignature): Boolean
    fun validateAggregate(publicKeys: List<KBLSPublicKey>, messages: List<String>, signature: KBLSignature): Boolean
}
