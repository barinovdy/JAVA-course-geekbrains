//Создать список типа ArrayList<String>.
//Поместить в него как строки, так и целые числа.
//Пройти по списку, найти и удалить целые числа.

package org.geekbrains.seminar3.cw5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "Java","42","Python","36"
        ));
        for (String elem : list) {
            try {
                Integer.parseInt(elem);
                list.remove(elem);
            }catch (NumberFormatException ex){

            }
        }

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String elem = iterator.next();
            try {
                Integer.parseInt(elem);
                iterator.remove();
            }catch (NumberFormatException ex){

            }
        }
        System.out.println("list = " + list);
    }
}

//public static void main(String[] args) {
//    ArrayList<String> list = new ArrayList<>(Arrays.asList(
//            "Java","42","Python","36"
//    ));
//    Iterator<String> iterator = list.iterator();
//    while(iterator.hasNext()){
//        String elem = iterator.next();
//        try {
//            Integer.parseInt(elem);
//            iterator.remove();
//        }catch (NumberFormatException ex){
//
//        }
//    }
//    System.out.println("list = " + list);
//}