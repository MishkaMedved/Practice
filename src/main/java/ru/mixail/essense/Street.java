package ru.mixail.essense;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Street {
    private final StringProperty name;

    public Street(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
