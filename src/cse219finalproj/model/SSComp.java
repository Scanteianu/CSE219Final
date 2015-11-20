/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse219finalproj.model;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class SSComp implements PageComponent
{
    private String name;
    private CompType type;
    private ArrayList<String> captions;
    private ArrayList<String> fileNames;
    private ArrayList<String> fileLocations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompType getType() {
        return type;
    }

    public void setType(CompType type) {
        this.type = type;
    }

    public ArrayList<String> getCaptions() {
        return captions;
    }

    public void setCaptions(ArrayList<String> captions) {
        this.captions = captions;
    }

    public ArrayList<String> getFileNames() {
        return fileNames;
    }

    public void setFileNames(ArrayList<String> fileNames) {
        this.fileNames = fileNames;
    }

    public ArrayList<String> getFileLocations() {
        return fileLocations;
    }

    public void setFileLocations(ArrayList<String> fileLocations) {
        this.fileLocations = fileLocations;
    }

    @Override
    public String toHTML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
