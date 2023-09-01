/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.encryption.encryptionjpci;

import static com.encryption.encryptionjpci.Encriptacion.decrypt;
import static com.encryption.encryptionjpci.Encriptacion.encrypt;

/**
 *
 * @author piero
 */
public class PruebCryp {

    public static void main(String[] args) {
        String key = "JoSeph  selatraga34 ";
        String encryptedKey = encrypt(key);
        String decryptedKey = decrypt(encryptedKey);

        System.out.println("Original Key: " + key);
        System.out.println("Encrypted Key: " + encryptedKey);
        System.out.println("Decrypted Key: " + decryptedKey);
    }
}
