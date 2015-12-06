/*
Paragraph and Heading Only
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Dan
 */
public class TextComp implements PageComponent, Serializable {
    private String name="";
    private CompType type=CompType.PARAGRAPH;
    @Override
    public String toString(){
        if(type==CompType.HEADING)
            return "Heading: "+text;
        return "Paragraph: "+text;
    }
    public void setType(CompType type) {
        this.type = type;
    }
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
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
    /**
     * precondition: name must be set externally first.
     * @return 
     */
    @Override
    public String toHTML() {
        
        if(type==CompType.HEADING)
            return"var "+name+"=[\"text\",\"heading\",\""+text+"\"];";
        return"var "+name+"=[\"text\",\"paragraph\",\""+text+"\"];";
    }

    @Override
    public CompType getType() {
        return type;
    }
    
}
