package comjava;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static List<Product> products = new ArrayList<>();

    static {
        Product product1 = new Product(1, "product 1");
        Product product2 = new Product(2, "product 2");

        products.add(product1);
        products.add(product2);
    }

    @GetMapping
    public List<Product> getProductList() {
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductDetail(@PathVariable int id) {
        System.out.println("getProductDetail");
        return products.stream().filter(ele -> ele.getId() == id).toList().get(0);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        product.setId(products.size() + 1);
        products.add(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        Product product = products.stream().filter(ele -> ele.getId() == id).toList().get(0);
        products.remove(product);
    }
}
