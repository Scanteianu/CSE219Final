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
import javafx.stage.FileChooser;
import model.CompType;
import model.Layout;
import model.Page;
import model.PageComponent;
import model.SiteColor;
import model.SiteFont;

/**
 *
 * @author Dan
 */
public class MainWindow implements Initializable {
    private boolean titleIsEdit=false;
    @FXML
    private ListView<String> list;
    
    @FXML
    private Label label;
    @FXML
    private Label bannerLabel;
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
    private void selectBanner(ActionEvent event) {
        FileChooser jfc= new FileChooser();
        try{
        File banner=jfc.showOpenDialog(null).getAbsoluteFile();
        if(!banner.getName().toLowerCase().endsWith(".jpg")&&!banner.getName().toLowerCase().endsWith(".jpeg")&&!banner.getName().toLowerCase().endsWith(".png")&&!banner.getName().toLowerCase().endsWith(".bmp")&&!banner.getName().toLowerCase().endsWith(".gif"))
        {
            Messages.ErrorMessage("That's an invalid file type. We support JPEGs, GIFs,PNGs, and BMPs.");
            return;
        }
            CSE219FinalProj.currentPage.setBannerFilePath(banner.getPath());
            CSE219FinalProj.currentPage.setBannerFilename(banner.getName());
            updateInformation();
        }
        catch(NullPointerException e){
            
        }
        
        
    }
    @FXML
    private void removeComp(ActionEvent event) {
        if(list.getSelectionModel().getSelectedIndex()!=-1){
        CSE219FinalProj.currentPage.getComponents().remove(list.getSelectionModel().getSelectedIndex());
        this.updateInformation();}
        else{
            Messages.ErrorMessage("A component must be selected for deletion.");
        }
    }
    @FXML
    private void editComp(ActionEvent event) {
        if(list.getSelectionModel().getSelectedIndex()!=-1){
        CSE219FinalProj.currentComponent=CSE219FinalProj.currentPage.getComponents().get(list.getSelectionModel().getSelectedIndex());
        ComponentEditorWrapper cew=new ComponentEditorWrapper();
        cew.edit(CSE219FinalProj.currentComponent);
        this.updateInformation();}
        else{
            Messages.ErrorMessage("A component must be selected for editing.");
        }
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
        titleIsEdit=true;
        Page p = new Page();
        CSE219FinalProj.currentSite.getPages().remove(CSE219FinalProj.currentPage);
        if(CSE219FinalProj.currentSite.getPages().isEmpty()){
            //pageBox.setVisibleRowCount(1);
            insertPage(null);
        }
        else{
            CSE219FinalProj.currentPage=CSE219FinalProj.currentSite.getPages().get(0);
            //pageBox.setVisibleRowCount(CSE219FinalProj.currentSite.getPages().size());
            this.updateInformation();
        
        }
        CSE219FinalProj.isSaved=false;
        titleIsEdit=false;
    }
    @FXML
    private void refresh(ActionEvent event){
        updateInformation();
    }
    @FXML
    private void switchPage(ActionEvent event){
        if(!titleIsEdit)//reentrantLock type thing
        {Page p = new Page();
        DebugPrint.println("SwitchPage");
        p.setTitle((String)pageBox.getValue());
        for(Page p1:CSE219FinalProj.currentSite.getPages()){
            if(p1.getTitle().equals(pageBox.getValue()))
            p=p1;
        }
        //CSE219FinalProj.currentSite.getPages().add(p);
        CSE219FinalProj.currentPage=p;
        this.updateInformation();
        }
    }
    public void updateInformation(){
        ArrayList<String> comptext = new ArrayList <String>();
        for(PageComponent pc: CSE219FinalProj.currentPage.getComponents()){
            comptext.add(pc.toString());
        }
        ObservableList ol1=FXCollections.observableList(comptext);
        list.setItems(ol1);
        layoutBox.setValue(CSE219FinalProj.currentSite.getLayout().getName());
        colorBox.setValue(CSE219FinalProj.currentSite.getColor().getName());
        fontBox.setValue(CSE219FinalProj.currentSite.getFont().getName());
         ArrayList<String> pages = new ArrayList <String>();
        for(Page p: CSE219FinalProj.currentSite.getPages()){
            pages.add(p.getTitle());
        }
        ObservableList ol2=FXCollections.observableList(pages);
        pageBox.setItems(ol2);
        DebugPrint.println("updating page: "+CSE219FinalProj.currentPage.getTitle());
        pageBox.setValue(CSE219FinalProj.currentPage.getTitle());
        titleField.setText(CSE219FinalProj.currentPage.getTitle());
        authorField.setText(CSE219FinalProj.currentSite.getAuthor());
        footerArea.setText(CSE219FinalProj.currentPage.getFooter());
        bannerLabel.setText("Banner\n"+CSE219FinalProj.currentPage.getBannerFilename());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CSE219FinalProj.window= this;
        
        
        ObservableList ol2=FXCollections.observableArrayList(Layout.getPossibilities());
        layoutBox.setItems(ol2);
        ObservableList ol3=FXCollections.observableArrayList(SiteColor.getPossibilities());
        colorBox.setItems(ol3);
        ObservableList ol4=FXCollections.observableArrayList(SiteFont.getPossibilities());
        fontBox.setItems(ol4);
        //titleField.setOnKeyTyped(e->{CSE219FinalProj.currentPage.setTitle(titleField.getText());});
        titleField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
                    Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                titleIsEdit=true;
                CSE219FinalProj.currentPage.setTitle(titleField.getText());
                DebugPrint.println("focus changed-oof: "+CSE219FinalProj.currentPage.getTitle());
                updateInformation();
                titleIsEdit=false;
                
                }
                else{
                    titleField.setText(CSE219FinalProj.currentPage.getTitle());
                    DebugPrint.println("focus changed-if: "+CSE219FinalProj.currentPage.getTitle());
                }
            }
        });
        //titleField.textProperty().addListener(e->{CSE219FinalProj.currentPage.setTitle(titleField.getText());this.updateInformation();DebugPrint.println("tftc: "+titleField.getText());});
        authorField.setOnKeyReleased(e->{CSE219FinalProj.currentSite.setAuthor(authorField.getText());});
        footerArea.setOnKeyReleased(e->{CSE219FinalProj.currentPage.setFooter(footerArea.getText());});
        layoutBox.setOnAction(e->{CSE219FinalProj.currentSite.setLayout(Layout.getValueByName((String)layoutBox.getValue()));CSE219FinalProj.isSaved=false;});
        colorBox.setOnAction(e->{CSE219FinalProj.currentSite.setColor(SiteColor.getValueByName((String)colorBox.getValue()));CSE219FinalProj.isSaved=false;});
        fontBox.setOnAction(e->{CSE219FinalProj.currentSite.setFont(SiteFont.getValueByName((String)fontBox.getValue()));CSE219FinalProj.isSaved=false;});
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
