/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.machinelearningwithspark;


import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
/**
 *
 * @author iTs
 */
public class Main {
    public static void main(String [] args){
        
        /*Read csv file with spark*/
        //
        //open spark session
        SparkSession sc=SparkSession.builder().appName("MLspark").master("local[2]").getOrCreate();
        //create data frame with spark
        DataFrameReader df=sc.read();
        // config the data frame reader
        df.option("header", true);
        //Read csv file
        Dataset<Row> ds=df.csv("C:\\Users\\iTs\\Desktop\\Java and UML_Amr Elshafey\\19-6-2021\\JUPAI9Examples\\src\\main\\resources\\listings.csv");
        //Show resaults
        ds.printSchema();
        ds.select("id","name","latitude","longitude","bedrooms","price").show(100);
       
        
        //////////////////////////////////////////
        /*Features Engineering*/
        //
        //Convert string features we need into apropriate data type and remove nulls
        ds=ds.withColumn("bedroomsM", ds.col("bedrooms").cast("int")).filter(ds.col("bedrooms").isNotNull());
        ds=ds.withColumn("priceM", ds.col("price").cast("double")).filter(ds.col("price").isNotNull());
        
        //Show resaults
        ds.select("id","name","bedroomsM","priceM").show(100);
        ds.printSchema();
                       
        // set split ratio
        double split[]={.8,.2};
        
        // splitt into training set and test set
        Dataset<Row>[] traintest=ds.randomSplit(split);
        Dataset<Row> train=traintest[0];
        Dataset<Row> test=traintest[1];
        
        String[] features={"bedroomsM"};
        
        ///////////////////////////////////////
        /**/
        VectorAssembler va= new VectorAssembler();
        
        va.setInputCols(features);
        va.setOutputCol("featuress");
        
        Dataset<Row> trainT=va.transform(train.na().drop());
        Dataset<Row> testT=va.transform(test.na().drop());
        
        trainT.select("featuress" , "priceM").show (10);
        
        
        LinearRegression lr=new LinearRegression();
        lr.setFeaturesCol("featuress");
        lr.setLabelCol("priceM");
        
        LinearRegressionModel lrm=lr.fit(trainT.na().drop());
        
        float coef1=Math.round(lrm.coefficients().toArray()[0]);
        float inter=Math.round(lrm.intercept());
        System.out.println("The formula for the linear regression line is price = "+coef1+"*bedrooms + "+inter);
        
        Dataset<Row> pred=lrm.transform(testT.na().drop());
        pred.show();
        
    }
    
}
