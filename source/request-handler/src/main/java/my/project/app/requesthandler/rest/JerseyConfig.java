package my.project.app.requesthandler.rest;

import org.glassfish.jersey.server.ResourceConfig;


public class JerseyConfig extends ResourceConfig
{

    public JerseyConfig() {
        packages("my.project.app.requesthandler.rest");
}

}
