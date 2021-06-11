/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;



/**
 *
 * @author iTs
 */
public class CSVDAO {
    
    private int t=0;
    
    public List<String> ReadDataFromCSV(String path) throws IOException{
        File f =new File(path);
        
        List<String> st=new ArrayList<String>();
        
        st=Files.readAllLines(f.toPath());
        
        return st;
    }
    
    
    public List<Countries> createCountries(String path) throws IOException{
        
        List<Countries> CO=new ArrayList<Countries>();
        List<String> l1=new ArrayList<String>();
        l1=ReadDataFromCSV(path);
        
        for(int i=1;i<l1.size();i++){
            String line=l1.get(i).trim();
            String[] data=line.split(",");
            Countries obj=new Countries(data[0],data[1],data[2]);
            CO.add(obj);
        }

        return CO;
    }
    
    public List<Cities> createCities(String path) throws IOException{
        List<Cities> CI=new ArrayList<Cities>();
        List<String> l1=new ArrayList<String>();
        l1=ReadDataFromCSV(path);
         for(int i=1;i<l1.size();i++){
            String line=l1.get(i).trim();
            String[] data=line.split(",");
            Cities obj;
            obj = new Cities(data[0].replaceAll("\"", ""),data[4].replaceAll("\"", ""),data[9].replaceAll("\"", ""),data[10].replaceAll("\"", ""));
            CI.add(obj);
        }  
        return CI;
    }
    


    
    
}