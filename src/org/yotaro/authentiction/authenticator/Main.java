package org.yotaro.authentiction.authenticator;

import java.math.BigInteger;
import java.security.*;

public class Main {
    BigInteger a	= new BigInteger("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC" ,16);
    BigInteger b	= new BigInteger("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B" ,16);
    BigInteger q	= new BigInteger("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF" ,16);
    BigInteger l	= new BigInteger("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551" ,16);
    BigInteger Gx	= new BigInteger("6B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C296" ,16);
    BigInteger Gy	= new BigInteger("4FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5" ,16);

    public static void main(String[] args) {

        BigInteger R_value = Yy;



        System.out.println("▼Original Key");
        BigInteger X	= new BigInteger("95FEF3B589EC6875F6CA21C999E1C5979760D39CB86BF843EF0C2E07B8524699" ,16);	//[X] SecretKey
        BigInteger Yx	= new BigInteger("8a47399ba0b6c6d0d679e01e4f5f161253b7ef3bc53b3f29e2402586f8081cdd" ,16);	//[Yx]Publickey[X]
        BigInteger Yy	= new BigInteger("b75c80a53444a029598b8124aad9ab2a8b076b5396076dc1c592074004cd523c" ,16);	//[Yy]Publickey[Y]
        System.out.println("[X ] = " + X );
        System.out.println("[Yx] = " + Yx);
        System.out.println("[Yy] = " + Yy + "\r\n");

        System.out.println("▼Result");
        System.out.println(verifyGen(Yx, Yy, S_value, Message));
    }

    public static int verifyGen(BigInteger Yx, BigInteger Yy, BigInteger S_value, String Message) throws Exception{


        //secret key X (256bit 77 digits radmon number)

        //public key Y(coordivate so Yx and Yy)

        //temp secret key for sign: q

        //transaction data hash: h

        //sender secret key: k













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

        /*
         * 署名生成
         */
        String originalText = "This is string to sign";

        // 署名生成アルゴリズムを指定する
        Signature dsa = Signature.getInstance("SHA1withECDSA");
        // 初期化
        dsa.initSign(privateKey);
        // 署名生成
        dsa.update(originalText.getBytes("UTF-8"));
        // 生成した署名を取り出す
        byte[] signature = dsa.sign();
        System.out.println("Signature: " + DatatypeConverter.printHexBinary(signature));

        /*
         * 署名検証
         */
        // 初期化
        dsa.initVerify(publicKey);
        // 署名検証する対象をセットする
        dsa.update(originalText.getBytes("UTF-8"));
        // 署名検証
        boolean verifyResult = dsa.verify(signature);
        System.out.println("Verify: " + verifyResult);


        return 1;
    }
}
