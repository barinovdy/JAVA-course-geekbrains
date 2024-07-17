////Дано четное число N (>0) и символы c1 и c2.
////Написать метод, который вернет строку длины N, которая
////состоит из чередующихся символов c1 и c2, начиная с c1.
//
////Решение через stringBuilder
//
//package org.geekbrains.seminar2.cw2;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        String c1 = "c1";
//        String c2 = "c2";
//        String s = getStrOfChars(n, c1, c2);
//        System.out.println("s = " + s);
//        System.out.println("s.length = " + s.length());
//    }
//
//    private static String getStrOfChars(int n, String c1, String c2) throws Exception {
//        if ((n <= 0) || (n % 2 != 0)) {
//            throw new Exception("Не валидное значение n");
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n / 2; i++) {
////            if (i % 2 == 0) {
////                sb.append(c1);
////            }
////            else {
////                sb.append(c2);
////            }
//            sb.append(c1).append(c2);
//        }
//        return sb.toString();
//    }
//}
