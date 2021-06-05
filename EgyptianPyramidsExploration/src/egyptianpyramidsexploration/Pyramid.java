/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyptianpyramidsexploration;


/**
 *
 * @author iTs
 */
public class Pyramid {
  
    private String Pharoh,AncientName,ModernName,Dynasty,Site,Type,Lepsius,Material,Comment;
    private double Base1,Base2,Height,Slope,Volume,Latitude,Longtude;
    
    //Constructor

    public Pyramid(String Pharoh, String AncientName, String ModernName, String Dynasty, String Site, double Base1, double Base2, double Height, double Slope, double Volume, double Latitude, double Longtude, String Type, String Lepsius, String Material, String Comment) {
        this.Pharoh = Pharoh;
        this.AncientName = AncientName;
        this.ModernName = ModernName;
        this.Dynasty = Dynasty;
        this.Site = Site;
        this.Type = Type;
        this.Lepsius = Lepsius;
        this.Material = Material;
        this.Comment = Comment;
        this.Base1 = Base1;
        this.Base2 = Base2;
        this.Height = Height;
        this.Slope = Slope;
        this.Volume = Volume;
        this.Latitude = Latitude;
        this.Longtude = Longtude;
    }

    
    //Getters
    public String getPharoh() {
        return Pharoh;
    }

    public String getAncientName() {
        return AncientName;
    }

    public String getModernName() {
        return ModernName;
    }

    public String getDynasty() {
        return Dynasty;
    }

    public String getSite() {
        return Site;
    }

    public double getBase1() {
        return Base1;
    }

    public double getBase2() {
        return Base2;
    }

    public double getHeight() {
        return Height;
    }

    public double getSlope() {
        return Slope;
    }

    public double getVolume() {
        return Volume;
    }

    public double getLatitude() {
        return Latitude;
    }

    public double getLongtude() {
        return Longtude;
    }

    public String getType() {
        return Type;
    }

    public String getLepsius() {
        return Lepsius;
    }

    public String getMaterial() {
        return Material;
    }

    public String getComment() {
        return Comment;
    }

    public void setPharoh(String Pharoh) {
        this.Pharoh = Pharoh;
    }

    public void setAncientName(String AncientName) {
        this.AncientName = AncientName;
    }

    public void setModernName(String ModernName) {
        this.ModernName = ModernName;
    }
}
