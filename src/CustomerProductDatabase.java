
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hazem
 */
public class CustomerProductDatabase extends Database {

    public CustomerProductDatabase(String filename) throws FileNotFoundException {
        super(filename);
    }
    
      @Override 
   public CustomerProduct createRecordFrom (String line){
   String[] words=line.trim().split(",");
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(words[2], formatter);

   return new CustomerProduct(words[0],words[1],date);
   
   }
    
}
