/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUICompEditors;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.CompType;

/**
 * FXML Controller class
 *
 * @author Dan
 */
public class SlideShowEditorController implements Initializable {

      @FXML
    private ListView<String> list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> text = new ArrayList <String>();
        text.add("Image: guitar.jpg Caption: The best instrument");
        text.add("Image: ukulele.jpg Caption: For pansies, not enough strings");
        text.add("Image: banjo.jpg Caption: More like \"Just no.\"");
        text.add("Image: Bass.jpg Caption: Because you can't count to over 4.");
        ObservableList ol1=FXCollections.observableList(text);
        list.setItems(ol1);
        
    }    
     public void okClicked(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    public void cancelClicked(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    public void addClicked(ActionEvent e){
        ComponentEditorWrapper cew = new ComponentEditorWrapper();
        cew.make(CompType.IMAGE);
    }
}
