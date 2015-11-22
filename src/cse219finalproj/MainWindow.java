/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse219finalproj;

import GUICompEditors.ComponentEditorWrapper;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.CompType;

/**
 *
 * @author Dan
 */
public class MainWindow implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
     @FXML
    private void insertImg(ActionEvent event) {
          ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.IMAGE);
    }
    @FXML
    private void insertParagraph(ActionEvent event){
        ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.PARAGRAPH);
    }
    @FXML
    private void insertHeading(ActionEvent event){
        ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.HEADING);
    }

    @FXML
    private void insertList(ActionEvent event){
        ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.LIST);
    }
    @FXML
    private void insertSlideshow(ActionEvent event){
        ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.SLIDESHOW);
    }
    @FXML
    private void insertVideo(ActionEvent event){
        ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.VIDEO);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
