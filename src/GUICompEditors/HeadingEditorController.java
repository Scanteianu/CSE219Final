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
import model.TextComp;

/**
 * FXML Controller class
 *
 * @author Dan
 */
public class HeadingEditorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML TextField text;
    private TextComp tc;
    private boolean isEdit;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tc=(TextComp)CSE219FinalProj.currentComponent;
        isEdit=CSE219FinalProj.isEdit;
    }    
      public void okClicked(ActionEvent e){
           tc.setText(text.getText());
         if(!isEdit)
             CSE219FinalProj.currentPage.getComponents().add(tc);
          CSE219FinalProj.window.updateInformation();
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    public void cancelClicked(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
}
