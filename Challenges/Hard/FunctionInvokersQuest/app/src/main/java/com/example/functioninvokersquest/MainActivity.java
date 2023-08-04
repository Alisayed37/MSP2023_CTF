package com.example.functioninvokersquest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public String getFlag() {
        String P = getString(R.string.P);
        String c = getString(R.string.c);
        byte[] d = Base64.decode(c, Base64.DEFAULT);
        try {
            Cipher ci = Cipher.getInstance("AES"); SecretKeySpec ks = new SecretKeySpec(P.getBytes(), "AES");
            ci.init(Cipher.DECRYPT_MODE, ks);
            byte[] dd = ci.doFinal(d);
            return new String(dd, "UTF-8");
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException |
                 BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) { e.printStackTrace(); }
        return null;
    }
    public static String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); md.update(s.getBytes());
            byte[] mdd = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : mdd) {
                String h = Integer.toHexString(b & 255);
                if (h.length() == 1) sb.append("0");
                sb.append(h);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) { return ""; }
    }
}