package ru.mixail.essense;

import java.util.List;

public class Address {
    private Street street;  //Улица
    private int houseNumber; // номер дома
    private int apartmentNumber; // номер квартиры
    private List<Meter> meters; // список приборов учета

    public Address(Street street, int houseNumber, int apartmentNumber, List<Meter> meters) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.meters = meters;
    }
    @Override
    public String toString() {
        return this.street.getName() + ", " + this.houseNumber;
    }

    public List<Meter> getMeters() {
        return meters;
    }

    public void setMeters(List<Meter> meters) {
        this.meters = meters;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
