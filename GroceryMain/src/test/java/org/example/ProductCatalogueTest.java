package org.example;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCatalogueTest {

    private ProductCatalogue inventory;

    @BeforeEach
    void setUp(){
        inventory = new ProductCatalogue(new HashMap<>());
        inventory.addProduct("Cheese",5);
        inventory.addProduct("Milk",2);
        inventory.addProduct("Eggs",12);
    }

    @Test
    void addValidProduct() {
        String output = inventory.addProduct("Chocolate", 100);
        assertEquals("Chocolate added!\n", output);
    }

    @Test
    void addInvalidProductQuantity() {
        String output = inventory.addProduct("Chocolate", -100);
        assertEquals("Quantity must be more than zero!\n", output);
    }

    @Test
    void addExistingProductName() {
        String output = inventory.addProduct("Cheese", 5);
        assertEquals("Product previously added!\n", output);
    }

    @Test
    void checkExistingProduct() {
        String output = inventory.checkProduct("Cheese");
        assertEquals("Cheese is in stock: 5\n",output);
    }

    @Test
    void checkNonExistingProduct() {
        String output = inventory.checkProduct("Soju");
        assertEquals("Product key invalid!\n",output);
    }

    @Test
    void updateExistingProduct() {
        String output = inventory.updateProduct("Cheese", 10);
        assertEquals("Cheese updated!\n",output);
    }

    @Test
    void removeProduct() {
    }

    @Test
    void viewInventory() {
    }
}