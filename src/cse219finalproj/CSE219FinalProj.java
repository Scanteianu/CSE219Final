/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse219finalproj;

import GUICompEditors.ComponentEditorWrapper;
import model.Page;
import model.PageComponent;
import model.Site;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ImageComp;

/**
 *
 * @author Dan
 */
public class CSE219FinalProj extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        currentPage=new Page();
        currentSite = new Site();
        currentSite.getPages().add(currentPage);
        launch(args);
        
    }
    public void editComponent(PageComponent pc){
        ComponentEditorWrapper cer = new ComponentEditorWrapper();
    }
    public static PageComponent currentComponent;
    public static Page currentPage;
    public static Site currentSite;
    public static boolean isEdit;
    public static MainWindow window;
    public static boolean isSaved=true;
    public static String link="";
    public static ImageComp sscomp=null;
}
