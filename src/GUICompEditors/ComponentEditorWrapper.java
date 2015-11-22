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
import model.CompType;
import model.PageComponent;

/**
 *
 * @author Dan
 */
public class ComponentEditorWrapper {
    public ComponentEditorWrapper(){
        
    }
    public void make(CompType type){
       
        String title="";
        try {
            Parent root=null;
            switch(type){
                case IMAGE:
                    root= FXMLLoader.load(getClass().getResource("ImageEditor.fxml"));
                    title="Add Image";
                    break;
                case PARAGRAPH:
                    root= FXMLLoader.load(getClass().getResource("ParagraphEditor.fxml"));
                    title="Add Text";
                    break;
                
                
            }
            
            Scene scene=new Scene(root);
            Stage compStage=new Stage();
            compStage.setScene(scene);
            compStage.show();
            compStage.setTitle(title);
        } catch (IOException ex) {
            Logger.getLogger(ComponentEditorWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void edit(PageComponent comp){
        
    }
}
