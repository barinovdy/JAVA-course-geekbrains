//Напишите метод, который составит строку, состоящую из 100
//повторений слова TEST и метод, который запишет эту строку в
//простой текстовый файл, обработайте исключения.

package org.geekbrains.seminar2.cw5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String str = "TEST\n".repeat(100);
        writeFile(str, "index.txt");
    }
    public static void writeFile(String str, String fileName){
          try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
              bw.write(str);
              System.out.println("File written to " + fileName);
              throw new IOException();//Для создания ошибки
          }
          catch (IOException e) {
              FileHandler fh = null;
              try {
                  fh = new FileHandler("error.log", true);
              } catch (IOException ex) {
                  throw new RuntimeException(ex);
              }
              logger.addHandler(fh);
              fh.setFormatter(new SimpleFormatter());
              logger.log(Level.WARNING, "Ошибка записи");
              System.out.println("Error writing to file " + fileName);
          }
    }

}

