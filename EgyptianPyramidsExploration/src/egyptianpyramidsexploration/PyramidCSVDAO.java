/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptianpyramidsexploration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author iTs
 */
public class PyramidCSVDAO {
    
    private int t=0;
    
    public List<Pyramid> readPyramidFromCSV(String path) throws IOException{
        String row;
        String[] data = new String[16];
        Arrays.fill(data, " ");
        BufferedReader csvReader = null;
        
        List<Pyramid> pyramidObjects = new ArrayList<Pyramid>();
        try {
            csvReader = new BufferedReader(new FileReader(path));
            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");
                if (t!=0){
                pyramidObjects.add(createPyramid(data)); }
                else{System.out.println("#   "+row);
                    t=1;}
        }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not found! "+ex);
        }
        csvReader.close();
        return pyramidObjects;
    }
    
    
    public Pyramid createPyramid(String []data){
        String x=" ";
        if (data.length==16){x=data[15];}
        Pyramid obj=new Pyramid(data[0],data[1],data[2],data[3],data[4],toDouble(data[5]),toDouble(data[6]),toDouble(data[7]),toDouble(data[8]),toDouble(data[9]),toDouble(data[10]),toDouble(data[11]),data[12],data[13],data[14],x);
        return obj;
    }
    
    public double toDouble(String x){
        
        try
        {
            return Double.parseDouble(x);
        }
        catch(NumberFormatException e)
        {
            return Double.NaN;     
        }
    }

    
    
}