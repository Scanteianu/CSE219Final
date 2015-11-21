/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dan
 */
public interface PageComponent {
    public String getName();
    public void setName(String name);
    public String toHTML();
    public CompType getType();
}
