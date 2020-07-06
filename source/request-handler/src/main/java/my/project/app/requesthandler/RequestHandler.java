package my.project.app.requesthandler;
import my.project.app.requesthandler.databaseobjects.order.OrderHandlerImpl;
import my.project.app.requesthandler.databaseobjects.product.ProductHandlerImpl;
import my.project.app.requesthandler.databaseobjects.quantity.Quantity;
import my.project.app.requesthandler.databaseobjects.quantity.QuantityHandlerImpl;
import my.project.app.requesthandler.databaseobjects.user.UserHandlerImpl;
import my.project.app.requesthandler.databaseobjects.product.Product;

import my.project.app.requesthandler.databaseobjects.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DuplicateKeyException;

@SpringBootApplication(exclude={MongoAutoConfiguration.class})
@ComponentScan
public class RequestHandler implements CommandLineRunner {

    UserHandlerImpl uh;
    ProductHandlerImpl ph;
    OrderHandlerImpl oh;
    QuantityHandlerImpl qh;

    @Autowired
    public RequestHandler(final UserHandlerImpl uh,
                          final ProductHandlerImpl ph,
                          final OrderHandlerImpl oh,
                          final QuantityHandlerImpl qh) {
        this.uh = uh;
        this.ph = ph;
        this.oh = oh;
        this.qh = qh;
        System.out.println("RequestHandler constructor");
    }


    public static void main(final String[] args) {
        SpringApplication.run(RequestHandler.class, args);
    }

    public final void run(final String... args) throws Exception {

        System.out.println("Adding example user");
        User myUser = new User("Michael", "Michaels", "michael@gmail.com", "Park avenue 1", "Michael");

        try {
            this.uh.put(myUser);

        } catch (DuplicateKeyException e) {
            System.out.println("email already in use:" + e);

        }
        User uu = uh.findByEmail(myUser.getEmail());
        System.out.println("myuser name: " + uu.getFirstName());


        Product alfa = new Product("Alfa Romeo Giulia", 765.98, "Cars", "Compact executive car");
        Product fiat = new Product("Fiat 500", 432, "Cars", "Rear-engined, 4 seat");
        Product ferrari = new Product("Ferrari Portofino", 77789, "Cars", "Sports car");
        Product lancia = new Product("Lancia Stratos", 55678, "Cars", "Italian sorts & rally car");
        try {
            this.ph.put(alfa);
            this.ph.put(fiat);
            this.ph.put(ferrari);
            this.ph.put(lancia);

        } catch (DuplicateKeyException e) {
            System.out.println("Duplicate product name:" + e);

        }

        try {
            this.qh.put(new Quantity(345, 54, alfa.getId()));
            this.qh.put(new Quantity(76, 54, fiat.getId()));
            this.qh.put(new Quantity(76, 54, ferrari.getId()));
            this.qh.put(new Quantity(0, 54, lancia.getId()));

        } catch (DuplicateKeyException e) {
            System.out.println("Duplicate product quuantity:" + e);

        }
    }
}
