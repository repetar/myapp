package my.project.app.requesthandler.databaseobjects.dbobjecthandlers;

import my.project.app.requesthandler.databaseobjects.dbobjects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories(mongoTemplateRef = "mainMongoTemplate")
@Repository
public class UserHandler {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserHandler(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void put(final User user) {
        this.mongoTemplate.save(user);
    }


    public User getUser(final String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        return this.mongoTemplate.findOne(query, User.class);
    }

    public void deleteUser(final User user) {
        this.mongoTemplate.remove(user);
    }
}
