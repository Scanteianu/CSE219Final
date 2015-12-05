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
public enum Layout {
    TOP_BANNER("Menu Above Banner"),
    MIDDLE_BANNER("Menu Below Banner"),
    SIDE_BANNER("Menu On Side, With Banner"),
    TOP_NO_BANNER("Menu On Top, No Banner"),
    SIDE_NO_BANNER("Menu On Side, No Banner");
    private String name;
    Layout(String s){
        this.name=s;
    }
    public String getName()
    {
        return this.name;
    }
    public static Layout getValueByName(String name){
        switch(name){
            case "Menu Above Banner":
                return TOP_BANNER;
            case "Menu Below Banner":
                return MIDDLE_BANNER;
            case "Menu On Side, With Banner":
                return SIDE_BANNER;
             case "Menu On Top, No Banner":
                return TOP_NO_BANNER;
             case "Menu On Side, No Banner":
                return SIDE_NO_BANNER;
             default: return TOP_BANNER;
        }
    }
    public static ArrayList<String> getPossibilities(){
        ArrayList<String>possibilities=new ArrayList<>();
        possibilities.add("Menu Above Banner");
        possibilities.add("Menu Below Banner");
        possibilities.add("Menu On Side, With Banner");
        possibilities.add("Menu On Top, No Banner");
        possibilities.add("Menu On Side, No Banner");
        return possibilities;
        
    }
}
