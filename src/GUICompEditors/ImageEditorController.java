/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUICompEditors;

import cse219finalproj.CSE219FinalProj;
import cse219finalproj.DebugPrint;
import cse219finalproj.Messages;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ImageComp;
import model.Layout;

/**
 * FXML Controller class
 *
 * @author Dan
 */
public class ImageEditorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    boolean isEdit=CSE219FinalProj.isEdit;
    ImageComp ic=(ImageComp)CSE219FinalProj.currentComponent;
    ArrayList<String> options=new ArrayList<>();
        
        ObservableList ol;
    @FXML ComboBox box;
    @FXML ImageView view;
    @FXML TextArea ta;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        options.add("Left");
        options.add("Middle");
        options.add("Right");
        ol=FXCollections.observableArrayList(options);
        box.setItems(ol);
        box.setValue(ol.get(1));
         if(isEdit)
        {
            try {
                view.setImage(new Image(new File(ic.getFileLocation()).toURI().toURL().toString()));
            } catch (MalformedURLException ex) {
                Messages.ErrorMessage("Couldn't load your picture, friend. It might not work on the website either.");
            }
            ta.setText(ic.getCaption());
            box.setValue(ol.get(ic.getFloatNum()+1));
        }
    }    
    public void okClicked(ActionEvent e){
        ic.setCaption(ta.getText());
        ic.setFloatNum(ol.indexOf(box.getValue())-1);
         if(!isEdit)
             CSE219FinalProj.currentPage.getComponents().add(ic);
          CSE219FinalProj.window.updateInformation();
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    public void cancelClicked(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    public void select(ActionEvent e){
        FileChooser jfc= new FileChooser();
        try{
        File file=jfc.showOpenDialog(null).getAbsoluteFile();
        if(!file.getName().toLowerCase().endsWith(".jpg")&&!file.getName().toLowerCase().endsWith(".jpeg")&&!file.getName().toLowerCase().endsWith(".png")&&!file.getName().toLowerCase().endsWith(".bmp")&&!file.getName().toLowerCase().endsWith(".gif"))
        {
             Messages.ErrorMessage("That's an invalid file type. We support JPEGs, GIFs,PNGs, and BMPs.");
            return;
        }
            ic.setFileLocation(file.getPath());
            ic.setFileName(file.getName());
            DebugPrint.println(ic.getFileLocation());
            try {
                view.setImage(new Image(new File(ic.getFileLocation()).toURI().toURL().toString()));
            } catch (MalformedURLException ex) {
                Messages.ErrorMessage("Couldn't load your picture, friend. It might not work on the website either.");
            }
            
            
        }
        catch(NullPointerException e1){
            
        }
    }
}
