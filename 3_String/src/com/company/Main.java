package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String MyName = "Клименко Алексей Александрович";
        String MyName1 = "клименко алексей александрович";

        System.out.println("Строка:" + MyName);
        System.out.println("Длина строки:" + MyName.length());
        System.out.println("Строка пустая:" + MyName.isEmpty());
        System.out.println("Начинается с символа 'К':" + MyName.startsWith("К"));
        System.out.println("Заканчивается на символ 'й':" + MyName.endsWith("й"));
        System.out.println("Содержит имя 'Алексей':" + MyName.contains("Алексей"));
        System.out.println("Шестой символ в строке:" + MyName.charAt(5));
        System.out.println("Две строки идентичны:" + MyName.equals(MyName1));
        System.out.println("Две строки идентичны(игнорируется регистр):" + MyName.equalsIgnoreCase(MyName1));
       // System.out.println(MyName.getChars(0,30,,3));

    }
}
