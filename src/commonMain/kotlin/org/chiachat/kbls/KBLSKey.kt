package org.chiachat.kbls

import org.chiachat.kbls.crypto.bech32.Bech32Data
import org.chiachat.kbls.crypto.ripemd160.Ripemd160Digest
import org.chiachat.kbls.crypto.ripemd160.extensions.digestRipemd160
import org.chiachat.kbls.crypto.sha256.Sha256
import org.chiachat.kbls.crypto.sha256.extensions.sha256

open class KBLSKey(val key: ByteArray) {
    constructor(keyStr: String): this(Bech32.decode(keyStr).data)
    constructor(kblsKey: KBLSKey): this(kblsKey.key)

    protected val kbls = KBLS()

    @OptIn(ExperimentalUnsignedTypes::class)
    override fun toString(): String{
        return ""
//        val hashed = key.sha256()
//        val hashed2 = hashed.digestRipemd160()
//        return Bech32.encode(Bech32Data("xch", hashed))
    }
}