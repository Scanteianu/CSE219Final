/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse219finalproj;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Dan
 */
public class Messages {
    public static void ErrorMessage(String message){
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("E-Portfolio Maker");
            alert.setHeaderText("Error:");
            alert.setContentText(message);
            alert.showAndWait();
    }
    public static void infoMessage(String message){
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("E-Portfolio Maker");
            alert.setHeaderText("Notice:");
            alert.setContentText(message);
            alert.showAndWait();
    }
    public static boolean save(String currentFile){
         Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("E-Portfolio Maker");
            alert.setHeaderText("Unsaved Changes:");
            alert.setContentText("Would you like to continue, discarding unsaved changes to "+currentFile+"?");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK))
                return true;
            return false;
    }
}
