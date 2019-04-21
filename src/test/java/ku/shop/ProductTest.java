package ku.shop;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    @DisplayName("Test stock product with positive number")
    public void test_stock_positive_number() {
        Product product = new Product("Cola", 19);
        product.stock(30);
        assertEquals(30, product.getQuantity());
    }

    @Test
    @DisplayName("Test stock product with negative number")
    public void test_stock_negative_number() {
        Product product = new Product("Cola", 19);
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    product.stock(-30);
                });
        assertEquals("Stock number must be positive", exception.getMessage());
        assertEquals(0, product.getQuantity());
    }

    @Test
    @DisplayName("Test pick product with positive number")
    public void test_pick_positive_number() {
        Product product = new Product("Cola", 19);
        product.stock(30);
        product.pick(15);
        assertEquals(15, product.getQuantity());
    }

    @Test
    @DisplayName("Test pick product with negative number")
    public void test_pick_negative_number() {
        Product product = new Product("Cola", 19);
        product.stock(30);
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    product.pick(-15);
                });
        assertEquals("Product quantity must be positive", exception.getMessage());
        assertEquals(30, product.getQuantity());
    }

    @Test
    @DisplayName("Test pick insufficient product")
    public void test_pick_insufficient_product() {
        Product product = new Product("Cola", 19);
        product.stock(30);
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    product.pick(35);
                });
        assertEquals("Insufficient product quantity", exception.getMessage());
        assertEquals(30, product.getQuantity());
    }
}