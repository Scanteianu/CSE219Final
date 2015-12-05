/*
Paragraph and Heading Only
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class ListComp implements PageComponent {
    private String name;
    private CompType type;
    @Override
    public String toString(){
        return "List: "+text.toArray(new String[1]).toString();
    }
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
