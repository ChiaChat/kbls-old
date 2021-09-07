package org.chiachat.util

import org.apache.tuweni.bytes.Bytes
import org.apache.tuweni.bytes.Bytes32
import org.apache.tuweni.bytes.Bytes48
import org.chiachat.jbls.BLSKeyPair
import org.chiachat.jbls.BLSPublicKey
import org.chiachat.jbls.BLSSecretKey
import org.chiachat.jbls.BLSSignature
import org.chiachat.kbls.*

fun BLSPublicKey.toKBLS(): KBLSPublicKey {
    return KBLSPublicKey(KBLSKey(toBytesCompressed().toArray()))
}

fun BLSSecretKey.toKBLS(): KBLSecretKey {
    return KBLSecretKey(KBLSKey(toBytes().toArray()))
}

fun BLSSignature.toKBLS(): KBLSignature {
    return KBLSignature(KBLSKey(toBytesCompressed().toArray()))
}

fun BLSKeyPair.toKBLS(): KBLSKeyPair {
    return KBLSKeyPair(this.secretKey.toKBLS(), this.publicKey.toKBLS())
}

fun KBLSPublicKey.toJBLS(): BLSPublicKey {
    return BLSPublicKey.fromBytesCompressed(this.key.wrap48())
}

fun KBLSecretKey.toJBLS(): BLSSecretKey {
    return BLSSecretKey.fromBytes(this.key.wrap32())
}

fun KBLSignature.toJBLS(): BLSSignature {
    return BLSSignature.fromBytesCompressed(this.key.wrap48())
}

fun KBLSKeyPair.toJBLS(): BLSKeyPair {
    return BLSKeyPair(this.publicKey.toJBLS(), this.secretKey.toJBLS())
}

fun ByteArray.wrap(): Bytes {
    return Bytes.wrap(this)
}

fun ByteArray.wrap32(): Bytes32 {
    return Bytes32.wrap(this)
}

fun ByteArray.wrap48(): Bytes48 {
    return Bytes48.wrap(this)
}
