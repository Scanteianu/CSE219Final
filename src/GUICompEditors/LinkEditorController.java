/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUICompEditors;

import cse219finalproj.CSE219FinalProj;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.StringWrap;

/**
 * FXML Controller class
 *
 * @author Dan
 */
public class LinkEditorController implements Initializable {

    @FXML TextField text;
    @FXML TextField url;
    StringWrap link=CSE219FinalProj.link;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void okClicked(ActionEvent e){
        link.text="<a class=\\\"inlineRef\\\" href=\\\""+url.getText()+"\\\">"+text.getText()+"</a>";
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    public void cancelClicked(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    
}
