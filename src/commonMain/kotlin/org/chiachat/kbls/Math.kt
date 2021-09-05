package org.chiachat.kbls

import com.ionspin.kotlin.bignum.integer.BigInteger

class Math {

    fun mod(a: BigInteger, b: BigInteger): BigInteger {
        val res = a % b;
        return if(res >= BigInteger.ZERO) res else b + res
    }

    fun powMod(a: BigInteger, power: BigInteger, modulo: BigInteger): BigInteger {
        var aTemp = a;
        var powerTemp = power
        var res = BigInteger.ONE
        while (powerTemp > 0) {
            if (!powerTemp.and(BigInteger.ONE).isZero()) res = (res * aTemp) % modulo;
            aTemp = (aTemp * aTemp) % modulo;
            powerTemp = powerTemp.shr(1);
        }
        return res;
    }


    companion object {
        val CURVE = Curve(
            P = BigInteger.parseString(
                "0x1a0111ea397fe69a4b1ba7b6434bacd764774b84f38512bf6730d2a0f6b0f6241eabfffeb153ffffb9feffffffffaaab",
                16
            ),
            // order; z⁴ − z² + 1
            r = BigInteger.parseString("0x73eda753299d7d483339d80809a1d80553bda402fffe5bfeffffffff00000001", 16),
            // cofactor; (z - 1)²/3
            h = BigInteger.parseString("0x396c8c005555e1568c00aaab0000aaab", 16),
            // generator's coordinates
            Gx = BigInteger.parseString(
                "0x17f1d3a73197d7942695638c4fa9ac0fc3688c4f9774b905a14e3a3f171bac586c55e83ff97a1aeffb3af00adb22c6bb",
                16
            ),
            Gy = BigInteger.parseString(
                "0x08b3f481e3aaa0f1a09e30ed741d8ae4fcf5e095d5d00af600db18cb2c04b3edd03cc744a2888ae40caa232946c5e7e1",
                16
            ),
            b = BigInteger.parseString("4"),

            // G2 is the order-q subgroup of E2(Fp²)  = y² = x³+4(1+√−1),
            // where Fp2 is Fp[√−1]/(x2+1). #E2(Fp2 ) = h2q, where
            // G² - 1
            // h2q
            P2 =
            BigInteger.parseString(
                "0x1a0111ea397fe69a4b1ba7b6434bacd764774b84f38512bf6730d2a0f6b0f6241eabfffeb153ffffb9feffffffffaaab",
                16
            ).pow(2) - 1,
            // cofactor
            h2 = BigInteger.parseString(
                "0x5d543a95414e7f1091d50792876a202cd91de4547085abaa68a205b2e5a7ddfa628f1cb4d9e82ef21537e293a6691ae1616ec6e786f0c70cf1c38e31c7238e5",
                16
            ),
            G2x = Pair(
                BigInteger.parseString(
                    "0x024aa2b2f08f0a91260805272dc51051c6e47ad4fa403b02b4510b647ae3d1770bac0326a805bbefd48056c8c121bdb8",
                    16
                ),
                BigInteger.parseString(
                    "0x13e02b6052719f607dacd3a088274f65596bd0d09920b61ab5da61bbdc7f5049334cf11213945d57e5ac7d055d042b7e",
                    16
                ),
            ),
            G2y = Pair(
                BigInteger.parseString(
                    "0x0ce5d527727d6e118cc9cdc6da2e351aadfd9baa8cbdd3a76d429a695160d12c923ac9cc3baca289e193548608b82801",
                    16
                ),
                BigInteger.parseString(
                    "0x0606c4a02ea734cc32acd2b02bc28b99cb3e287e85a763af267492ab572e99ab3f370d275cec1da1aaa9075ff05f79be",
                    16
                ),
            ),
            b2 = Pair(BigInteger.parseString("4"), BigInteger.parseString("4")),
            // The BLS parameter x for BLS12-381
            x = BigInteger.parseString("0xd201000000010000", 16),
            h2Eff =
            BigInteger.parseString(
                "0xbc69f08f2ee75b3584c6a0ea91b352888e2a8e9145ad7689986ff031508ffe1329c2f178731db956d82bf015d1212b02ec0ec69d7477c1ae954cbc06689f6a359894c0adebbf6b4e8020005aaa95551",
                16
            ),
        )
        const val BLS_X_LEN: Int = bitLen(CURVE.x)
    }
}