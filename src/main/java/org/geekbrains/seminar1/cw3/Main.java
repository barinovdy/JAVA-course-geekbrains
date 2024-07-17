// Дана строка. Поменять местами ее половины.

package org.geekbrains.seminar1.cw3;

public class Main {
    public static void main(String[] args) {
        String str = "qweasd";
        String result = str.substring(str.length() / 2) +
                str.substring(0, str.length() / 2);
        System.out.println("result= " + result);
    }
}
