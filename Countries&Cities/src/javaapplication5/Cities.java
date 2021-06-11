/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author iTs
 */
public class Cities {
    private String name;
    private String country;
    private String pop;
    private String id;

    public Cities(String name, String country, String pop, String id) {
        this.name = name;
        this.country = country;
        this.pop = pop;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getPop() {
        return pop;
    }

    public String getId() {
        return id;
    }
    
    
    
    
    
}
