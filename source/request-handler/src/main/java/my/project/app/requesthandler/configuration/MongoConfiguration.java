package my.project.app.requesthandler.configuration;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import my.project.app.requesthandler.exceptions.ExecutionFailedException;
import my.project.app.requesthandler.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfiguration {

    private static final Logger logger = LogManager.getLogger(MongoConfiguration.class);

    @Autowired
    Config config;

    @Bean
    List getMongoPods() throws ExecutionFailedException{

        long remainingTime = Constants.MONGO_TIMEOUT;
        String svc = config.getMongoService();
        int replicas = Integer.parseInt(config.getMongoReplicas());

        while (remainingTime > 0) {
            try {
                InetAddress[] mongoPods = InetAddress.getAllByName(svc);
                if (mongoPods.length == replicas) {
                    List serverList = new ArrayList();
                    for (InetAddress address : mongoPods) {
                        logger.info("adding address" + address.toString());
                        serverList.add(new ServerAddress(address.getHostAddress(), Integer.parseInt(config.getMongoPort())));
                    }
                    return serverList;
                } else {
                    logger.info("Waiting for mongodb to be up.");
                }
            } catch (UnknownHostException e) {
                logger.info("Waiting for mongodb to be up.");
            }

            try {
                Thread.sleep(Constants.MONGO_SLEEP_TIME);
            } catch (InterruptedException e) {
                throw new ExecutionFailedException("Interrupted while waiting for mongo db pods.");
            }
            remainingTime -= Constants.MONGO_SLEEP_TIME;
        }
        throw new ExecutionFailedException("Timeout while waiting for mongo db PODs.");
    }

    @Bean
    public MongoClient getClient() throws ExecutionFailedException {

        return new MongoClient(getMongoPods());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        return new MongoTemplate(getClient(), Constants.DATABASE_NAME);
    }
}


