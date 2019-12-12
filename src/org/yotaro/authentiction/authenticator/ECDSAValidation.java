package org.yotaro.authentiction.authenticator;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class ECDSAValidation{

    private PublicKey publicKey;
    private String message;

    public ECDSAValidation(String message, PublicKey publicKey){
        this.message = message;
        this.publicKey = publicKey;
    }

    public boolean validate(byte[] sign) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, SignatureException {

        //著名アルゴリズム生成
        Signature ecdsa = Signature.getInstance("SHA1withECDSA");

        // 初期化
        ecdsa.initVerify(publicKey);

        // 署名検証する対象をセットする
        ecdsa.update(message.getBytes("UTF-8"));

        // 署名検証
        boolean verifyResult = ecdsa.verify(sign);

        System.out.println("Verify: " + verifyResult);

        return verifyResult;
    }
}