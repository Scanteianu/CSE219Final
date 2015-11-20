/*
Paragraph and Heading Only
 */
package cse219finalproj.model;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class ListComp implements PageComponent {
    private String name;
    private CompType type;

    public void setType(CompType type) {
        this.type = type;
    }
    private ArrayList<String> text;

    public ArrayList<String> getText() {
        return text;
    }

    public void setText(ArrayList<String>  text) {
        this.text = text;
    }
    
    
    @Override
    public String getName() {
       return name;
    }

    @Override
    public void setName(String name) {
       this.name=name;
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
