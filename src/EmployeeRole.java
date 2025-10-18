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
}
