
import java.io.FileNotFoundException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hazem
 */
public class EmployeeUserDatabase extends Database {

    public EmployeeUserDatabase(String filename) throws FileNotFoundException {
        super(filename);
    }
    
    @Override 
   public EmployeeUser createRecordFrom (String line){
   String[] words=line.trim().split(",");
   return new EmployeeUser(words[0],words[1],words[2],words[3],words[4]);
   
   }
}
