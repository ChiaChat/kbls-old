package org.chiachat.kbls

expect class KBLS {
    fun genPrivateKey(secretPhrase: String): PrivateKey
    fun sign(privateKey: PrivateKey, message: String): Signature
    fun verify(publicKey: PublicKey, message: String): Boolean
    fun aggregate(signatures: List<Signature>): Signature
    fun verifyAggregate(publicKeys: List<PublicKey>, messages: List<String>): Boolean
}
