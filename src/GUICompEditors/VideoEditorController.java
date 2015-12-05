/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUICompEditors;

import cse219finalproj.CSE219FinalProj;
import cse219finalproj.Messages;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.VideoComp;

/**
 * FXML Controller class
 *
 * @author Dan
 */
public class VideoEditorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Label label;
    @FXML TextArea ta;
    VideoComp vc=(VideoComp)CSE219FinalProj.currentComponent;
    boolean isEdit=CSE219FinalProj.isEdit;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        if(isEdit)
        {
            label.setText(vc.getFileName());
            ta.setText(vc.getCaption());
        }
    }    
     public void okClicked(ActionEvent e){
         vc.setCaption(ta.getText());
         if(!isEdit)
             CSE219FinalProj.currentPage.getComponents().add(vc);
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
        if(!file.getName().toLowerCase().endsWith(".mp4"))
        {
            Messages.ErrorMessage("That's an invalid file type. We support mp4.");
            return;
        }
            vc.setFileLocation(file.getPath());
            vc.setFileName(file.getName());
            label.setText(file.getName());
            
        }
        catch(NullPointerException e1){
            
        }
    }
    
}
