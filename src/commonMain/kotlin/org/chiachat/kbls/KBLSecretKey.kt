package org.chiachat.kbls

class KBLSecretKey(kblsKey: KBLSKey): KBLSKey(kblsKey){
    fun sign(message: String) = kbls.sign(this, message)
}