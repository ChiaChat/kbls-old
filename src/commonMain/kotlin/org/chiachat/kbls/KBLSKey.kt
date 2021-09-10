package org.chiachat.kbls

open class KBLSKey(val key: ByteArray) {
    constructor(keyStr: String) : this(Bech32.decode(keyStr).data)
    constructor(kblsKey: KBLSKey) : this(kblsKey.key)

    protected val kbls = KBLS()

    @OptIn(ExperimentalUnsignedTypes::class)
    override fun toString(): String {
        return ""
//        val hashed = key.sha256()
//        val hashed2 = hashed.digestRipemd160()
//        return Bech32.encode(Bech32Data("xch", hashed))
    }
}
