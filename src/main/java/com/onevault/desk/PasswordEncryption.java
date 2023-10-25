package com.onevault.desk;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class PasswordEncryption {
    static SecretKey secretKey;

    static PasswordEncryption passwordEncryption = null;

    private PasswordEncryption(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128); // block size is 128bits
            secretKey = keyGenerator.generateKey();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static PasswordEncryption getInstance(){
        if(passwordEncryption == null){
            passwordEncryption = new PasswordEncryption();
        }
        return passwordEncryption;
    }

//    private static void initSecurity() {
//        try {
//            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//            keyGenerator.init(128); // block size is 128bits
//            secretKey = keyGenerator.generateKey();
//        }
//        catch(Exception ex){
//            ex.printStackTrace();
//        }
//    }

    public static String encrypt(String plainText)
            throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    public static String decrypt(String encryptedText)
            throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
}
