/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.housework;

import it.housework.controllers.Controller;
import it.housework.models.Model;
import java.io.IOException;
import javafx.event.ActionEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Handle the Views, the Controllers and the Models
 * 
 * @author Matteo Tancredi <matteotank@gmail.com>
 * @version 1.0
 */
public class AppManager
{
    
    /** Logger Object */
    private static final Logger log = LogManager.getLogger(AppManager.class);
    
    /** Object FXMLloader */
    private final FXMLLoader loader;
    
    /** Object controller */
    private final Controller controller;
    
    /** Object Parent layout scene */
    private Parent layout;
    
    /**
     * Construct of the class
     * 
     * @param view     name of view
     * @param flagPos  position of the caller method: true for the main
     */
    public AppManager(String view, boolean flagPos)
    {
            this.loader = new FXMLLoader();
            setViewLoader(view, flagPos);
            
            setLayout();
            
            this.controller = loader.getController();
    }
    
    /**
     * Open the window, set the model and the title of the stage
     * 
     * @param window pass the stage from the main method
     * @param title  set the title
     * @param model  pass the model for the controller
     */
    public void displayMainView(Stage window, String title, Model model)  
    {
            controller.setModel(model);
            //scene.getStylesheets().add(getClass().getResource("./styles/application.css").toExternalForm());
            Scene scene = new Scene(this.layout);
            window.setScene(scene);
            window.setTitle(String.format("RistoBar v1.0 :: %S", title));
            window.show();
    }
    
    /**
     * Show the scene to the stage, set the model and the title of the stage.
     * The stage is get from the node of the passed event source
     * 
     * @param event pass the event to get his window parent
     * @param title set the title
     * @param model pass the model for the controller
     */
    public void display(ActionEvent event, String title, Model model)  
    {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //scene.getStylesheets().add(getClass().getResource("./styles/application.css").toExternalForm());
        controller.setModel(model);
        Scene scene = new Scene(this.layout);
        window.hide();
        window.setScene(scene);
        window.setTitle(String.format("RistoBar v1.0 :: %s", title));
        window.show();
    }

    /**
     * Open new window, set the model and the title of the stage.
     * 
     * @param title set the title
     * @param model pass the model for the controller
     */
    public void displayBox(String title, Model model)  
    {
        Stage window = new Stage();
        
        controller.setModel(model);
        Scene scene = new Scene(this.layout);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        window.setTitle(String.format("RistoBar v1.0 :: %s", title));
        window.showAndWait();
    }
    
    /**
     * Get the controller setted
     * 
     * @return controller
     */
    public Controller getController()
    {
        return this.controller;
    }
    
    /**
     * load the layout of the scene
     */
    private void setLayout()
    {
        try {
            this.layout = (Parent) loader.load();
        } catch (IOException e) {
            log.fatal(e);
            
        }
    }
    
    /**
     * Set the location of the view with the extension,
     * passing the name of view and the position of the caller
     * 
     * @param viewName name of the view to call
     * @param flagPos  is true is the caller is the main method
     */
    private void setViewLoader(String viewName, boolean flagPos)
    {
        String path;
        
        if (flagPos) {
            path = String.format("/it/housework/views/%s.fxml", viewName);
        } else {
            path = String.format("/it/housework/views/%s.fxml", viewName);
        }
        
        this.loader.setLocation(getClass().getResource(path));
    }
    
}