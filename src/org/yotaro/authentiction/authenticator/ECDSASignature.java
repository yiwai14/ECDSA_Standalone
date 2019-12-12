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

    public byte[] signature(Signature ecdsa) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {

        //著名を取り出す
        byte[] sign = ecdsa.sign();

        System.out.println("Signature: " + new BigInteger(1, sign).toString(16));

        return sign;
    }
}