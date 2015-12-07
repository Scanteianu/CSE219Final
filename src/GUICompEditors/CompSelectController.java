/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUICompEditors;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.CompType;

/**
 * FXML Controller class
 *
 * @author Dan
 */
public class CompSelectController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private void insertImg(ActionEvent e) {
          ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.IMAGE); ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    @FXML
    private void insertParagraph(ActionEvent e){
        ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.PARAGRAPH); ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    @FXML
    private void insertHeading(ActionEvent e){
        ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.HEADING); ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }

    @FXML
    private void insertList(ActionEvent e){
        ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.LIST); ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    @FXML
    private void insertSlideshow(ActionEvent e){
        ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.SLIDESHOW);
         ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    @FXML
    private void insertVideo(ActionEvent e){
        ComponentEditorWrapper cer = new ComponentEditorWrapper();
        cer.make(CompType.VIDEO);
         ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    @FXML
    public void cancelClicked(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
