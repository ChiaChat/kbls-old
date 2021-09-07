package org.chiachat.kbls

class KBLSignature(kblsKey: KBLSKey): KBLSKey(kblsKey){
    fun validate(publicKey: KBLSPublicKey, message: String): Boolean = kbls.validateSignature(publicKey, message, this)
}
