/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse219finalproj;

import GUICompEditors.ComponentEditorWrapper;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.CompType;

/**
 *
 * @author Dan
 */
public class MainWindow implements Initializable {
    
    @FXML
    private ListView<String> list;
    
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
        ArrayList<String> text = new ArrayList <String>();
        text.add("Heading: Hello World");
        text.add("Image: penguin.jpg");
        text.add("Paragraph: Welcome to my igloo. I hope you have a good time\n"
                + "Mi casa es su casa, mi comida es su comida\n"
                + "we like to party");
        text.add("Video: Mambo Number 5.mp4");
        text.add("Slideshow: vanilla ice.jpg, shaggy.jpg, "
                + "daddy yankee.jpg");
        text.add("heading: Muppets band");
        text.add("list:\nrobo-boogie\nDr.Teeth\nFloyd Pepper\nAnimal");
        ObservableList ol1=FXCollections.observableList(text);
        list.setItems(ol1);
        
    }    
    
}
