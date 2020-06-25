package my.project.app.requesthandler;
import my.project.app.requesthandler.databaseobjects.product.ProductHandler;
import my.project.app.requesthandler.databaseobjects.product.ProductHandlerImpl;
import my.project.app.requesthandler.databaseobjects.user.UserHandlerImpl;
import my.project.app.requesthandler.databaseobjects.product.Product;
import my.project.app.requesthandler.databaseobjects.Quantity;
import my.project.app.requesthandler.databaseobjects.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={MongoAutoConfiguration.class})
@ComponentScan
public class RequestHandler implements CommandLineRunner {

    UserHandlerImpl uh;
    ProductHandler ph;


    @Autowired
    public RequestHandler(final UserHandlerImpl uh,
                          final ProductHandlerImpl ph) {
        this.uh = uh;
        this.ph = ph;
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
        User newUser = this.uh.findById(myUser.getId());

        System.out.println("name and surname got" + newUser.getFirstName() + " " + newUser.getLastName());

        User n = this.uh.findUser(newUser);
        System.out.println("n lastname: " + n.getLastName());

        ////////////////////////////////////////////////

        Product product = new Product("first product", 765.98, "some category", "some descripton", new Quantity(654765d, 122d));
        this.ph.put(product);

        System.out.println("found description: " + this.ph.findById(product.getId()).getProductDescription());
        this.ph.findProduct(product);


    }
}
