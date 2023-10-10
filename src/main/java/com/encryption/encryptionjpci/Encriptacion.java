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

    private static final int[][] KEY_MATRIX = {{1, 2}, {3, 4}};

    public static String encrypt(String key) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < key.length(); i += 2) {
            char char1 = key.charAt(i);
            int value1 = char1;

            int result1 = (value1 * KEY_MATRIX[0][0]) % 127;
            encrypted.append((char) (result1 + '0'));

            if (i + 1 < key.length()) {
                char char2 = key.charAt(i + 1);
                int value2 = char2;

                int result2 = (value2 * KEY_MATRIX[1][1]) % 127;
                encrypted.append((char) (result2 + '0'));
            }
        }

        return encrypted.toString();
    }

    public static String decrypt(String encryptedKey) {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < encryptedKey.length(); i += 2) {
            char char1 = encryptedKey.charAt(i);
            int value1 = char1 - '0';

            int inverse1 = modInverse(KEY_MATRIX[0][0], 127);
            int result1 = (value1 * inverse1) % 127;
            decrypted.append((char) result1);

            if (i + 1 < encryptedKey.length()) {
                char char2 = encryptedKey.charAt(i + 1);
                int value2 = char2 - '0';

                int inverse2 = modInverse(KEY_MATRIX[1][1], 127);
                int result2 = (value2 * inverse2) % 127;
                decrypted.append((char) result2);
            }
        }

        return decrypted.toString();
    }

    private static int modInverse(int a, int m) {
        int m0 = m, t, q;
        int x0 = 0, x1 = 1;

        if (m == 1) {
            return 0;
        }

        // Euclides
        while (a > 1) {
            q = a / m;
            t = m;
            m = a % m;
            a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }
        //LOS ENTEROS a
        return (x1 + m0) % m0;
    }
}
