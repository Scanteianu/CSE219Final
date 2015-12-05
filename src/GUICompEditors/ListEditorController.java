/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUICompEditors;

import cse219finalproj.CSE219FinalProj;
import cse219finalproj.Messages;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ListComp;

/**
 * FXML Controller class
 *
 * @author Dan
 */
public class ListEditorController implements Initializable {
    
    @FXML ListView lv;
    @FXML TextField tf;
    boolean isEdit;
    ListComp lc=(ListComp)CSE219FinalProj.currentComponent;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isEdit=CSE219FinalProj.isEdit;
        refresh();
    }
    private void refresh(){
        ObservableList ol1=FXCollections.observableList(lc.getText());
        lv.setItems(ol1);
    }
    public void addClicked(ActionEvent e){
        lc.getText().add(tf.getText());
        refresh();
        tf.setText("");
    }
    public void replaceClicked(ActionEvent e){
        if(lv.getSelectionModel().getSelectedIndex()!=-1)
        {
            lc.getText().set(lv.getSelectionModel().getSelectedIndex(),tf.getText());
            refresh();
            tf.setText("");
        }
        else{
            Messages.ErrorMessage("Please Select a List Item.");
        }
    }
    public void removeClicked(ActionEvent e){
        if(lv.getSelectionModel().getSelectedIndex()!=-1)
        {
            lc.getText().remove(lv.getSelectionModel().getSelectedIndex());
            refresh();
        }
        else{
            Messages.ErrorMessage("Please Select a List Item.");
        }
    }
    public void linkClicked(ActionEvent e){
        
    }
      public void okClicked(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
        if(!isEdit)
             CSE219FinalProj.currentPage.getComponents().add(lc);
         CSE219FinalProj.window.updateInformation();
    }
    public void cancelClicked(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    
    
}
