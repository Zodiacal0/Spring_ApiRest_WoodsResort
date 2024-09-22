package com.lte.woods_resort.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordEncrypt {
    
    public static String encryptPassword(String password) {
        try {
            return BCrypt.withDefaults().hashToString(12, password.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }

    public static boolean verifyPassword(String plainPassword, String encryptedPassword) {
        try {
            BCrypt.Result result = BCrypt.verifyer().verify(plainPassword.toCharArray(), encryptedPassword);
            return result.verified;
        } catch (Exception e) {
            throw new RuntimeException("Error al verificar la contraseña", e);
        }
    }
}
