package ru.mixail.essense;

public class Meter {

    private MeterType meterType;
    private int serialNumber;
    private int currentReading;
    private int previousReading;

    public Meter(MeterType meterType, int serialNumber, int currentReading, int previousReading) {
        this.meterType = meterType;
        this.serialNumber = serialNumber;
        this.currentReading = currentReading;
        this.previousReading = previousReading;
    }


    public Meter(MeterType meterType, int serialNumber) {
        this.meterType = meterType;
        this.serialNumber = serialNumber;
    }

    public MeterType getMeterType() {
        return meterType;
    }

    public void setMeterType(MeterType meterType) {
        this.meterType = meterType;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(int currentReading) {
        this.currentReading = currentReading;
    }

    public int getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(int previousReading) {
        this.previousReading = previousReading;
    }
    @Override
    public String toString() {
        return "Meter{" +
                "meterType=" + meterType +
                ", serialNumber='" + serialNumber + '\'' +
                ", currentReading=" + currentReading +
                ", previousReading=" + previousReading +
                '}';
    }

}
