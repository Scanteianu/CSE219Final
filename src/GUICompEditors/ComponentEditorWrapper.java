/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUICompEditors;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dan
 */
public class ComponentEditorWrapper {
    public ComponentEditorWrapper(){
        
    }
    public void edit(){
       
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ImageEditor.fxml"));
            Scene scene=new Scene(root);
            Stage compStage=new Stage();
            compStage.setScene(scene);
            compStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ComponentEditorWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
