package ru.mixail.essense;

import java.util.List;

public class MeterHistoryReading {
    private Meter meter;
    private List<Integer> readings;

    public MeterHistoryReading(Meter meter, List<Integer> readings) {
        this.meter = meter;
        this.readings = readings;
    }

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }

    public List<Integer> getReadings() {
        return readings;
    }

    public void setReadings(List<Integer> readings) {
        this.readings = readings;
    }
}
