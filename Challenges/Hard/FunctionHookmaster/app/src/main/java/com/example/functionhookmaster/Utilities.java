package com.example.functionhookmaster;


import android.util.Base64;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class Utilities {
    private static final String P_1 = "1bea";
    private static final String P_2 = "3a3d";
    private static final String P_3 = "4bc3";
    private static final String P_4 = "be11";
    private static final String P_5 = "49a7";
    private static final String P_6 = "5b33";
    private static final String P_7 = "fb8d";
    private static final String P_8 = "82bc";

    public static String getFlag() {
        String c_1 = "7CHw";
        String c_2 = "9txe";
        String c_3 = "jOYv";
        String c_4 = "yH4h";
        String c_5 = "0Gs1";
        String c_6 = "9l32";
        String c_7 = "QlX6";
        String c_8 = "PSh4";
        String c_9 = "uCSF";
        String c_10 = "v1Jc";
        String c_11 = "UC8=";

        String cipherText = c_1 + c_2 + c_3 + c_4 + c_5 + c_6 + c_7 + c_8 + c_9 + c_10 + c_11;

        byte[] bkdec = Base64.decode(cipherText, Base64.DEFAULT);
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec keySpec = new SecretKeySpec((P_1 + P_2 + P_3 + P_4 + P_5 + P_6 + P_7 + P_8).getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decryptedBytes = cipher.doFinal(bkdec);
            return new String(decryptedBytes, "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }

    public static String MD5(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte[] messageDigest = digest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(b & 0xff);
                if (hex.length() == 1) {
                    sb.append("0");
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}