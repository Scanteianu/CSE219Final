/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class SSComp implements PageComponent, Serializable
{
    private String name;
    private final CompType type=CompType.SLIDESHOW;

    public ArrayList<ImageComp> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageComp> images) {
        this.images = images;
    }

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
    private ArrayList<ImageComp> images = new ArrayList<>();
    private int sizeX=480;
    private int sizeY=640;
    @Override
    public String toString(){
        String s="Slideshow: note - all images will be center aligned on Website.\n";
        for(ImageComp ic:images){
            s+=ic.toString()+"\n";
        }
        return s;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompType getType() {
        return type;
    }

  
    @Override
    public String toHTML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
