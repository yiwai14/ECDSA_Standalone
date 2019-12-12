package org.yotaro.authentiction.authenticator;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;


public class ECDSASignature{

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