
import java.io.FileNotFoundException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hazem
 */
public class ProductDatabase extends Database {

    public ProductDatabase(String filename) throws FileNotFoundException {
        super(filename);
    }
    
    @Override 
   public Product createRecordFrom (String line){
   String[] words=line.trim().split(",");
   return new Product(words[0],words[1],words[2],words[3],Integer.parseInt(words[4]),Double.parseDouble(words[5]));
   
   }
    
}
