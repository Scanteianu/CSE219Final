/*
Paragraph and Heading Only
 */
package cse219finalproj.model;

/**
 *
 * @author Dan
 */
public class TextComp implements PageComponent {
    private String name;
    private CompType type;

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

    @Override
    public String toHTML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompType getType() {
        return type;
    }
    
}
