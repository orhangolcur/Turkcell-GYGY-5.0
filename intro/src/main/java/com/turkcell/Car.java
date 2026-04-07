package com.turkcell;

public class Car extends Vehicle {

    private boolean hasSunroof;
    private String[] specs;
    

    // Constructor => nesne oluşturulurken çağrılır, nesnenin başlangıç durumunu belirler
    // Yazmazsak default constructor (parametresiz) oluşturulur
    public Car(boolean hasSunroof, String brand, int year) {
        this.hasSunroof = hasSunroof;
        super.setBrand(brand); // super anahtar kelimesi, üst sınıfın (Vehicle) setBrand metodunu çağırır
        super.setYear(year);
    }

    // Encapsulation => dışarıdan manipülasyona kapalı
    public String[] getSpecs() {
        return specs.clone();
    }
    public void setSpecs(String[] specs) {
        this.specs = specs.clone();
    }

    // clone() metodu, nesnenin bir kopyasını oluşturur ve döner. Bu sayede, dışarıdan gelen array'in referansını değil, kopyasını kullanarak encapsulation sağlanır.

    

    

}
