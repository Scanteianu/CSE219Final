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
public enum SiteFont {
    ARIMO("Arimo"),
    MONTSERRAT("Montserrat"),
    COURGETTE("Courgette"),
    GLORIA("Gloria"),
    OSWALD("Oswald");
    private String name;
    SiteFont(String s){
        this.name=s;
    }
    public String getName()
    {
        return this.name;
    }
    public static SiteFont getValueByName(String name){
        switch(name){
            case "Arimo":
                return ARIMO;
            case "Courgette":
                return COURGETTE;
            case "Gloria":
                return GLORIA;
             case "Oswald":
                return OSWALD;
             case "Montserrat":
                return MONTSERRAT;
             default: return OSWALD;
        }
    }
    public static ArrayList<String> getPossibilities(){
        ArrayList<String>possibilities=new ArrayList<>();
        possibilities.add("Arimo");
        possibilities.add("Courgette");
        possibilities.add("Gloria");
        possibilities.add("Montserrat");
        possibilities.add("Oswald");
        return possibilities;
        
    }
}
