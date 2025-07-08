package org.example;

import java.util.*;

public class ProductCatalogue {

    private HashMap<String, Integer> productCatalogue;

    public ProductCatalogue(HashMap<String, Integer> productCatalogue) {
        this.productCatalogue = productCatalogue;
    }

    public String addProduct(String productName, Integer productQuantity){

        if(productCatalogue.containsKey(productName)){
            return "Product previously added" + "\n";
        }

        if(productQuantity < 0){
            return "Quantity must be more than zero!" + "\n";
        }

        productCatalogue.put(productName, productQuantity);

        return productName + " added" + "\n";
    }

    public String checkProduct(String productName){

        //https://stackoverflow.com/questions/15730134/opposite-of-contains-does-not-contain
        if(!productCatalogue.containsKey(productName)){
            return "Product key invalid" + "\n";
        }

        return productName + " is in stock: " + productCatalogue.get(productName).toString() + "\n";
    }

    public String updateProduct(String productName, Integer newProductQuantity){

        //https://stackoverflow.com/questions/15730134/opposite-of-contains-does-not-contain
        if(!productCatalogue.containsKey(productName)){
            return "Product key invalid" + "\n";
        }

        if(newProductQuantity < 0){
            return "Quantity must be more than zero!" + "\n";
        }

        productCatalogue.replace(productName, newProductQuantity);

        return productName + " updated!" + "\n" + "\n";
    }

    public String removeProduct(String productName){

        //https://stackoverflow.com/questions/15730134/opposite-of-contains-does-not-contain
        if(!productCatalogue.containsKey(productName)){
            return "Product key invalid" + "\n";
        }
        if(productCatalogue.containsKey(productName)){
            return "Product key invalid" + "\n";
        }
        productCatalogue.remove(productName);

        return productName + " removed" + "\n";
    }

    public void viewInventory(){
        //https://stackoverflow.com/questions/5920135/printing-hashmap-in-java
        productCatalogue.forEach((key, value) -> System.out.println("\n" + key + " " + value + "\n"));
    }

//    addProduct(Parameters)
//    checkProduct(Parameters)
//    updateProduct(Parameters)
//    removeProduct(Parameters)
//    viewInventory(Parameters)
}
