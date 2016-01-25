package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //
        final int k = 12; //количество месяцев
        int wage = 1000; //начальная зп

        System.out.println("реализация с for:");
        for (int i=1 ; i<=k; i++ )
        {
            wage+= 1000;
            System.out.println("зарплата в " + i +" месяце составляет $" + wage);
        }

        wage = 1000;
        int i = 0;
        System.out.println("Реализация с while:");
        while(i < k)
        {
            wage+=1000;
            i++;
            System.out.println("зарплата в " + i +" месяце составляет $" + wage);

        }

        wage=1000;
        i = 0;
        System.out.println("реализация с  while...do:");
        do
        {
            wage+=1000;
            i++;
            System.out.println("зарплата в " + i +" месяце составляет $" + wage);
        }
        while (i < k);
    }
}
