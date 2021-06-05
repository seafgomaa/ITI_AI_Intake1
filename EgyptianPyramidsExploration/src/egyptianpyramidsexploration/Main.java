/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptianpyramidsexploration;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iTs
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PyramidCSVDAO pDAO=new PyramidCSVDAO();
        List<Pyramid> pyramids =new ArrayList<Pyramid>();
       
        try {
             pyramids=pDAO.readPyramidFromCSV("C:\\Users\\iTs\\Desktop\\Java and UML_Amr Elshafey\\pyramids.csv");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i=1;
        for(Pyramid p: pyramids){            
            System.out.println("#" +(i++)+"  "+p.getPharoh()+" | "+p.getAncientName()+" | "+p.getModernName()+" | "+p.getDynasty()+" | "+p.getSite()+" | "+p.getBase1()+" | "+p.getBase2()+" | "+p.getHeight()+" | "+p.getSlope()+" | "+p.getVolume()+" | "+p.getLatitude()+" | "+p.getLongtude()+" | "+p.getType()+" | "+p.getLepsius()+" | "+p.getMaterial()+" | "+p.getComment());
            
        }
        
    
    }
    

         

    
}
