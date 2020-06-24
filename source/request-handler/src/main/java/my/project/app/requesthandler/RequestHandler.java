package my.project.app.requesthandler;
import my.project.app.requesthandler.databaseobjects.dbobjecthandlers.UserHandlerImpl;
import my.project.app.requesthandler.databaseobjects.dbobjects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude={MongoAutoConfiguration.class})
@ComponentScan
public class RequestHandler implements CommandLineRunner {

    UserHandlerImpl uh;

    @Autowired
    public RequestHandler(final UserHandlerImpl uh) {
        this.uh = uh;
        System.out.println("RequestHandler constructor");
    }


    public static void main(final String[] args) {
        SpringApplication.run(RequestHandler.class, args);
    }

    public final void run(final String... args) throws Exception {

        System.out.println("putting user");
        User myUser = new User("petar1", "tomic", "989898", "hrv v");
        this.uh.put(myUser);

        System.out.println("getting user");
        User newUser = this.uh.findByName(myUser.getFirstName());

        System.out.println("name and surname got" + newUser.getFirstName() + " " + newUser.getLastName());

    }
}
