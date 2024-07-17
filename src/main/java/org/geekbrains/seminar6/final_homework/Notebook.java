package org.geekbrains.seminar6.final_homework;

import java.util.*;

public class Notebook {
    private String name;
    private int price;
    private int amountRAM;
    private String model;
    private String typeOS;
    private int amountHDD;
    private String color;

    public Notebook(String name, String model, String typeOS, int amountRAM, int amountHDD, String color, int price){
        this.name = name;
        this.model = model;
        this.typeOS = typeOS;
        this.amountRAM = amountRAM;
        this.amountHDD = amountHDD;
        this.color = color;
        this.price = price;
    }

//    public static final List<String> listModel = new ArrayList<>(Arrays.asList("ASUS", "Lenovo", "HP", "Dell"));
//    public static final List<String> listTypeOS = new ArrayList<>(Arrays.asList("Windows10", "Windows11", "MacOS"));
//    public static final List<Integer> listAmountRAM = new ArrayList<>(Arrays.asList(8, 16, 32, 64));
//    public static final List<Integer> listAmountHDD = new ArrayList<>(Arrays.asList(512, 1024, 2048, 4086));
//    public static final List<String> listColor = new ArrayList<>(Arrays.asList("Black", "Silver", "White", "Grey"));

    public static Map<String, String> getFieldList(){
        Map<String, String> fieldList = new HashMap();
        fieldList.put("model", "Модель");
        fieldList.put("typeOS", "Тип ОС");
        fieldList.put("amountRAM", "Объем ОЗУ, Гб");
        fieldList.put("amountHDD", "Объем ЖД, Гб");
        fieldList.put("color", "Цвет");
        fieldList.put("price", "Цена, руб");
        return fieldList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmountRAM() {
        return amountRAM;
    }

    public void setAmountRAM(int amountRAM) {
        this.amountRAM = amountRAM;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTypeOS() {
        return typeOS;
    }

    public void setTypeOS(String typeOS) {
        this.typeOS = typeOS;
    }

    public int getAmountHDD() {
        return amountHDD;
    }

    public void setAmountHDD(int amountHDD) {
        this.amountHDD = amountHDD;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Ноутбук: %s, модель: %s, тип ОС: %s, объем ОЗУ: %d Гб, объем ЖД: %d Гб, цвет: %s, цена: %d руб.", name, model, typeOS, amountRAM, amountHDD, color, price);
    }
}
