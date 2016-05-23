/*
 * This file is part of the chapterjason/Crypt package.
 *
 * (c) Jason Schilling <Jason.Schilling@hotmail.de>
 *
 * For the full copyright and license information, please view the LICENSE.md
 * file that was distributed with this source code.
 */

package com.chapterjason;

public class Main {

    private static String password = "TypeInYourSecurePassword";

    public static void main(String[] args) {
        Main.menu();
    }

    public static void menu() {
        Console.title("Main menu");
        Console.out("[0] - Settings");
        Console.out("[1] - Encrypt");
        Console.out("[2] - Decrypt");
        Console.out("[3] - Exit");
        int choice = Integer.parseInt(Console.in("Please choose:"));
        if (choice == 0) {
            Main.settings();
        } else if (choice == 1) {
            Main.encrypt();
        } else if (choice == 2) {
            Main.decrypt();
        } else if (choice == 3) {
            System.exit(0);
        } else {
            Main.menu();
        }
    }

    public static void settings() {
        Console.title("Settings");
        Console.out("[0] - Main menu");
        Console.out("[1] - Set password");
        Console.out("[2] - View password");
        int choice = Integer.parseInt(Console.in("Please choose:"));
        if (choice == 0) {
            Main.menu();
        } else if (choice == 1) {
            Main.password = Console.in("Insert your password:");
            Main.settings();
        } else if (choice == 2) {
            Console.out("Your password is: \"" + Main.password + "\"");
            Console.in("Press Enter to continue");
            Main.settings();
        } else {
            Main.settings();
        }
    }

    public static void encrypt() {
        Console.title("Encrypt");
        Console.out("[0] - Main menu");
        String choice = Console.in("Please choose or enter your string to encrypt:");
        if (choice.equals("0")) {
            Main.menu();
        } else {
            Console.out("Encrypt: \""+Crypt.Encrypt(choice, Main.password)+"\"");
            Console.in("Press Enter to continue");
            Main.encrypt();
        }
    }

    public static void decrypt() {
        Console.title("Decrypt");
        Console.out("[0] - Main menu");
        String choice = Console.in("Please choose or enter your string to decrypt:");
        if (choice.equals("0")) {
            Main.menu();
        } else {
            Console.out("Decrypt: \""+Crypt.Decrypt(choice, Main.password)+"\"");
            Console.in("Press Enter to continue");
            Main.decrypt();

        }
    }
}
