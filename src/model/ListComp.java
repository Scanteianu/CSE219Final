/*
Paragraph and Heading Only
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class ListComp implements PageComponent, Serializable {
    private String name;
    private CompType type=CompType.LIST;
    @Override
    public String toString(){
        String returns ="List: \n";
        for(String s: text)
            returns+=s+"\n";
        return returns;
    }
    public void setType(CompType type) {
        this.type = type;
    }
    private ArrayList<String> text=new ArrayList<>();

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
        if(this.text.isEmpty())
            return null;
        String s="var "+ this.name+"=[\"text\", \"list\"";
        for(String s1: this.text){
            s+=",\""+s1+"\"";
        }
        s+="];";
        return s;
    }

    @Override
    public CompType getType() {
        return type;
    }
    
}
