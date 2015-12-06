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
public class Site implements Serializable {

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    private ArrayList<Page> pages = new ArrayList<Page>();
    private String name="Untitled";
    private String location=null;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    private String author="";
    private Layout layout=Layout.MIDDLE_BANNER;

    public SiteColor getColor() {
        return color;
    }

    public void setColor(SiteColor color) {
        this.color = color;
    }
    private SiteColor color=SiteColor.BLUE_WHITE;
    private SiteFont font =SiteFont.OSWALD;

    public SiteFont getFont() {
        return font;
    }

    public void setFont(SiteFont font) {
        this.font = font;
    }
    public String partialHTML(){
        String s ="";
        s+="var author =\""+author+"\";\n";
        String pagesStr="var pages =[";
        String pageTtl="var pageNames =[";
        for(Page p: this.pages){
            pagesStr+="\""+p.getName()+"\",";
            pageTtl+="\""+p.getTitle()+"\",";
        }
        pagesStr=pagesStr.substring(0,pagesStr.length()-1);
        pageTtl=pageTtl.substring(0,pageTtl.length()-1);
        pagesStr+="];\n";
        pageTtl+="];\n";
        s+=pagesStr;
        s+=pageTtl;
        if(this.layout==Layout.MIDDLE_BANNER)
            s+="var navStyle =\"horizontal-below\";\n";
         if(this.layout==Layout.TOP_BANNER)
            s+="var navStyle =\"horizontal-above\";\n";
         if(this.layout==Layout.SIDE_BANNER)
             s+="var navStyle =\"vertical\";\n";
         if(this.layout==Layout.TOP_NO_BANNER)
            s+="var navStyle =\"horizontal-above\";\n";
         if(this.layout==Layout.SIDE_NO_BANNER)
             s+="var navStyle =\"vertical\";\n";
        
        
        return s;
    }
}
