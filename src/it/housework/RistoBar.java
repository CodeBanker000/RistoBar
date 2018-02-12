/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.housework;

import it.housework.models.Model;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author mtank
 */
public class RistoBar extends Application
{
    
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        AppManager app = new AppManager("Login", true);
        
        app.displayMainView(primaryStage, "Login", new Model());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
