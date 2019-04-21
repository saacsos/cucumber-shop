package ku.shop;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("Stock (.*) product (.+) with price (.+)")
    public void a_product_with_price_exists(int quantity, String name, double price) {
        catalog.addProduct(name, price, quantity);
    }

    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name, quant);
        order.addItem(prod, quant);
    }

    @When("I cannot buy (.+) with quantity (.+) because (.+)")
    public void i_cannot_buy(String name, int quantity, String errorMessage) {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    Product product = catalog.getProduct(name, quantity);
                    order.addItem(product, quantity);
                });
        assertEquals(errorMessage, exception.getMessage());
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

    @Then("The stock left (.+) of (.+)")
    public void the_stock_left(int quantity, String name) {
        Product product = catalog.getProduct(name);
        assertEquals(quantity, product.getQuantity());
    }
}

