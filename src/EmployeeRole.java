import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EmployeeRole {
    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole(String productsFile, String customerProductsFile) throws FileNotFoundException {
        productsDatabase = new ProductDatabase(productsFile);
        customerProductDatabase = new CustomerProductDatabase(customerProductsFile);
    }

    public void addProduct(String productID, String productName, String manufacturerName,
                           String supplierName, int quantity, double price) throws FileNotFoundException {
        Product p = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        productsDatabase.insertRecord(p);
        productsDatabase.saveToFile();
    }

    public Product[] getListOfProducts() {
        ArrayList<Record> all = productsDatabase.returnAllRecords();
        Product[] arr = new Product[all.size()];
        for (int i = 0; i < all.size(); i++) {
            arr[i] = (Product) all.get(i);
        }
        return arr;
    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        ArrayList<Record> all = customerProductDatabase.returnAllRecords();
        CustomerProduct[] arr = new CustomerProduct[all.size()];
        for (int i = 0; i < all.size(); i++) {
            arr[i] = (CustomerProduct) all.get(i);
        }
        return arr;
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate)
            throws FileNotFoundException {
        Product product = (Product) productsDatabase.getRecord(productID);
        if (product == null) return false;
        if (product.getQuantity() <= 0) return false;
        product.setQuantity(product.getQuantity() - 1);
        CustomerProduct c = new CustomerProduct(customerSSN, productID, purchaseDate);
        customerProductDatabase.insertRecord(c);
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
        return true;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate,
                                LocalDate returnDate) throws FileNotFoundException {
        if (returnDate.isBefore(purchaseDate)) return -1;
        String purchaseKey = customerSSN + "," + productID;
        ArrayList<Record> all = customerProductDatabase.returnAllRecords();
        CustomerProduct found = null;
        for (int i = 0; i < all.size(); i++) {
            CustomerProduct c = (CustomerProduct) all.get(i);
            if (c.getSearchKey().equals(purchaseKey)) {
                found = c;
                break;
            }
        }
        if (found == null) return -1;
        long days = ChronoUnit.DAYS.between(purchaseDate, returnDate);
        if (days > 14) return -1;
        Product p = (Product) productsDatabase.getRecord(productID);
        if (p == null) return -1;
        p.setQuantity(p.getQuantity() + 1);
        customerProductDatabase.deleteRecord(purchaseKey);
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
        return p != null ? p.getQuantity() : 0;
    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) throws FileNotFoundException {
        ArrayList<Record> all = customerProductDatabase.returnAllRecords();
        for (int i = 0; i < all.size(); i++) {
            CustomerProduct c = (CustomerProduct) all.get(i);
            if (c.getCustomerSSN().equals(customerSSN)
                    && c.getPurchaseDate().equals(purchaseDate)
                    && !c.isPaid()) {
                c.setPaid(true);
                customerProductDatabase.saveToFile();
                return true;
            }
        }
        return false;
    }

    public void logout() throws FileNotFoundException {
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }
}