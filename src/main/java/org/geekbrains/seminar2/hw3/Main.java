//3.** Дана json строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"
//Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент
//[фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.


package org.geekbrains.seminar2.hw3;

public class Main {
    public static void main(String[] args) {
        String inputStr = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        stringParse(inputStr);
    }

    private static void stringParse(String inputStr) {
        String korrInputStr = inputStr.replace("[{", "").replace("}]", "").replace("\"", "").replace(",{", "");
        String[] recordArray = korrInputStr.split("}");
        StringBuilder sb = new StringBuilder();
        String[] resultArray = new String[recordArray.length];

        for (int i = 0; i < recordArray.length; i++) {
            String[] recordItems = recordArray[i].split(",");
            int separatorPos = 0;
//            String item = "";
            String value = "";
//            String[] resItems = new String[recordItems.length];
            String[] resValues = new String[recordItems.length];
            for (int j = 0; j < recordItems.length; j++) {
                separatorPos = recordItems[j].indexOf(":");
//                item = recordItems[j].substring(0, separatorPos);
                value = recordItems[j].substring(separatorPos + 1);
//                resItems[j] = item;
                resValues[j] = value;
            }
            sb.append("Студент " + resValues[0] + " получил " + resValues[1] + " по предмету " + resValues[2] + ".");
            resultArray[i] = sb.toString();
            sb.delete(0, sb.length());
            System.out.println(resultArray[i]);
        }
    }
}
