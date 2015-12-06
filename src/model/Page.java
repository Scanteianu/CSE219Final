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
public class Page implements Serializable {

    public ArrayList<PageComponent> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<PageComponent> components) {
        this.components = components;
    }

    public String getTitle() {
        return title;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    private ArrayList<PageComponent> components= new ArrayList<PageComponent>();
    private String title = "New Page";

    public String getBannerFilename() {
        return bannerFilename;
    }

    public void setBannerFilename(String bannerFilename) {
        this.bannerFilename = bannerFilename;
    }

    public String getBannerFilePath() {
        return bannerFilePath;
    }

    public void setBannerFilePath(String bannerFilePath) {
        this.bannerFilePath = bannerFilePath;
    }
    private String bannerFilename="";
    private String bannerFilePath="";
    private String footer="";
}
