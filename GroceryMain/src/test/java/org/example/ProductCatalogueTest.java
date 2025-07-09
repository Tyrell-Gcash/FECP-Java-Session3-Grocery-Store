package org.example;

import java.util.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCatalogueTest {

    //https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ProductCatalogue inventory;

    @BeforeEach
    void setUp(){
        inventory = new ProductCatalogue(new HashMap<>());
        inventory.addProduct("Cheese",5);
        inventory.addProduct("Milk",20);
        inventory.addProduct("Eggs",12);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    void addValidProduct() {
        String output = inventory.addProduct("Banana", 30);
        assertEquals("Banana - 30 pcs added!\n", output);
    }

    @Test
    void addExistingProductName() {
        String output = inventory.addProduct("Milk", 50);
        assertEquals("Product previously added. Milk quantity updated\n", output);
    }

    @Test
    void addInvalidProductQuantity() {
        String output = inventory.addProduct("Chocolate", -100);
        assertEquals("Quantity must be more than zero!\n", output);
    }

    @Test
    void checkExistingProduct() {
        String output = inventory.checkProduct("Milk");
        assertEquals("Milk is in stock: 20\n",output);
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
    void updateNonExistingProduct() {
        String output = inventory.updateProduct("Soju", 10);
        assertEquals("Product key invalid!\n",output);
    }

    @Test
    void updateInvalidQuantityProduct() {
        String output = inventory.updateProduct("Cheese", -10);
        assertEquals("Quantity must be more than zero!\n",output);
    }

    @Test
    void removeExistingProduct() {
        String output = inventory.removeProduct("Cheese");
        assertEquals("Cheese removed!\n",output);
    }

    @Test
    void removeNonExistingProduct() {
        String output = inventory.removeProduct("Soju");
        assertEquals("Product key invalid!\n",output);
    }

    @Test
    void viewInventory() {
        //https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
        inventory.viewInventory();
        assertEquals("Current Inventory:\nCheese - 5 pcs\nEggs - 12 pcs\nMilk - 20 pcs", outContent.toString().trim());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}