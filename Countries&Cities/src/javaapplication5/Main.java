/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/** Method reference, Lambda expression, Collections[Map, linked list],Stream API
 *
 * @author iTs
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
       
        CSVDAO obj=new CSVDAO();
        List<Countries> CO=new ArrayList<Countries>();
        List<Cities> CI=new ArrayList<Cities>();
        Map<String,List<String> > mp=new HashMap<String,List<String>>(); 
        Map<String,String> id=new HashMap<String,String>();
        CO=obj.createCountries("C:\\Users\\iTs\\Desktop\\Java and UML_Amr Elshafey\\countries.csv");
        CI=obj.createCities("C:\\Users\\iTs\\Desktop\\Java and UML_Amr Elshafey\\cities.csv");
        
        List<Cities> sortedCities = CI.stream()
            .sorted(Comparator.comparing(Cities::getPop))
            .collect(Collectors.toList());
        
        for(int i =0;i<CO.size();i++){
            id.put(CO.get(i).getName(),CO.get(i).getCode());
        }
        
        for(int i =0;i<sortedCities.size();i++){
             mp.putIfAbsent(id.get(sortedCities.get(i).getCountry()), new ArrayList<String>());
             mp.get(id.get(sortedCities.get(i).getCountry())).add(sortedCities.get(i).getName());
        }

        
        
    
        
        
        mp.forEach((k,v)->System.out.println("| Code: "+k+"| List Of Cities: "+v));
    }    
}
