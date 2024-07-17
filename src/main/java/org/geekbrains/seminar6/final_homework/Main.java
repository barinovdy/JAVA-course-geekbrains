package org.geekbrains.seminar6.final_homework;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> listFilter = new HashMap<>();
        Map<String, List<String>> settedFilterList = new HashMap<>();
        listFilter = Notebook.getFieldList();

        System.out.print("Введите желаемое количество ноутбуков для базы данных: ");
        int amountNotebooks = scan.nextInt();
        Set<Notebook> notebooks = fillNotebookHash(amountNotebooks);
        System.out.println("Множество из " + amountNotebooks +" ноутбуков для базы данных сгенерировано автоматически.");


        int choice = 0;
        boolean flag = true;
        while(flag){
            choice = userChoice();
            if (choice == 1) {
                showAllNotebooks(notebooks);
            }
            else if (choice == 2) {
                System.out.println("Доступные критерии для фильтрации:");
                showFilterCriteries(listFilter);
            }
            else if (choice == 3) {
                System.out.println("Выбор критериев фильтрации");
                settedFilterList = setFilterCriteries(listFilter);
            }
            else  if (choice == 4) {
                System.out.println("Выполняю фильтрацию списка ноутбуков согласно критериям");
                filterNotebooks(notebooks, settedFilterList);
            }
            else if (choice == 5) {
                System.out.println("Работа с базой данных ноутбуков завершена");
                flag = false;
            }
            else {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public static int userChoice(){
        System.out.println("-------------------------------\n" +
                "Выберите необходимое действие: \n" +
                "1. Показать все ноутбуки из базы данных\n" +
                "2. Просмотр доступных критериев для фильтрации\n" +
                "3. Выбор критериев для фильтрации ноутбуков\n" +
                "4. Отфильтровать ноутбуки\n" +
                "5. Завершить работу\n");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        return n;
    }

    private static void showAllNotebooks(Set<Notebook> notebooks) {
        if (!notebooks.isEmpty()) {
            System.out.println("Список из " + notebooks.size() + " ноутбуков:");
            for (Notebook notebook : notebooks) {
                System.out.println(notebook);
            }
        }
        else {
            System.out.println("Ноутбуков в базе данных не найдено");
        }
    }

    private static void showFilterCriteries(Map<String, String> listFilter){
        ArrayList<String> values = new ArrayList<>(listFilter.values());
        for (int i = 1; i <= listFilter.size() ; i++) {
            System.out.println(i + ". " + values.get(i - 1));
        }
    }

    private static Map<String, List<String>> setFilterCriteries(Map<String, String> listFilter){
        Map<String, List<String>> settedFilterList = new HashMap<>();
        ArrayList<String> keys = new ArrayList<>(listFilter.keySet());
        ArrayList<String> values = new ArrayList<>(listFilter.values());
        List<String> filterParameter = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int n = 0;

        boolean flag = true;
        while(flag) {
            System.out.println("Выберите критерий из списка (введите цифру):");
            for (int i = 1; i <= listFilter.size() ; i++) {
                System.out.println(i + ". " + values.get(i - 1));
            }
            System.out.println("Для завершения выбора введите 0");
            n = scan.nextInt();

            if (n == 0) {
                System.out.println("Выбор критериев завершен");
                flag = false;
            }
            else if (n >= 1 && n <= listFilter.size()) {
                if (keys.get(n - 1).equals("typeOS") || keys.get(n - 1).equals("color")){
                    filterParameter = getStringCriterion();
                }
                else if (keys.get(n - 1).equals("amountRAM") || keys.get(n - 1).equals("amountHDD") || keys.get(n - 1).equals("price")){
                    filterParameter = getValueCriterion();
                }
                settedFilterList.put(keys.get(n - 1), filterParameter);
                System.out.println(settedFilterList);
            }
            else {
                System.out.println("Ошибка. Некорректный ввод.");
            }
        }
        return settedFilterList;
    }

    public static List<String> getStringCriterion(){
        List<String> filterParameter = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите значение критерия:");
        String crit = scan.next();

        filterParameter.add("0");
        filterParameter.add(crit);
        return filterParameter;
    }

    public static List<String> getValueCriterion(){
        List<String> filterParameter = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        boolean flag = false;
        while (!flag) {
            filterParameter.clear();
            System.out.print("\n Выберите тип критерия:\n" +
                    "1. Фиксированное значение\n" +
                    "2. Минимальное значение\n" +
                    "3. Максимальное значение\n" +
                    "4. Диапазон значений\n");
            int critType = scan.nextInt();
            if (critType == 1 || critType == 2 || critType == 3 || critType == 4) {
                flag = true;
                filterParameter.add(String.valueOf(critType - 1));
                if (critType == 4) {
                    System.out.print("Введите нижнее значение диапазона критерия:");
                    String critLower = scan.next();
                    if (!isNumber(critLower)) {
                        System.out.println("Ошибка. Введено не числовое значение.");
                        flag = false;
                    }
                    System.out.print("Введите верхнее значение диапазона критерия:");
                    String critHigher = scan.next();
                    if (!isNumber(critHigher)) {
                        System.out.println("Ошибка. Введено не числовое значение.");
                        flag = false;
                    }
                    if (Integer.parseInt(critLower) < Integer.parseInt(critHigher)) {
                        filterParameter.add(critLower);
                        filterParameter.add(critHigher);
                    }
                    else {
                        System.out.println("Ошибка. Нижнее значение диапазона должно быть меньше верхнего.");
                        flag = false;
                    }
                }
                else {
                    System.out.print("Введите значение критерия:");
                    String crit = scan.next();
                    if (!isNumber(crit)) {
                        System.out.println("Ошибка. Введено не числовое значение.");
                        flag = false;
                    }
                    filterParameter.add(crit);
                }
            }
            else {
                System.out.println("Ошибка выбора. Попробуйте еще раз.");
            }
        }
        return filterParameter;
    }

    private static boolean isNumber(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, List<String>> settedFilterList){
        Set<Notebook> filteredNotebooks = new HashSet<>(notebooks);
        ArrayList<String> keys = new ArrayList<>(settedFilterList.keySet());

        Iterator<Notebook> strIter = filteredNotebooks.iterator();

        if (!settedFilterList.isEmpty()) {
            while (strIter.hasNext()) {
                Notebook filteredNotebook = strIter.next();

                for (String key : keys) {
                    //System.out.println(key);
                    List<String> filterParameter = settedFilterList.get(key);
                    if (!isValid(filteredNotebook, filterParameter, key)) {
                        strIter.remove();
                        break;
                    }
                }
            }
        }
        else {
            System.out.println("Отсутствуют критерии для фильтрации. Выберите критерии.");
        }
        showAllNotebooks(filteredNotebooks);
        return  filteredNotebooks;
    }

    public static boolean isValid(Notebook notebook, List<String> filterParameter, String key) {
        if (filterParameter.getFirst().equals("0")){
            if (key.equals("typeOS")) {
                if (notebook.getTypeOS().equalsIgnoreCase(filterParameter.getLast())) {
                    return true;
                }
            }
            else if (key.equals("color")) {
                if (notebook.getColor().equalsIgnoreCase(filterParameter.getLast())) {
                    return true;
                }
            }
            else if (key.equals("amountRAM")) {
                if (notebook.getAmountRAM() == Integer.parseInt(filterParameter.getLast())) {
                    return true;
                }
            }
            else if (key.equals("amountHDD")) {
                if (notebook.getAmountHDD() == Integer.parseInt(filterParameter.getLast())) {
                    return true;
                }
            }
            else if (key.equals("price")) {
                if (notebook.getPrice() == Integer.parseInt(filterParameter.getLast())) {
                    return true;
                }
            }
            else {
                return false;
            }
        }

        else if (filterParameter.getFirst().equals("1")){
            if (key.equals("amountRAM")) {
                if (notebook.getAmountRAM() >= Integer.parseInt(filterParameter.getLast())) {
                    return true;
                }
            }
            else if (key.equals("amountHDD")) {
                if (notebook.getAmountHDD() >= Integer.parseInt(filterParameter.getLast())) {
                    return true;
                }
            }
            else if (key.equals("price")) {
                if (notebook.getPrice() >= Integer.parseInt(filterParameter.getLast())) {
                    return true;
                }
            }
            else {
                return false;
            }
        }

        else if (filterParameter.getFirst().equals("2")){
            if (key.equals("amountRAM")) {
                if (notebook.getAmountRAM() <= Integer.parseInt(filterParameter.getLast())) {
                    return true;
                }
            }
            else if (key.equals("amountHDD")) {
                if (notebook.getAmountHDD() <= Integer.parseInt(filterParameter.getLast())) {
                    return true;
                }
            }
            else if (key.equals("price")) {
                if (notebook.getPrice() <= Integer.parseInt(filterParameter.getLast())) {
                    return true;
                }
            }
            else {
                return false;
            }
        }

        else if (filterParameter.getFirst().equals("3")){
            if (key.equals("amountRAM")) {
                if (notebook.getAmountRAM() >= Integer.parseInt(filterParameter.get(1)) && notebook.getAmountRAM() <= Integer.parseInt(filterParameter.get(2))) {
                    return true;
                }
            }
            else if (key.equals("amountHDD")) {
                if (notebook.getAmountHDD() >= Integer.parseInt(filterParameter.get(1)) && notebook.getAmountHDD() <= Integer.parseInt(filterParameter.get(2))) {
                    return true;
                }
            }
            else if (key.equals("price")) {
                if (notebook.getPrice() >= Integer.parseInt(filterParameter.get(1)) && notebook.getPrice() <= Integer.parseInt(filterParameter.get(2))) {
                    return true;
                }
            }
            else {
                return false;
            }
        }
        return false;
    }

    public static Set<Notebook> fillNotebookHash(int amountNotebook){
        Set<Notebook> notebooks = new HashSet<>();

        String name = "";
        String model = "";
        String typeOS = "";
        int amountRAM = 0;
        int amountHDD = 0;
        String color = "";
        int price = 0;

        List<String> listModel = new ArrayList<>(Arrays.asList("ASUS", "Lenovo", "HP", "Dell"));
        List<String> listTypeOS = new ArrayList<>(Arrays.asList("Windows10", "Windows11", "MacOS"));
        List<Integer> listAmountRAM = new ArrayList<>(Arrays.asList(8, 16, 32, 64));
        List<Integer> listAmountHDD = new ArrayList<>(Arrays.asList(512, 1024, 2048, 4086));
        List<String> listColor = new ArrayList<>(Arrays.asList("Black", "Silver", "White", "Grey"));

        for (int i = 1; i <= amountNotebook; i++) {
            name = "ID" + i;
            model = listModel.get((int)(Math.random() * listModel.size()));
            typeOS = listTypeOS.get((int)(Math.random() * listTypeOS.size()));
            amountRAM = listAmountRAM.get((int)(Math.random() * listAmountRAM.size()));
            amountHDD = listAmountHDD.get((int)(Math.random() * listAmountHDD.size()));
            color = listColor.get((int)(Math.random() * listColor.size()));
            price = (int)(Math.random() * 50000 + 50000);

            notebooks.add(new Notebook(name, model, typeOS, amountRAM, amountHDD, color, price));
        }
        return notebooks;
    }
}
