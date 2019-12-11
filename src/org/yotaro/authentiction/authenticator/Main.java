package org.yotaro.authentiction.authenticator;

import java.math.BigInteger;
import java.security.PublicKey;

public class Main {

    public static void main(String[] args) {

        System.out.println("▼prime256v1 SetParameter");
        BigInteger a	= new BigInteger("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC" ,16);	//[a]
        BigInteger b	= new BigInteger("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B" ,16);	//[b]
        BigInteger q	= new BigInteger("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF" ,16);	//[q] prime
        BigInteger l	= new BigInteger("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551" ,16);	//[l] prime
        BigInteger Gx	= new BigInteger("6B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C296" ,16);	//[Gx]BasePoint[X]
        BigInteger Gy	= new BigInteger("4FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5" ,16);	//[Gy]BasePoint[Y]
        System.out.println("[a ] = " + a );
        System.out.println("[b ] = " + b );
        System.out.println("[q ] = " + q );
        System.out.println("[l ] = " + l );
        System.out.println("[Gx] = " + Gx);
        System.out.println("[Gy] = " + Gy + "\r\n");

        System.out.println("▼Original Key");
        BigInteger X	= new BigInteger("95FEF3B589EC6875F6CA21C999E1C5979760D39CB86BF843EF0C2E07B8524699" ,16);	//[X] SecretKey
        BigInteger Yx	= new BigInteger("8a47399ba0b6c6d0d679e01e4f5f161253b7ef3bc53b3f29e2402586f8081cdd" ,16);	//[Yx]Publickey[X]
        BigInteger Yy	= new BigInteger("b75c80a53444a029598b8124aad9ab2a8b076b5396076dc1c592074004cd523c" ,16);	//[Yy]Publickey[Y]
        System.out.println("[X ] = " + X );
        System.out.println("[Yx] = " + Yx);
        System.out.println("[Yy] = " + Yy + "\r\n");


    }

    public static int verifyGen(PublicKey publicKey, BigInteger R_value, BigInteger S_value, String Message) throws Exception{

    }
}
