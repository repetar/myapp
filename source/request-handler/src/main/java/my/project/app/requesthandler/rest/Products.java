package my.project.app.requesthandler.rest;

import my.project.app.requesthandler.databaseobjects.product.Product;
import my.project.app.requesthandler.databaseobjects.product.ProductHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/products")
public class Products {

    @Autowired
    private ProductHandlerImpl productHandler;

    @GetMapping(value="/")
    public ResponseEntity<List<Product>> getAllProducts() {
        System.out.println("getting all products");
        return ResponseEntity.ok().body(this.productHandler.findAll());
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable final String id) {
        System.out.println("trying to find by id");
        return ResponseEntity.ok().body(this.productHandler.findById(id));

    }

    @PostMapping("/")
    public ResponseEntity<String> putProduct(@RequestBody final Product product) {
        try {
            this.productHandler.put(product);
            System.out.println("post product info: " + product.getId() + " : " + product.getProductDescription());
            return ResponseEntity.ok().body("Added product id: " + product.getId());

        } catch (DuplicateKeyException e) {
            return ResponseEntity.ok().body("A product with the given name already exists");
        }

    }
}
