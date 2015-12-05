/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUICompEditors;

import cse219finalproj.CSE219FinalProj;
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
import model.ImageComp;
import model.ImageCompWrap;
import model.SSComp;

/**
 * FXML Controller class
 *
 * @author Dan
 */
public class SlideShowEditorController implements Initializable {

    SSComp ss=(SSComp) CSE219FinalProj.currentComponent;
    boolean isEdit = CSE219FinalProj.isEdit;
      @FXML
    private ListView<String> list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh();
        
    }    
     public void okClicked(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    public void cancelClicked(ActionEvent e){
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }
    public void refresh(){
        ArrayList<String> text = new ArrayList <String>();
        for(ImageComp i: ss.getImages()){
            text.add(i.toString());
        }
        ObservableList ol1=FXCollections.observableList(text);
        list.setItems(ol1);
    }
    public void addClicked(ActionEvent e){
        ImageCompWrap nc = new ImageCompWrap();
        CSE219FinalProj.sscomp=nc;
        nc.isEdit=false;
        nc.sse=this;
        nc.ssc=ss;
        nc.ic=new ImageComp();
        ComponentEditorWrapper cew = new ComponentEditorWrapper();
        cew.make(CompType.IMAGE);
    }
}
