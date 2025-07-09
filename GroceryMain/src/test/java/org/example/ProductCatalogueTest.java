//Final Submission, Unit Testing Grocery Inventory

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
        inventory.addProduct("Bread",1);


        System.setOut(new PrintStream(outContent));
    }

    @Test
    void addValidProduct() {
        String output = inventory.addProduct("Banana", 30);
        assertEquals("Banana - 30 pcs added!\n", output);
        assertEquals("30 pcs\n", inventory.getQuantity("Banana"));
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
        String output = inventory.checkProduct("Ice Cream");
        assertEquals("Product not found.\n",output);
    }

    @Test
    void updateExistingProduct() {
        String output = inventory.updateProduct("Bread", 25);
        assertEquals("Bread quantity updated to: 25\n", output);
        assertEquals("25 pcs\n", inventory.getQuantity("Bread"));
    }

    @Test
    void updateNonExistingProduct() {
        String output = inventory.updateProduct("Tofu", 10);
        assertEquals("Product not found.\n",output);
    }

    @Test
    void updateInvalidQuantityProduct() {
        String output = inventory.updateProduct("Cheese", -10);
        assertEquals("Quantity must be more than zero!\n",output);
    }

    @Test
    void removeExistingProduct() {
        String output = inventory.removeProduct("Eggs");
        assertEquals("Eggs removed!\n",output);
        assertEquals("Product not found.\n" , inventory.checkProduct("Eggs"));
    }

    @Test
    void removeNonExistingProduct() {
        String output = inventory.removeProduct("Pizza");
        assertEquals("Product not found.\n",output);
    }

    @Test
    void getQuantityOfExistingProduct() {
        String output = inventory.getQuantity("Cheese");
        assertEquals("5 pcs\n",output);
    }

    @Test
    void getQuantityOfNonExistingProduct() {
        String output = inventory.getQuantity("Tofu");
        assertEquals("Product not found.\n",output);
    }

    @Test
    void viewInventory() {
        //https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
        inventory.viewInventory();
        assertEquals("Current Inventory:\nCheese - 5 pcs\nEggs - 12 pcs\nMilk - 20 pcs\nBread - 1 pcs", outContent.toString().trim());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}