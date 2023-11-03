package view;

import controller.Producer;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public void displayMenu() {
        System.out.println("Product Management\n");
        System.out.println("-----------------------------\n");
        System.out.println("1. List all products");
        System.out.println("2. Search product");
        System.out.println("3. Add new product");
        System.out.println("4. Exit");
        System.out.println("\n-----------------------------\n");
        System.out.println("Enter selection..");
    }

    public static void main(String[] args) {
        Producer p = new Producer();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        do {
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice > 0 && choice <= 4);
    }
}
