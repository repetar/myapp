package my.project.app.requesthandler.configuration;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfiguration {

    @Bean
    public MongoClient getClient() throws UnknownHostException {

        InetAddress[] mongoPods = InetAddress.getAllByName("example-mongodb-svc");
        List serverList = new ArrayList();
        for (InetAddress address : mongoPods) {
            System.out.println("adding address" + address.toString());
            serverList.add(new ServerAddress(address.getHostAddress(), 27017));
        }
        return new MongoClient(serverList);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        return new MongoTemplate(getClient(), "mytestdb");
    }
}


