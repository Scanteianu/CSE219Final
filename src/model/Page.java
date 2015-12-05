/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class Page {

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
    private String footer="";
}
