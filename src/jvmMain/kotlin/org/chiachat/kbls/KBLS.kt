package org.chiachat.kbls

import org.chiachat.BLS12381.BLS
import org.chiachat.BLS12381.BLS.BGS
import org.chiachat.core.RAND




actual class KBLS {


    actual fun genPrivateKey(secretPhrase: String): PrivateKey {
        val rng = RAND()
        val BGS = BGS
        val BFS = BLS.BFS
        val G1S = BFS + 1 /* Group 1 Size - compressed */
        val G2S = 2 * BFS + 1 /* Group 2 Size - compressed */

        val S = ByteArray(BGS)
        val W = ByteArray(G2S)
        val SIG = ByteArray(G1S)
        val RAW = ByteArray(100)
        val IKM = ByteArray(32)

        rng.clean()
        for (i in 0..99) RAW[i] = i.toByte()
        rng.seed(100, RAW)

        for (i in IKM.indices)  //IKM[i]=(byte)(i+1);
            IKM[i] = rng.byte.toByte()

        println("\nTesting BLS code")

        var res = BLS.init()
        if (res != 0) println("Failed to initialize")

        val mess: String = "This is a test message"

        res = BLS.KeyPairGenerate(IKM, S, W)
        if (res != 0) println("Failed to Generate Keys")
        print("Private key : 0x")
        printBinary(S)
        print("Public  key : 0x")
        printBinary(W)

        BLS.core_sign(SIG, mess.toByteArray(), S)
        print("Signature : 0x")
        printBinary(SIG)

        res = BLS.core_verify(SIG, mess.toByteArray(), W)

        if (res == 0) println("Signature is OK") else println("Signature is *NOT* OK")
        return PrivateKey("Test")
    }
    fun printBinary(array: ByteArray) {
        var i: Int
        i = 0
        while (i < array.size) {
            System.out.printf("%02x", array[i])
            i++
        }
        println()
    }
    actual fun sign(privateKey: PrivateKey, message: String): Signature {
        return Signature()
    }
    actual fun verify(publicKey: PublicKey, message: String): Boolean {
        return true
    }
    actual fun aggregate(signatures: List<Signature>): Signature {
        return Signature()
    }
    actual fun verifyAggregate(publicKeys: List<PublicKey>, messages: List<String>): Boolean {
        return false
    }
}
