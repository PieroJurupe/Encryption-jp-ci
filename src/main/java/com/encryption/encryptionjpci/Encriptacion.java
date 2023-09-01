/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.encryption.encryptionjpci;

/**
 *
 * @author piero
 */
public class Encriptacion {

    public static String encrypt(String key) {
        char[][] keyMatrix = {{1, 2}, {3, 4}};
        StringBuilder encrypted = new StringBuilder();
        int index = 0;
        for (int i = 0; i < key.length(); i += 2) {
            if (i + 1 < key.length()) {
                char char1 = key.charAt(i);
                char char2 = key.charAt(i + 1);
                int value1 = char1;
                int value2 = char2;
                int result1 = (value1 * keyMatrix[0][0] + value2 * keyMatrix[0][1]) % 127;
                int result2 = (value1 * keyMatrix[1][0] + value2 * keyMatrix[1][1]) % 127;
                encrypted.append((char) result1);
                encrypted.append((char) result2);
            } else {
                char char1 = key.charAt(i);
                int value1 = char1;
                int result = (value1 * keyMatrix[0][0]) % 127;
                encrypted.append((char) result);
            }
            index = (index + 1) % 2;
        }
        return encrypted.toString();
    }

    public static String decrypt(String encryptedKey) {
        char[][] keyMatrix = {{1, 2}, {3, 4}};
        StringBuilder decrypted = new StringBuilder();
        int index = 0;
        for (int i = 0; i < encryptedKey.length(); i += 2) {
            if (i + 1 < encryptedKey.length()) {
                char char1 = encryptedKey.charAt(i);
                char char2 = encryptedKey.charAt(i + 1);
                int value1 = char1;
                int value2 = char2;
                int determinant = (keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0] + 127) % 127;
                int inverse = 0;
                for (int j = 0; j < 127; j++) {
                    if ((determinant * j) % 127 == 1) {
                        inverse = j;
                        break;
                    }
                }
                int result1 = (value1 * inverse * keyMatrix[1][1] - value2 * inverse * keyMatrix[0][1] + 127) % 127;
                int result2 = (127 - (value1 * inverse * keyMatrix[1][0] - value2 * inverse * keyMatrix[0][0]) % 127) % 127;
                decrypted.append((char) result1);
                decrypted.append((char) result2);
            } else {
                char char1 = encryptedKey.charAt(i);
                int value1 = char1;
                int determinant = (keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0] + 127) % 127;
                int inverse = 0;
                for (int j = 0; j < 127; j++) {
                    if ((determinant * j) % 127 == 1) {
                        inverse = j;
                        break;
                    }
                }
                int result = (value1 * inverse * keyMatrix[1][1] + 127) % 127;
                decrypted.append((char) result);
            }
            index = (index + 1) % 2;
        }
        return decrypted.toString();
    }
}
