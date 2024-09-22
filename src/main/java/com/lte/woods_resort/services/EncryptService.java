package com.lte.woods_resort.services;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptService {
    private static final String clave =  "0123456789101213"; // AES requiere claves de 16, 24 o 32 bytes.
    // clave es un paso usado por AES (Advance Encryption Standar) 
    private static final String vectorInicializacion = "0123456789101213";

    public static String encriptar(String texto) {
        try {
            SecretKeySpec key = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            /*
             * AES / CBC/ PKCS5Padding son servicios de encriptamiento
             */
            IvParameterSpec iv = new IvParameterSpec(vectorInicializacion.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            return Base64.getEncoder().encodeToString(cipher.doFinal(texto.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String desencriptar(String textoEncriptado) {
        try {
            SecretKeySpec key = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(vectorInicializacion.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            return new String(cipher.doFinal(Base64.getDecoder().decode(textoEncriptado)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}