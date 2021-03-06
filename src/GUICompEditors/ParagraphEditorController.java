/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUICompEditors;

import cse219finalproj.CSE219FinalProj;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.StringWrap;
import model.TextComp;

/**
 * FXML Controller class
 *
 * @author Dan
 */
public class ParagraphEditorController implements Initializable {

    @FXML TextArea text;
    private TextComp tc;
    private boolean isEdit;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tc=(TextComp)CSE219FinalProj.currentComponent;
        isEdit=CSE219FinalProj.isEdit;
        text.setText(tc.getText());
    }    
     public void okClicked(ActionEvent e){
         tc.setText(text.getText().replaceAll("\n", "<br>"));
         if(!isEdit)
             CSE219FinalProj.currentPage.getComponents().add(tc);
         CSE219FinalProj.window.updateInformation();
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    public void cancelClicked(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    public void link(ActionEvent e){
        //can use selected text in text area if needed to edit hyper links
        try {
            StringWrap link=new StringWrap();
            CSE219FinalProj.link=link;
            Parent root= FXMLLoader.load(getClass().getResource("LinkEditor.fxml"));
            
            Scene scene=new Scene(root);
            Stage compStage=new Stage();
            compStage.setScene(scene);
            compStage.setTitle("Add a link");
            compStage.showAndWait();
            text.insertText(text.getCaretPosition(),link.text);
        } catch (IOException ex) {
            
            Logger.getLogger(ParagraphEditorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
