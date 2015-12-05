/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUICompEditors;

import cse219finalproj.CSE219FinalProj;
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
        CSE219FinalProj.isEdit=false;
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
                case HEADING:
                    root= FXMLLoader.load(getClass().getResource("HeadingEditor.fxml"));
                    title="Add Heading";
                    break;
                case VIDEO:
                    root= FXMLLoader.load(getClass().getResource("VideoEditor.fxml"));
                    title="Add Video";
                    break;
                case LIST:
                    root= FXMLLoader.load(getClass().getResource("ListEditor.fxml"));
                    title="Add List";
                    break;
                case SLIDESHOW:
                    root= FXMLLoader.load(getClass().getResource("SlideShowEditor.fxml"));
                    title="Add Slide Show";
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
        String title="";
        CSE219FinalProj.isEdit=true;
        try {
            Parent root=null;
            switch(comp.getType()){
                case IMAGE:
                    root= FXMLLoader.load(getClass().getResource("ImageEditor.fxml"));
                    title="Edit Image";
                    break;
                case PARAGRAPH:
                    root= FXMLLoader.load(getClass().getResource("ParagraphEditor.fxml"));
                    title="Edit Text";
                    break;
                case HEADING:
                    root= FXMLLoader.load(getClass().getResource("HeadingEditor.fxml"));
                    title="Edit Heading";
                    break;
                case VIDEO:
                    root= FXMLLoader.load(getClass().getResource("VideoEditor.fxml"));
                    title="Edit Video";
                    break;
                case LIST:
                    root= FXMLLoader.load(getClass().getResource("ListEditor.fxml"));
                    title="Edit List";
                    break;
                case SLIDESHOW:
                    root= FXMLLoader.load(getClass().getResource("SlideShowEditor.fxml"));
                    title="Edit Slide Show";
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
}
