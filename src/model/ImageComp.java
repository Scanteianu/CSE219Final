/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Dan
 */
public class ImageComp implements PageComponent, Serializable{
    private String name="";
    private String caption="";
    private String fileLocation="";
    private String fileName="";

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getFloatNum() {
        return floatNum;
    }

    public void setFloatNum(int floatNum) {
        this.floatNum = floatNum;
    }
    private int sizeX=480;
    private int sizeY=640;
    private int floatNum =0;//-1 for l, 1 for r, 0 for neither.
    @Override
    public String toString(){
        String align=" //center aligned.";
        if(floatNum<0){
            align=" //left aligned.";
        }
        if(floatNum>0){
            align=" //right aligned.";
        }
        return "Image: "+fileName+" Caption: "+ caption+align;
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
        return "var "+name+"=[\"img\",\""+this.fileName+"\",\""+caption+"\","+this.floatNum+"];";
    }
    public String toSSHTMLFragment(){
        return ",\""+this.fileName+"\",\""+this.caption+"\"";
    }
    @Override
    public CompType getType() {
     return type;
    }
    
}
