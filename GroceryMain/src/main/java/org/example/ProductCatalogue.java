package org.example;

import java.util.*;

public class ProductCatalogue {

    private HashMap<String, Integer> productCatalogue;

    public ProductCatalogue(HashMap<String, Integer> productCatalogue) {
        this.productCatalogue = productCatalogue;
    }

    public String addProduct(String productName, Integer productQuantity){

        if(productCatalogue.containsKey(productName)){
            this.updateProduct(productName, productQuantity);
            return "Product previously added. " + productName + " quantity updated" + "\n";
        }

        if(productQuantity <= 0){
            return "Quantity must be more than zero!" + "\n";
        }

        productCatalogue.put(productName, productQuantity);

        return productName + " - " + productQuantity + " pcs added!" + "\n";
    }

    public String checkProduct(String productName){

        //https://stackoverflow.com/questions/15730134/opposite-of-contains-does-not-contain
        if(!productCatalogue.containsKey(productName)){
            return "Product not found." + "\n";
        }

        return productName + " is in stock: " + productCatalogue.get(productName).toString() + "\n";
    }

    public String updateProduct(String productName, Integer newProductQuantity){

        //https://stackoverflow.com/questions/15730134/opposite-of-contains-does-not-contain
        if(!productCatalogue.containsKey(productName)){
            return "Product not found." + "\n";
        }

        if(newProductQuantity <= 0){
            return "Quantity must be more than zero!" + "\n";
        }

        productCatalogue.replace(productName, newProductQuantity);

        return productName + " quantity updated to: " + newProductQuantity + "\n";
    }

    public String removeProduct(String productName){

        //https://stackoverflow.com/questions/15730134/opposite-of-contains-does-not-contain
        if(!productCatalogue.containsKey(productName)){
            return "Product not found." + "\n";
        }

        productCatalogue.remove(productName);

        return productName + " removed!" + "\n";
    }

    public void viewInventory(){
        System.out.println("\nCurrent Inventory:");
        //https://stackoverflow.com/questions/5920135/printing-hashmap-in-java
        productCatalogue.forEach((key, value) -> System.out.println(key + " - " + value + " pcs"));
        System.out.println();
    }

//    addProduct(Parameters)
//    checkProduct(Parameters)
//    updateProduct(Parameters)
//    removeProduct(Parameters)
//    viewInventory(Parameters)
}
