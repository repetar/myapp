package my.project.app.requesthandler.databaseobjects.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityHandlerImpl {

    @Autowired
    private QuantityRepository quantityRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void put(final Quantity quantity) {
        quantityRepository.save(quantity);

    }

    public Quantity getQuantityByProductId(final String productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        List<Quantity> quantity = mongoTemplate.find(query, Quantity.class);
        if (quantity.size() > 1) {
            System.out.println("problem quantity more than 1");
        }
        return quantity.get(0);
    }
}
