/**
 * Sample Skeleton for 'Home.fxml' Controller Class
 */

package it.housework.controllers;

import it.housework.AppManager;
import it.housework.models.Model;
import java.io.IOException;

import it.housework.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomeController extends Controller {

    private static final Logger log = LogManager.getLogger(HomeController.class);
    
    private Model model;
    
    @FXML private Button btnOutlet; // Value injected by FXMLLoader
    @FXML private Button btnArchive; // Value injected by FXMLLoader
    @FXML private Label labelUser; // Value injected by FXMLLoader
    @FXML private Button btnGraph; // Value injected by FXMLLoader
    @FXML private Button btnMenu; // Value injected by FXMLLoader

    @FXML
    void handleOutlet(ActionEvent event) throws IOException 
    {
        AppManager app = new AppManager("Table");
        
        app.display(event, "Gestione Tavoli", new Model());
    }

    @FXML
    void handleMenu(ActionEvent event) {

    }

    @FXML
    void handleGraph(ActionEvent event) {

    }

    @FXML
    void handleArchive(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnOutlet != null : "fx:id=\"btnOutlet\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnArchive != null : "fx:id=\"btnArchive\" was not injected: check your FXML file 'Home.fxml'.";
        assert labelUser != null : "fx:id=\"labelUser\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnGraph != null : "fx:id=\"btnGraph\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnMenu != null : "fx:id=\"btnMenu\" was not injected: check your FXML file 'Home.fxml'.";

    }
    
    /**
     * Set the user name in the Home views
     * 
     * @param user object passed to this controller
     */
    public void setUserName(User user)
    {
    	labelUser.setText(user.getName());
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