package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        ProductCatalogue inventory = new ProductCatalogue(new HashMap<>());

        while(true) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("--- Grocery Inventory Menu ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Check Product");
            System.out.println("4. Update Product");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");

            System.out.printf("\n" + "Choose option: ");
            int userOption = scanner.nextInt();

            switch (userOption) {
                case 1:
                    inventory.viewInventory();
                    break;
                case 2:

                    System.out.printf("\n" + "Enter product name: ");
                    String productAddName = scanner.next();

                    System.out.printf("Enter Quantity: ");
                    int productQuantity = scanner.nextInt();

                    if(productQuantity < 0){
                        System.out.println("Quantity must be more than zero!");
                    }

                    System.out.println("");

                    System.out.println(inventory.addProduct(productAddName, productQuantity));
                    break;
                case 3:

                    System.out.printf("\n" + "Enter product name to check: ");
                    String productCheckName = scanner.next();

                    if(inventory.hasProduct(productCheckName) == false){
                        System.out.println("No such product!" + "\n");
                        break;
                    }

                    System.out.println(inventory.checkProduct(productCheckName));

                    break;
                case 4:

                    System.out.printf("\n" + "Enter product name to update: ");
                    String productUpdateName = scanner.next();

                    if(inventory.hasProduct(productUpdateName) == false){
                        System.out.println("No such product!" + "\n");
                        break;
                    }

                    System.out.printf("Enter new stock quantity: ");
                    int productUpdateQuantity = scanner.nextInt();

                    System.out.println(inventory.updateProduct(productUpdateName, productUpdateQuantity));

                    break;
                case 5:

                    System.out.printf("\n" + "Enter product name to remove: ");
                    String productRemoveName = scanner.next();

                    if(inventory.hasProduct(productRemoveName) == false){
                        System.out.println("No such product!" + "\n");
                        break;
                    }

                    System.out.println(inventory.removeProduct(productRemoveName));
                    break;
                case 6:
                    System.out.println("Exiting System ...");

                    return;
            }

        }

    }
}