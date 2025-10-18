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
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Database {

    private String filename;
    private ArrayList<Record> recordsArray = new ArrayList<>();

    public Database(String filename) throws FileNotFoundException {
        this.filename = filename;
        readFromFile();
    }

    public abstract Record createRecordFrom(String line);

    public void readFromFile() throws FileNotFoundException {
        File F = new File(filename);
        Scanner s = new Scanner(F);

        while (s.hasNextLine()) {
            String x = s.nextLine();
            recordsArray.add(createRecordFrom(x));
        }

    }

    public ArrayList<Record> returnAllRecords() {
        return recordsArray;

    }

    public boolean contains(String key) {

        for (int i = 0; i < recordsArray.size(); i++) {
            if (key == recordsArray.get(i).getSearchKey()) {
                return true;
            }

        }

    }
    public Record getRecord(String key){
              for (int i = 0; i < recordsArray.size(); i++) {
            if (key == recordsArray.get(i).getSearchKey()) {
                return recordsArray.get(i);
            }
            

        }
              return null;
    }
    public void insertRecord(Record record){
        recordsArray.add(record);
    } 
        public void deleteRecord(String key) {
            for (int i = 0; i < recordsArray.size(); i++) {
                 if (key == recordsArray.get(i).getSearchKey()) {
                 recordsArray.remove(i);
                 }
                 
                
            }
            
            
    }
        public void saveToFile() throws FileNotFoundException{
     PrintWriter writer = new PrintWriter(filename);
    for(int i=0;i<recordsArray.size();i++){
    String line = recordsArray.get(i).lineRepresentation();
    writer.println(line);
   }
        writer.close();
    



   
}


}
