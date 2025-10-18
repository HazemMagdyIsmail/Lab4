/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author patrick
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class dataBase {
    String filename;
    public abstract Record createRecordFrom(String line);
    
    public void readFromFile() throws FileNotFoundException{
        File F=new File (filename);
        Scanner s=new Scanner(F);
        
        ArrayList <Record> records=new ArrayList<>();
        
        while(s.hasNextLine()){
            String x= s.nextLine();
            records.add(createRecordFrom(x));
        }
        
        
        
    }
    
    
}
