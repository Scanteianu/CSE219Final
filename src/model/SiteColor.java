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
public enum SiteColor {
    BLACK_RED("Black with Red Font"),
    BLUE_WHITE("Blue with White Font"),
    YELLOW_BLACK("Yellow with Black Font"),
    PURPLE_YELLOW("Purple with Yellow Font"),
    GRAY_BLACK("Gray with Black Font");
    private String name;
    SiteColor(String s){
        this.name=s;
    }
    public String getName()
    {
        return this.name;
    }
    public static SiteColor getValueByName(String name){
        switch(name){
            case "Black with Red Font":
                return BLACK_RED;
            case "Blue with White Font":
                return BLUE_WHITE;
            case "Yellow with Black Font":
                return YELLOW_BLACK;
             case "Purple with Yellow Font":
                return PURPLE_YELLOW;
             case "Gray with Black Font":
                return GRAY_BLACK;
             default: return BLUE_WHITE;
        }
    }
    public static ArrayList<String> getPossibilities(){
        ArrayList<String>possibilities=new ArrayList<>();
        possibilities.add("Black with Red Font");
        possibilities.add("Blue with White Font");
        possibilities.add("Yellow with Black Font");
        possibilities.add("Purple with Yellow Font");
        possibilities.add("Gray with Black Font");
        return possibilities;
        
    }
}
