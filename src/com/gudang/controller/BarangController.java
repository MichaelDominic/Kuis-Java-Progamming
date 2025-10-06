package com.gudang.controller;

import com.gudang.model.Barang;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BarangController {

    @FXML
    private TableColumn<Barang, String> colNama;

    @FXML
    private TableColumn<Barang, Integer> colJumlah;

    @FXML
    private TableView<Barang> tblBarang;

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtJumlah;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    
    private ObservableList<Barang> barangList = FXCollections.observableArrayList();

   
    @FXML
    void initialize() {
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));

        tblBarang.setItems(barangList);
    }

   
    @FXML
    void tambahBarang(ActionEvent event) {
        String nama = txtNama.getText();
        int jumlah = Integer.parseInt(txtJumlah.getText());

      
        Barang barang = new Barang(nama, jumlah);
        barangList.add(barang);

        
        txtNama.clear();
        txtJumlah.clear();
    }

    
    @FXML
    void editBarang(ActionEvent event) {
        Barang selectedBarang = tblBarang.getSelectionModel().getSelectedItem();

        if (selectedBarang != null) {
            selectedBarang.setNama(txtNama.getText());
            selectedBarang.setJumlah(Integer.parseInt(txtJumlah.getText()));

           
            tblBarang.refresh();

            
            txtNama.clear();
            txtJumlah.clear();
        }
    }

    
    @FXML
    void hapusBarang(ActionEvent event) {
        Barang selectedBarang = tblBarang.getSelectionModel().getSelectedItem();

        if (selectedBarang != null) {
            barangList.remove(selectedBarang);
        }
    }
}