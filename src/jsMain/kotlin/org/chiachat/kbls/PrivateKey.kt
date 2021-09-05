package org.chiachat.kbls

actual class PrivateKey {
    actual fun genPubKey(): PublicKey {
        return PublicKey()
    }
}
