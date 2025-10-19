
import java.io.FileNotFoundException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author patrick
 */
public class AdminRole  {
    private EmployeeUserDatabase database;

    public EmployeeUserDatabase getDatabase() {
        return database;
    }

    public AdminRole(String filename) throws FileNotFoundException {
        this.database = new EmployeeUserDatabase(filename);
    }
    

 
    public void addEmployee(
            String employeeId, String name, String email, String address, String phoneNumber) throws FileNotFoundException{
    EmployeeUser e =new EmployeeUser(employeeId,name,email,address,phoneNumber);
    database.insertRecord(e);
          
    
        
}

public EmployeeUser[] getListOfEmployees() {
    return  (EmployeeUser[])database.returnAllRecords().toArray(new EmployeeUser[0]);
}

public void removeEmployee(String key){
    database.deleteRecord(key);
    

}
public void logout() throws FileNotFoundException{
    database.saveToFile();
}
}





