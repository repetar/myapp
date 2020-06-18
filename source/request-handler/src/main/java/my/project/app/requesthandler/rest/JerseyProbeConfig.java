package my.project.app.requesthandler.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyProbeConfig extends ResourceConfig {

    /**
     * Specifies where to find resources and registers binder.
     */
    public JerseyProbeConfig() {
        packages("my.project.app.requesthandler.rest");
    }
}
