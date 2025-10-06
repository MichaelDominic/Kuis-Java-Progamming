package com.gudang.controller;

import com.gudang.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SupplierController {

    @FXML
    private TableView<Supplier> tableSupplier;

    @FXML
    private TableColumn<Supplier, String> colKode;

    @FXML
    private TableColumn<Supplier, String> colNamaa;

    @FXML
    private TableColumn<Supplier, String> colAlamat;

    @FXML
    private TableColumn<Supplier, String> colTel;

    @FXML
    private TextField txtKode;

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtAlamat;

    @FXML
    private TextField txtTelepon;

    private final ObservableList<Supplier> dataSupplier = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colKode.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getKode()));
        colNamaa.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNama()));
        colAlamat.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getAlamat()));
        colTel.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTelepon()));

        tableSupplier.setItems(dataSupplier);
    }

    @FXML
    void tambahSupplier(ActionEvent event) {
        String kode = txtKode.getText();
        String nama = txtNama.getText();
        String alamat = txtAlamat.getText();
        String telepon = txtTelepon.getText();

        if (!kode.isEmpty() && !nama.isEmpty() && !alamat.isEmpty() && !telepon.isEmpty()) {
            dataSupplier.add(new Supplier(kode, nama, alamat, telepon));
            clearForm();
        } else {
            showAlert("Semua field harus diisi!");
        }
    }

    @FXML
    void editSupplier(ActionEvent event) {
        Supplier selected = tableSupplier.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setKode(txtKode.getText());
            selected.setNama(txtNama.getText());
            selected.setAlamat(txtAlamat.getText());
            selected.setTelepon(txtTelepon.getText());
            tableSupplier.refresh();
            clearForm();
        } else {
            showAlert("Pilih data yang ingin diedit!");
        }
    }

    @FXML
    void hapusSupplier(ActionEvent event) {
        Supplier selected = tableSupplier.getSelectionModel().getSelectedItem();
        if (selected != null) {
            dataSupplier.remove(selected);
            clearForm();
        } else {
            showAlert("Pilih data yang ingin dihapus!");
        }
    }

    private void clearForm() {
        txtKode.clear();
        txtNama.clear();
        txtAlamat.clear();
        txtTelepon.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(message);
        alert.showAndWait();
    }
}