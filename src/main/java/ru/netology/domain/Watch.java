package ru.netology.domain;

import java.util.Objects;

public class Watch extends Product {
    private String brand;

    public Watch(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public Watch() {
        super();
    }

    public String getName() {
        return brand;
    }

    public void setName(String name) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Watch watch = (Watch) o;
        return Objects.equals(brand, watch.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand);
    }

    @Override
    public String toString() {
        return "Watch{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
