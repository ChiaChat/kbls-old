package org.chiachat.kbls

actual class PrivateKey(key: String) {
    actual fun genPubKey(): PublicKey {
        return PublicKey()
    }
}
