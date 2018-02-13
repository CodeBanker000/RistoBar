/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

package it.housework.controllers;

import it.housework.AppManager;
import it.housework.models.Model;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.housework.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginController extends Controller {
    
    private static final Logger log = LogManager.getLogger(LoginController.class);
    
    private Model model;
	
    @FXML private TextField txtFldUser;
    @FXML private Text txtSms;
    @FXML private Button btnSubmit;
    @FXML private PasswordField pwdFldPass;
    
    @FXML
    void f50606(ActionEvent event) {}

    @FXML
    void handleSubmit(ActionEvent event) throws IOException
    {
    	String user = txtFldUser.getText();
        String pass = pwdFldPass.getText();
        
        User usr = model.findUser(user, pass);
        
        if (usr == null) {
            log.info("L'utente ha provato ad entrare.");
            txtSms.setText("name or pass is invalid.");
        } else {
            log.info("L'utente logged in.");
            
            AppManager app = new AppManager("Home");
            
            app.display(event, "Home", new Model());
            
            HomeController controller = (HomeController) app.getController();
            
            controller.setUserName(usr);
        }
    }

    @FXML 
    void initialize() 
    {
        assert txtFldUser != null : "fx:id=\"txtFldUser\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtSms != null : "fx:id=\"txtSms\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnSubmit != null : "fx:id=\"btnSubmit\" was not injected: check your FXML file 'Login.fxml'.";
        assert pwdFldPass != null : "fx:id=\"pwdFldPass\" was not injected: check your FXML file 'Login.fxml'.";
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