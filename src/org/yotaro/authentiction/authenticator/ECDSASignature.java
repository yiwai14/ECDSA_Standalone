package org.yotaro.authentiction.authenticator;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;


public class ECDSASignature{

    //prime256v1 parameter
    BigInteger a	= new BigInteger("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC" ,16);
    BigInteger b	= new BigInteger("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B" ,16);
    BigInteger q	= new BigInteger("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF" ,16);
    BigInteger l	= new BigInteger("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551" ,16);
    BigInteger Gx	= new BigInteger("6B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C296" ,16);
    BigInteger Gy	= new BigInteger("4FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5" ,16);

    private String message;
    private PrivateKey privateKey;

    public ECDSASignature(String message, PrivateKey privateKey){
        this.message = message;
        this.privateKey = privateKey;
    }

    public byte[] signature() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        BigInteger[] RS = new BigInteger[2];

        //著名生成アルゴリズム指定
        Signature ecdsa = Signature.getInstance("SHA256withECDSA");

        //初期化
        ecdsa.initSign(privateKey);

        //著名生成
        ecdsa.update(message.getBytes("UTF-8"));

        //著名を取り出す
        byte[] sign = ecdsa.sign();

        System.out.println("Signature: " + new BigInteger(1, sign).toString(16));

        return sign;
    }
}