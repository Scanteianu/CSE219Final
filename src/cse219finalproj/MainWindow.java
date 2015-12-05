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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import model.Page;
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
    private ComboBox pageBox;
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
    @FXML
    private void insertPage(ActionEvent event){
        Page p = new Page();
        CSE219FinalProj.currentSite.getPages().add(p);
        CSE219FinalProj.currentPage=p;
        this.updateInformation();
        CSE219FinalProj.isSaved=false;
    }
    @FXML
    private void removePage(ActionEvent event){
        Page p = new Page();
        CSE219FinalProj.currentSite.getPages().remove(CSE219FinalProj.currentPage);
        if(CSE219FinalProj.currentSite.getPages().isEmpty()){
            pageBox.setVisibleRowCount(1);
            insertPage(null);
        }
        else{
            CSE219FinalProj.currentPage=CSE219FinalProj.currentSite.getPages().get(0);
            pageBox.setVisibleRowCount(CSE219FinalProj.currentSite.getPages().size());
            this.updateInformation();
        
        }
        CSE219FinalProj.isSaved=false;
    }
    @FXML
    private void refresh(ActionEvent event){
        updateInformation();
    }
    @FXML
    private void switchPage(ActionEvent event){
        Page p = new Page();
        p.setTitle((String)pageBox.getValue());
        for(Page p1:CSE219FinalProj.currentSite.getPages()){
            if(p1.getTitle().equals(pageBox.getValue()))
            p=p1;
        }
        //CSE219FinalProj.currentSite.getPages().add(p);
        CSE219FinalProj.currentPage=p;
        this.updateInformation();
    }
    public void updateInformation(){
        ArrayList<String> comptext = new ArrayList <String>();
        for(PageComponent pc: CSE219FinalProj.currentPage.getComponents()){
            comptext.add(pc.toString());
        }
        ObservableList ol1=FXCollections.observableList(comptext);
        list.setItems(ol1);
        layoutBox.setValue(CSE219FinalProj.currentSite.getLayout().getName());
         ArrayList<String> pages = new ArrayList <String>();
        for(Page p: CSE219FinalProj.currentSite.getPages()){
            pages.add(p.getTitle());
        }
        ObservableList ol2=FXCollections.observableList(pages);
        pageBox.setItems(ol2);
        pageBox.setValue(CSE219FinalProj.currentPage.getTitle());
        titleField.setText(CSE219FinalProj.currentPage.getTitle());
        authorField.setText(CSE219FinalProj.currentSite.getAuthor());
        footerArea.setText(CSE219FinalProj.currentPage.getFooter());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CSE219FinalProj.window= this;
        
        
        ObservableList ol2=FXCollections.observableArrayList(Layout.getPossibilities());
        layoutBox.setItems(ol2);
        //titleField.setOnKeyTyped(e->{CSE219FinalProj.currentPage.setTitle(titleField.getText());});
        titleField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                CSE219FinalProj.currentPage.setTitle(titleField.getText());updateInformation();
            }
        });
        //titleField.textProperty().addListener(e->{CSE219FinalProj.currentPage.setTitle(titleField.getText());this.updateInformation();DebugPrint.println("tftc: "+titleField.getText());});
        authorField.setOnKeyTyped(e->{CSE219FinalProj.currentSite.setAuthor(authorField.getText());});
        footerArea.setOnKeyTyped(e->{CSE219FinalProj.currentPage.setFooter(footerArea.getText());});
        layoutBox.setOnAction(e->{CSE219FinalProj.currentSite.setLayout(Layout.getValueByName((String)layoutBox.getValue()));});
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
