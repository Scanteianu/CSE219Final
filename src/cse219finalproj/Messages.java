/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse219finalproj;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
}
