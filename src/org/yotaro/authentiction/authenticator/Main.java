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

        String message = "Hello World";

        //著名生成アルゴリズム指定
        Signature ecdsa = Signature.getInstance("SHA256withECDSA");

        //初期化
        ecdsa.initSign(privateKey);

        //著名生成
        ecdsa.update(message.getBytes("UTF-8"));

        //著名を取り出す
        byte[] sign = ecdsa.sign();
        System.out.println("Signature: " + new BigInteger(1, sign).toString(16));

        // 初期化
        ecdsa.initVerify(publicKey);

        // 署名検証する対象をセットする
        ecdsa.update(message.getBytes("UTF-8"));

        // 署名検証
        boolean verifyResult = ecdsa.verify(sign);
        System.out.println("result: " + verifyResult);

    }
}
