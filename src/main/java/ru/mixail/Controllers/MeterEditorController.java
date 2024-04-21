package ru.mixail.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ru.mixail.app.ConnectBD;
import ru.mixail.essense.Address;
import ru.mixail.essense.MeterType;
import ru.mixail.essense.Street;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MeterEditorController {
    @FXML
    private ComboBox<Address> addressComboBox;
    @FXML
    private ComboBox<MeterType> meterTypeComboBox;
    @FXML
    private TextField serialNumberField;

    @FXML
    void addMeter(ActionEvent event) {

    }
    @FXML
    private void initialize() {
        fillAddressComboBox();
        fillMeterTypeComboBox();
    }

    private void fillAddressComboBox() {
        ObservableList<Address> addresses = FXCollections.observableArrayList();
        // Получение списка адресов из базы данных или откуда-либо еще
        List<Address> addressList = getAddressListFromDatabase();
        // Добавление адресов в ObservableList
        addresses.addAll(addressList);
        // Установка списка адресов в ComboBox
        addressComboBox.setItems(addresses);
    }
    private void fillMeterTypeComboBox() {
        ObservableList<MeterType> meterTypes = FXCollections.observableArrayList();
        // Получение списка адресов из базы данных или откуда-либо еще
        List<MeterType> meterTypeList = getMeterTypeListFromDatabase();
        // Добавление адресов в ObservableList
        meterTypes.addAll(meterTypeList);
        // Установка списка адресов в ComboBox
        meterTypeComboBox.setItems(meterTypes);
    }


    private List<MeterType> getMeterTypeListFromDatabase(){
        List<MeterType> meterTypeList = new ArrayList<>();
        String sql = "SELECT mt.name FROM metertype mt";
        try (Connection connection = ConnectBD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()){
                String nameMeterType = resultSet.getString("name");

                MeterType meterType = new MeterType(nameMeterType);
                meterTypeList.add(meterType);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return meterTypeList;
    }

    private List<Address> getAddressListFromDatabase() {
        List<Address> addressList = new ArrayList<>();
        String sql = "SELECT a.house_number, a.apartment_number, s.name AS street_name " +
                "FROM address a " +
                "JOIN street s ON a.street_id = s.id";
        try (Connection connection = ConnectBD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                // Получаем данные из результата запроса
                String streetName = resultSet.getString("street_name");
                int houseNumber = resultSet.getInt("house_number");
                int apartmentNumber = resultSet.getInt("apartment_number");

                // Создаем объекты Street и Address
                Street street = new Street(streetName);
                Address address = new Address(street, houseNumber, apartmentNumber, null);

                // Добавляем объект Address в список
                addressList.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressList;
    }


}
