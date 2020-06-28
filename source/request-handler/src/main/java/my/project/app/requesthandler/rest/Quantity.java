package my.project.app.requesthandler.rest;

import my.project.app.requesthandler.databaseobjects.product.Product;
import my.project.app.requesthandler.databaseobjects.quantity.QuantityHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quantity")
public class Quantity {

    @Autowired
    private QuantityHandlerImpl quantityHandler;

    @GetMapping(value= "/{productId}")
    public ResponseEntity getQuantityByProductId(@PathVariable final String productId) {
        System.out.println("trying to find by id");
        return ResponseEntity.ok().body(quantityHandler.getQuantityByProductId(productId));

    }

}
