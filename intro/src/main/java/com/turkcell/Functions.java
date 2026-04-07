package com.turkcell;

public class Functions {
    public static void main(String[] args) {

        // primitive type => fonksiyonun onu değiştirmesi orjinal değişkeni değiştirmez, çünkü fonksiyon primitive tipin bir kopyasını alır
        String name = "Atilla";

        sayWelcome(name); // name Orhan olarak değişir
        System.out.println(name); // name değişkeni hala "Atilla" değerine sahip

        System.out.println("------------------");

        // reference type => fonksiyonun onu değiştirmesi orjinal değişkeni değiştirebilir, çünkü fonksiyon referans tipin kendisini alır
        int[] numbers = {1, 2, 3, 4, 5};
        sum(numbers);
        System.out.println(numbers[0]); 
        sum(numbers);
    }

    public static void sayWelcome(String name) {
        name = "Orhan";
        System.out.println("Hoş Geldiniz " + name);
    }

    public static void sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Toplam: " + sum);
        numbers[0] = 100;
    }
}
