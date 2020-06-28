package my.project.app.requesthandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.project.app.requesthandler.databaseobjects.order.Order;
import my.project.app.requesthandler.databaseobjects.order.OrderHandlerImpl;
import my.project.app.requesthandler.databaseobjects.order.OrderStatus;
import my.project.app.requesthandler.databaseobjects.product.ProductHandler;
import my.project.app.requesthandler.databaseobjects.product.ProductHandlerImpl;
import my.project.app.requesthandler.databaseobjects.user.UserHandlerImpl;
import my.project.app.requesthandler.databaseobjects.product.Product;
import my.project.app.requesthandler.databaseobjects.product.Quantity;
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
    ProductHandlerImpl ph;
    OrderHandlerImpl oh;


    @Autowired
    public RequestHandler(final UserHandlerImpl uh,
                          final ProductHandlerImpl ph,
                          final OrderHandlerImpl oh) {
        this.uh = uh;
        this.ph = ph;
        this.oh = oh;
        System.out.println("RequestHandler constructor");
    }


    public static void main(final String[] args) {
        SpringApplication.run(RequestHandler.class, args);
    }

    public final void run(final String... args) throws Exception {
/*
        System.out.println("putting user");
        User myUser = new User("petar1", "tomic", "989898", "hrv v", "password");
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
        System.out.println("again: " + this.ph.findProduct(product).getProductDescription());

        ////////////////////////////////////////////////

        Order oo = new Order("878765",
                OrderStatus.IN_PROGRESS,
                "fff",
                "fff",
                n.getId(),
                product.getId());

        this.oh.put(oo);
        System.out.println("get order :" + this.oh.findById(oo.getId()).getDeliveryDate());
        System.out.println("get user by user id :" + this.uh.findById(newUser.getId()).getFirstName());
        System.out.println("get user by id :" + this.uh.findById(newUser.getId()).getFirstName());

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(product));
        System.out.println(objectMapper.writeValueAsString(oo));

*/
    }
}
