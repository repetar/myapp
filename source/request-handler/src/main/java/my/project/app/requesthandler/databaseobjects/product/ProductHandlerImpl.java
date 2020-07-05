package my.project.app.requesthandler.databaseobjects.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductHandlerImpl implements ProductHandler {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductHandlerImpl() {
    }

    public void put(final Product product) {
        this.productRepository.save(product);
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(final String id) {
        return this.productRepository.findById(id).get();
    }

    public Product findProduct (Product product) {
        Example<Product> example = Example.of(product);
        return this.productRepository.findOne(example).get();
    }
}
