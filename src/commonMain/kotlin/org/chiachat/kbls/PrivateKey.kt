package org.chiachat.kbls

expect class PrivateKey {
    fun genPubKey(): PublicKey
}
