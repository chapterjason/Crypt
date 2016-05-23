/*
 * This file is part of the chapterjason/Crypt package.
 *
 * (c) Jason Schilling <Jason.Schilling@hotmail.de>
 *
 * For the full copyright and license information, please view the LICENSE.md
 * file that was distributed with this source code.
 */

package com.chapterjason;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Crypt {

    private static String password;
    private static int position = 0;

    public static String hash(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return new String(md.digest());
    }

    private static void reset(String password) {
        try {
            password = Crypt.hash(password);
        } catch (NoSuchAlgorithmException e) {
            Console.out("There are a security issue! You are not able to encrypt/decrypt correctly");
        }

        Crypt.password = password;
        Crypt.position = 0;
    }

    private static char next(){
        if(Crypt.password.length() > Crypt.position){
            Crypt.position = 0;
        }
        return Crypt.password.charAt(Crypt.position++);
    }

    public static String Encrypt(String text, String password) {
        String encrypt = "";
        Crypt.reset(password);

        for (int i = 0; i < text.length(); i++) {
            int encryptDecimal = ((int) text.charAt(i)) + ((int) Crypt.next());
            encrypt += Character.toString((char)encryptDecimal);
        }

        return new String(Base64.getEncoder().encode(encrypt.getBytes()));
    }

    public static String Decrypt(String text, String password) {
        text = new String(Base64.getDecoder().decode(text.getBytes()));

        String decrypt = "";
        Crypt.reset(password);

        for (int i = 0; i < text.length(); i++) {
            int encryptDecimal = ((int) text.charAt(i)) - ((int) Crypt.next());
            decrypt += Character.toString((char)encryptDecimal);
        }

        return decrypt;
    }

}
