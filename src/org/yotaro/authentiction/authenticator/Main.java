package org.yotaro.authentiction.authenticator;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;

public class Main {

    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, SignatureException {

        //鍵ペア生成機
        KeyPairGenerator kpg;
        kpg = KeyPairGenerator.getInstance("EC", "SunEC");

        //乱数生成機
        SecureRandom randomGen = SecureRandom.getInstance("SHA1PRNG");

        // 鍵サイズと乱数生成器を指定して鍵ペア生成器を初期化
        kpg.initialize(256, randomGen);

        //鍵ペア生成
        KeyPair keyPair = kpg.generateKeyPair();

        //公開鍵
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("public key: " + publicKey);

        //秘密鍵
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("private key: " + privateKey);

        //著名生成
        ECDSASignature ecdsaSignature = new ECDSASignature("Hello World", privateKey);
        byte[] sign = ecdsaSignature.signature();

        //著名検証
        ECDSAValidation ecdsaValidation = new ECDSAValidation("Hello World", publicKey);
        System.out.println(ecdsaValidation.validate(sign));
    }
}
