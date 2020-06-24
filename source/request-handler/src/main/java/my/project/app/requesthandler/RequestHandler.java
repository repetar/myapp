package my.project.app.requesthandler;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import my.project.app.requesthandler.databaseobjects.dbobjecthandlers.UserHandler;
import my.project.app.requesthandler.databaseobjects.dbobjects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude={MongoAutoConfiguration.class})
@ComponentScan
@EnableMongoRepositories(mongoTemplateRef = "mainMongoTemplate")
public class RequestHandler implements CommandLineRunner {

    UserHandler uh;

    @Autowired
    public RequestHandler(final UserHandler uh) {
        this.uh = uh;
        System.out.println("RequestHandler constructor");
    }


    public static void main(final String[] args) {
        SpringApplication.run(RequestHandler.class, args);
    }

    public final void run(final String... args) throws Exception {

        System.out.println("putting user");
        User myUser = new User("petar", "tomic", "989898", "hrv v");
        this.uh.put(myUser);

        System.out.println("getting user");
        User newUser = this.uh.getUser(myUser.getId().toString());

        System.out.println("name and surname got" + newUser.getFirstName() + " " + newUser.getLastName());

    }
}
