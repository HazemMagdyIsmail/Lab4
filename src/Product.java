/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hazem
 */
public class Product extends Record {
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private double price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, double price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
    @Override
    public String lineRepresentation(){
    
  
    return (productID +','+productName+','+manufacturerName+','+supplierName+','+quantity+','+price) ;
    
    }
    
    @Override
   public String getSearchKey(){
       return productID;
   
   }
   
    
}
