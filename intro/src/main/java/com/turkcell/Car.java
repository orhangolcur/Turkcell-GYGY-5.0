package com.turkcell;

public class Car {

    public int year; // public => her yerden erişilebilir
    public String model;
    protected String brand; // protected => aynı paket içinden ve alt sınıflardan erişilebilir
    private double price; // private => sadece bu sınıf içinde erişilebilir

    // Encapsulation
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Fiyat negatif olamaz.");
            return;
        } 
        this.price = price;
    }

}
