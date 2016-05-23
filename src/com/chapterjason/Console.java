/*
 * This file is part of the chapterjason/Crypt package.
 *
 * (c) Jason Schilling <Jason.Schilling@hotmail.de>
 *
 * For the full copyright and license information, please view the LICENSE.md
 * file that was distributed with this source code.
 */

package com.chapterjason;

import java.util.Scanner;

public class Console {

    /**
     * @param message String
     * @return String
     */
    public static String in(String message) {
        Scanner reader = new Scanner(System.in);
        System.out.println(message);
        String data = reader.nextLine();
        if (data.length() > 0) {
            return data;
        }
        return "-1";
    }

    /**
     * @param message String
     */
    public static void out(String message) {
        System.out.println(message);
    }

    public static void title(String message) {
        Console.out("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Console.out("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Console.out("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Console.out("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Console.out("------------------------------");
        Console.out("\t" + message);
        Console.out("------------------------------");
    }
}
