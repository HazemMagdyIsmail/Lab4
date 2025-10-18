/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hazem
 */
public class EmployeeUser {
  private  String employeeId;
  private  String name;
  private String Email;
  private  String address;
  private  String phoneNumber;

    public EmployeeUser(String employeeId, String name, String Email, String address, String phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.Email = Email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getEmployeeId() {return employeeId;}
    public void setEmployeeId(String employeeId) {this.employeeId = employeeId;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return Email;}
    public void setEmail(String email) {Email = email;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber;}

    public String lineRepresentation(){
        return String.join(",",employeeId,name,Email,address,phoneNumber);
    }

    public String getSearchKey(){
        return employeeId;
    }
}
