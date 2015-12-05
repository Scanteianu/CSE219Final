/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dan
 */
public class ImageComp implements PageComponent{
    private String name="";
    private String caption="";
    private String fileLocation="";
    private String fileName="";
    private int sizeX=480;
    private int sizeY=640;
    private int floatNum =0;//-1 for l, 1 for r, 0 for neither.
    @Override
    public String toString(){
        return "Image: "+fileName+" Caption: "+ caption;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    private final CompType type=CompType.IMAGE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

  
    @Override
    public String toHTML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompType getType() {
     return type;
    }
    
}
