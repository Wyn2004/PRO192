package controller;

import util.Inputter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Predicate;
import model.Product;
import util.Validation;

public class Producer {

    private ArrayList<Product> productList = new ArrayList();

    //ham khoi tao
    public Producer() {
    }

    //readTextFile
    public void readTextFile(String fileName) {
        try {
            Product product;
            File f = new File(fileName);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String[] parts = sc.nextLine().split("[,=]");
                String productID = parts[1].trim();
                String productName = parts[3].trim();
                double unitPrice = Double.parseDouble(parts[5].trim());
                int quantity = Integer.parseInt(parts[7].trim());
                double version = Double.parseDouble(parts[9].trim());
                String d = parts[11].trim();
                product = new Product(productID, productName, unitPrice, quantity, version, Validation.parseDate(d, "dd/MM/yyyy"));
                productList.add(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist.\n");
        }
        System.out.println("Load data successfully.\n");
    }

    //saveToTextFile
    public void saveToTextFile(String fileName) {
        try {
            File f = new File(fileName);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            PrintStream ps = new PrintStream(f);
            for (int i = 0; i < productList.size(); i++) {
                ps.append("Id=" + productList.get(i).getProductID() + ", Name=" + productList.get(i).getProductName()
                        + ", UnitPrice=" + productList.get(i).getUnitPrice() + ", Quantity=" + productList.get(i).getQuantity()
                        + ", Version=" + productList.get(i).getVersion() + ", ProductManufacturingDate=" + dateFormat.format(productList.get(i).getProductManufacturingDate()) + "\n");
            }
            ps.close();
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist.\n");
        }
        System.out.println("Save data successfully.\n");
    }

    //printAnyList
    public void printList() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    //search(fixed)
    public boolean searchIf(Predicate<Product> predicate) {
        for (Product product : productList) {
            if (predicate.test(product)) {
                System.out.println(product.toString());
                return true;
            }
        }
        return false;
    }

    //addProduct
    public void addProduct() {
        String newProductID = Inputter.inputNonBlankStr("productID");
        Product product = new Product(newProductID);
        if (productList.contains(product)) {
            System.out.println("ID has existed.\n");
            return;
        }
        String newProductName = Inputter.inputNonBlankStr("product name");
        double newUnitPrice = Inputter.inputDouble("unit price");
        int newQuantity = Inputter.inputInt("quantity");
        double newVersion = Inputter.inputDouble("version");
        Date newDate = Inputter.inputDate("date (dd/MM/yyyy)");
        //create new product
        Product newProduct = new Product(newProductID, newProductName, newUnitPrice, newQuantity, newVersion, newDate);
        //add to the list
        productList.add(newProduct);
        System.out.println("Added successfully.\n");
    }

    //sort(selection sort)
    public void sortList(Comparator<Product> c) {
        int n = productList.size();
        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < n - 1; i++) {
            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (c.compare(productList.get(j), productList.get(min_idx)) < 0) {
                    min_idx = j;
                }
            }
            // Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
            Product temp = productList.get(min_idx);
            productList.set(min_idx, productList.get(i));
            productList.set(i, temp);
        }
    }

    //sort(bubble sort)
    public void bubbleSort(Comparator<Product> c) {
        int n = productList.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // so sánh hai phần tử liền kề
                if (c.compare(productList.get(j), productList.get(j + 1)) > 0) {
                    // hoán đổi hai phần tử
                    Product temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }
    }

    //sort(insertion sort)
    public void insertionSort(Comparator<Product> c) {
        int n = productList.size();
        for (int i = 1; i < n; ++i) {
            Product key = productList.get(i);
            int j = i - 1;
            // Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            while (j >= 0 && c.compare(productList.get(j), key) > 0) {
                productList.set(j + 1, productList.get(j));
                j = j - 1;
            }
            productList.set(j + 1, key);
        }
    }

    //main
    public static void main(String[] args) {
        Producer p1 = new Producer();
        p1.readTextFile("products.txt");
        p1.printList();
        p1.addProduct();
        p1.printList();
//        p1.sortList((o1, o2) -> (int) (o1.getUnitPrice() - o2.getUnitPrice()));
//
//        p1.searchIf(t -> t.getProductID().equals(Inputter.inputNonBlankStr("product id")));
//        p1.searchIf(t -> t.getProductName().equals(Inputter.inputNonBlankStr("product name")));
//        p1.searchIf(t -> t.getProductManufacturingDate().equals(Inputter.inputDate("product date")));

        p1.saveToTextFile("outputProducts.txt");
    }
}
