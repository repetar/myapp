package my.project.app.requesthandler.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "file:/usr/src/app/config/config.yml", factory = ConfigFactory.class)
public class Config {


    public Config() {

    }

    public String mongoReplicas;

    public String mongoService;

    public String waitTimeout;

    public String mongoPort;

    public String getMongoReplicas() {
        return mongoReplicas;
    }

    public void setMongoReplicas(String mongoReplicas) {
        this.mongoReplicas = mongoReplicas;
    }

    public String getMongoService() {
        return mongoService;
    }

    public void setMongoService(String mongoService) {
        this.mongoService = mongoService;
    }

    public String getWaitTimeout() {
        return waitTimeout;
    }

    public void setWaitTimeout(String waitTimeout) {
        this.waitTimeout = waitTimeout;
    }

    public String getMongoPort() {
        return mongoPort;
    }

    public void setMongoPort(String mongoPort) {
        this.mongoPort = mongoPort;
    }

}
