//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
//используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//Пример:
//Строка sql-запроса: select * from students where
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//Результат: select * from students where name='Ivanov' and country='Russia' and city='Moscow'

package org.geekbrains.seminar2.hw1;

public class main {
    public static void main(String[] args) {
        String QUERY = "select * from students where ";
        String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        Answer ans = new Answer();
        System.out.println(ans.answer(QUERY, PARAMS));
    }
}
class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
        StringBuilder sb = new StringBuilder();
        sb.append(QUERY);
        String line = PARAMS.replace("{", "").replace("}", "").replace("\"", "").replace(" ", "");
        String[] pairs = line.split(",");
        String index = "";
        String value = "";
        int dividPos = 0;
        for (int i = 0; i < pairs.length; i++) {
            dividPos = pairs[i].indexOf(":");
            index = pairs[i].substring(0, dividPos);
            value = pairs[i].substring(dividPos + 1);
            if (!value.equals("null")) {
                sb.append(index + "='" + value + "'" + " and ");
            }
        }
        sb.delete(sb.length() - 5, sb.length());
        return sb;
    }
}

