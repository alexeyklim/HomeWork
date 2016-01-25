package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
       char a;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        menu();
       do {
            a = (char) br.read();
            switch (a) {
                case '1':menu();break;
                case '2':menu();break;
                case '3':menu();break;
                case '4':menu();break;
            }
        }  while (a != 'q');
    }
    private static void menu() {
        System.out.println("1 - Главное меню");
        System.out.println("2 - Настройки");
        System.out.println("3 - Вызов справки");
        System.out.println("4 - Контакты");
        System.out.println("q - Закрыть");
    }
}
