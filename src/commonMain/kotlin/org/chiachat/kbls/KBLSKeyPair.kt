package org.chiachat.kbls

data class KBLSKeyPair(
    val secretKey: KBLSecretKey,
    val publicKey: KBLSPublicKey
){
    fun sign(message: String) = secretKey.sign(message)
}

