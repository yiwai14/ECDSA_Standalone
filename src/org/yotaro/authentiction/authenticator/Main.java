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





        /*
        //鍵ペア生成
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC"); // Elliptic Curve
        // 乱数生成器
        SecureRandom randomGen = SecureRandom.getInstance("SHA1PRNG");
        // 鍵サイズと乱数生成器を指定して鍵ペア生成器を初期化
        int keySize = 256;
        keyGen.initialize(keySize, randomGen);

        // 鍵ペア生成
        KeyPair keyPair = keyGen.generateKeyPair();
        // 秘密鍵
        PrivateKey privateKey = keyPair.getPrivate();
        // 公開鍵
        PublicKey publicKey = keyPair.getPublic();

        //著名生成
        String originalText = "This is string to sign";
        */

        /*
        // 署名生成アルゴリズムを指定する
        Signature dsa = Signature.getInstance("SHA1withECDSA");
        // 初期化
        dsa.initSign(privateKey);
        // 署名生成
        dsa.update(originalText.getBytes("UTF-8"));
        // 生成した署名を取り出す
        byte[] signature = dsa.sign();
        System.out.println("Signature: " + DatatypeConverter.printHexBinary(signature));

        //検証
        // 初期化
        dsa.initVerify(publicKey);
        // 署名検証する対象をセットする
        dsa.update(originalText.getBytes("UTF-8"));
        // 署名検証
        boolean verifyResult = dsa.verify(signature);
        System.out.println("Verify: " + verifyResult);

        return 1;
        */
}
