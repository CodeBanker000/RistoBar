/**
 * 
 */
package it.housework.controllers;

/**
 * Sample Skeleton for 'Outlet.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OutletController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnDeleteOutlet"
    private Button btnDeleteOutlet; // Value injected by FXMLLoader

    @FXML // fx:id="btnClose"
    private Button btnClose; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateOutlet"
    private Button btnUpdateOutlet; // Value injected by FXMLLoader

    @FXML // fx:id="btnCreateOutlet"
    private Button btnCreateOutlet; // Value injected by FXMLLoader

    @FXML // fx:id="btnHideOutlet"
    private Button btnHideOutlet; // Value injected by FXMLLoader

    @FXML
    void handleCreateOutlet(ActionEvent event) {

    }

    @FXML
    void handleUpdateOutlate(ActionEvent event) {

    }

    @FXML
    void handleHideOutlet(ActionEvent event) {

    }

    @FXML
    void handleDeleteOutlet(ActionEvent event) {

    }

    @FXML
    void handleClose(ActionEvent event) 
    {
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.close();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnDeleteOutlet != null : "fx:id=\"btnDeleteOutlet\" was not injected: check your FXML file 'Outlet.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'Outlet.fxml'.";
        assert btnUpdateOutlet != null : "fx:id=\"btnUpdateOutlet\" was not injected: check your FXML file 'Outlet.fxml'.";
        assert btnCreateOutlet != null : "fx:id=\"btnCreateOutlet\" was not injected: check your FXML file 'Outlet.fxml'.";
        assert btnHideOutlet != null : "fx:id=\"btnHideOutlet\" was not injected: check your FXML file 'Outlet.fxml'.";

    }
}