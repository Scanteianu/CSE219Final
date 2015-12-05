/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse219finalproj;

import GUICompEditors.ComponentEditorWrapper;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.CompType;
import model.Layout;
import model.PageComponent;

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
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextArea footerArea;
    @FXML
    private ComboBox layoutBox;
    @FXML 
    private ComboBox colorBox;
    @FXML 
    private ComboBox fontBox;
    @FXML
    private WebView webview;
    
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
    public void updateInformation(){
        ArrayList<String> comptext = new ArrayList <String>();
        for(PageComponent pc: CSE219FinalProj.currentPage.getComponents()){
            comptext.add(pc.toString());
        }
        ObservableList ol1=FXCollections.observableList(comptext);
        list.setItems(ol1);
        layoutBox.setValue(CSE219FinalProj.currentSite.getLayout().getName());
        titleField.setText(CSE219FinalProj.currentPage.getTitle());
        authorField.setText(CSE219FinalProj.currentSite.getAuthor());
        footerArea.setText(CSE219FinalProj.currentPage.getFooter());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CSE219FinalProj.window= this;
        
        
        ObservableList ol2=FXCollections.observableArrayList(Layout.getPossibilities());
        layoutBox.setItems(ol2);
        
        
        updateInformation();
        final WebEngine webEngine = webview.getEngine();
        //String pageAddress = CSE219FinalProj.class.getResource("../../FreeGuitarWebsite/pages/home.html").toExternalForm();  
        File file =  new File("FreeGuitarWebsite/pages/home.html");
        try {
            webEngine.load(file.toURI().toURL().toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
