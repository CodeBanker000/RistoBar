/**
 * 
 */
package it.housework.controllers;

import it.housework.AppManager;
import it.housework.models.Model;
import it.housework.models.Outlet;
import java.io.IOException;

/**
 * Sample Skeleton for 'Outlet.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TableController extends Controller 
{
    
    private static final Logger log = LogManager.getLogger(HomeController.class);

    private Model model;

    @FXML private Button btnLocals; 
    @FXML private Button btnOutlet; 
    @FXML private ComboBox<?> boxLocals;
    @FXML private ComboBox<Outlet> boxOutlet;

    @FXML
    void handleLocals(ActionEvent event) 
    {
        
    }

    @FXML
    void handleOutlet(ActionEvent event) throws IOException 
    {
    	AppManager app = new AppManager("Outlet");
        
        app.displayBox("Gestione Outlet", new Model());
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnLocals != null : "fx:id=\"btnLocals\" was not injected: check your FXML file 'Outlet.fxml'.";
        assert btnOutlet != null : "fx:id=\"btnOutlet\" was not injected: check your FXML file 'Outlet.fxml'.";
        assert boxLocals != null : "fx:id=\"boxLocals\" was not injected: check your FXML file 'Outlet.fxml'.";
        assert boxOutlet != null : "fx:id=\"boxOutlet\" was not injected: check your FXML file 'Outlet.fxml'.";

    }
    
    public void fillBoxOutlet(Outlet list)
    {
        boxOutlet.getItems().addAll(list);
    }
    
    /**
     * Set the model to the controller
     * 
     * @param model Object model passed to the controller
     */
    @Override
    public void setModel(Model model) 
    {
        this.model = model;
    }
}
