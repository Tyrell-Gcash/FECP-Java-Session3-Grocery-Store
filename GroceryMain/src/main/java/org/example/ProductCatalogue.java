package org.example;

import java.util.*;

public class ProductCatalogue {

    private HashMap<String, Integer> productCatalogue;

    public ProductCatalogue(HashMap<String, Integer> productCatalogue) {
        this.productCatalogue = productCatalogue;
    }

    public String addProduct(String productName, Integer productQuantity){
        productCatalogue.put(productName, productQuantity);

        return productName + " added";
    }

    public String checkProduct(String productName){
        return productName + " is in stock: " + productCatalogue.get(productName).toString() + "\n";
    }

    public String updateProduct(String productName, Integer newProductQuantity){
        productCatalogue.replace(productName, newProductQuantity);

        return productName + " updated!" + "\n";
    }

    public String removeProduct(String productName){
        productCatalogue.remove(productName);

        return productName + " removed" + "\n";
    }

    public void viewInventory(){
        //https://stackoverflow.com/questions/5920135/printing-hashmap-in-java
        productCatalogue.forEach((key, value) -> System.out.println("\n" + key + " " + value + "\n"));
    }

    public boolean hasProduct(String productName) {
        return productCatalogue.containsKey(productName);
    }

//    addProduct(Parameters)
//    checkProduct(Parameters)
//    updateProduct(Parameters)
//    removeProduct(Parameters)
//    viewInventory(Parameters)
}
