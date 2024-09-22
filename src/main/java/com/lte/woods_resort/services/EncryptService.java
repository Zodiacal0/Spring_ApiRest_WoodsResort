package com.lte.woods_resort.services;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptService {
    private static final String clave = "ClaveSecreta12345"; // Clave secreta para encriptar
    private static final String vectorInicializacion = "VectorInicial123"; // Vector de inicialización único

    public static String encriptar(String texto) {
        try {
            SecretKeySpec key = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
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

    public static void main(String[] args) {
        String textoOriginal = "1234-5678-9012-3456"; // Número de tarjeta de crédito
        String textoEncriptado = encriptar(textoOriginal);
        System.out.println("Texto encriptado: " + textoEncriptado);

        String textoDesencriptado = desencriptar(textoEncriptado);
        System.out.println("Texto desencriptado: " + textoDesencriptado);
    }

}
