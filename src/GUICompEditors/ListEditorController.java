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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Dan
 */
public class ListEditorController implements Initializable {
    @FXML
    private ListView<String> list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> text = new ArrayList <String>();
        text.add("Binary solo!");
        text.add("0000001");
        text.add("00000111");
        text.add("0000001");
        text.add("00000111");
        text.add("one oh oh one");
        text.add("robo-boogie");
        ObservableList ol1=FXCollections.observableList(text);
        list.setItems(ol1);
        
    }    
    
}
