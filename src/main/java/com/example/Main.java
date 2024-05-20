package com.example;

import java.util.Scanner;

public class Main{


    public static void main( String[] args )
    {
        
            Scanner scan = new Scanner(System.in);
            System.out.println("What you wanna say?");

            SampleProducer sampleProducer = new SampleProducer(scan.nextLine());

            while(scan.hasNextLine()){
            sampleProducer.setValue(scan.nextLine());
            }

            sampleProducer.setValue(null);//close kafkaProducer
            scan.close();
    }

}