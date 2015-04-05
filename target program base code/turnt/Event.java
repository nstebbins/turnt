/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnt;

import java.util.ArrayList;

/**
 *
 * @author Khetthai
 */
public class Event {
    private ArrayList<Directive> registeredDirectives;
    
    public Event() {
        registeredDirectives = new ArrayList<>();
        /* add registered directives here 
        register(new Directive);*/
    }
    
    public ArrayList<Directive> evt() {
        return registeredDirectives;
    }
    
    /*public void register(Directive directive) {
        registeredDirectives.add(directive);
    } */
    
    /*public boolean autoEmit() {
        if (condition) {
            return true;
        }
        return false;
    } */
}
