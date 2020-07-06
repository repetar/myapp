package my.project.app.requesthandler.rest;

import my.project.app.requesthandler.databaseobjects.quantity.QuantityHandlerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quantity")
public class Quantity {

    private static final Logger logger = LogManager.getLogger(Quantity.class);

    @Autowired
    private QuantityHandlerImpl quantityHandler;

    @GetMapping(value= "/{productId}")
    public ResponseEntity getQuantityByProductId(@PathVariable final String productId) {
        logger.info("trying to find by id");
        return ResponseEntity.ok().body(this.quantityHandler.getQuantityByProductId(productId));

    }

}
