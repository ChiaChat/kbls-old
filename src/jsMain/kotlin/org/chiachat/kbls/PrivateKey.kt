package org.chiachat.kbls

actual class PrivateKey(val key: String) {
    actual fun genPubKey(): PublicKey {
        return PublicKey()
    }
}
