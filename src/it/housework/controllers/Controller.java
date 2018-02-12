/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.housework.controllers;

import it.housework.models.Model;

/**
 *
 * @author mtank
 */
public abstract class Controller
{   
    /**
     * Set the model to the controller
     * @param model 
     */
    public abstract void setModel(Model model);
}
