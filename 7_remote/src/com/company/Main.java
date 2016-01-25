package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        char a;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" '1-5' - каналы; 'q' - выход");
        do {
            a = (char) br.read();
            switch (a) {
                case '1':
                    System.out.println("ОРТ");
                    break;
                case '2':
                    System.out.println("БТ");
                    break;
                case '3':
                    System.out.println("НТВ");
                    break;
                case '4':
                    System.out.println("Спорт");
                    break;
                case '5':
                    System.out.println("Культура");
                    break;
            }
        }
        while (a != 'q');
    }
}
