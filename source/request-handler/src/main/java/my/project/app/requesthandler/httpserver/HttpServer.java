package my.project.app.requesthandler.httpserver;

import my.project.app.requesthandler.rest.JerseyConfig;
import my.project.app.requesthandler.rest.JerseyProbeConfig;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.server.ServerConnector;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;

import java.io.Closeable;

public final class HttpServer implements Closeable {

    /**
     * Minimum number of threads to be used by the server.
     */
    private static final int MIN_THREADS = 4;

    /**
     * Maximum number of threads to be used by the server.
     */
    private static final int MAX_THREADS = 10;

    /**
     * Jetty server object.
     */
    private Server server;

    /**
     * Flag indicating whether the server is running.
     */
    private boolean serverRunning;

    public boolean isServerRunning() {
        return this.serverRunning;
    }

    public HttpServer() {
        this.server = configureJettyServer();
    }

    public final Server configureJettyServer() {

        String rootApiPath = "/app/endpoints/v1";
        QueuedThreadPool threadPool = new QueuedThreadPool(HttpServer.MAX_THREADS, HttpServer.MIN_THREADS);
        Server server = new Server(threadPool);

        // set connector

        ServerConnector generalServerConnector = new ServerConnector(server, 1,
                2, new HttpConnectionFactory());
        generalServerConnector.setName("generalConnector");
        generalServerConnector.setPort(8080);
        generalServerConnector.setIdleTimeout(30000);

        server.addConnector(generalServerConnector);

        ServletContextHandler generalContext = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        generalContext.setContextPath(rootApiPath);
        generalContext.setVirtualHosts(new String[]{"@generalConnector"});
        ServletHolder generalHolder = generalContext.addServlet(ServletContainer.class, "/*");
        generalHolder.setInitOrder(0);
        generalHolder.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,
                JerseyConfig.class.getCanonicalName());


        HandlerCollection collection = new HandlerCollection();
        collection.addHandler(generalContext);

        server.setHandler(collection);
        return server;

    }

    public boolean start() {
        boolean result;

        try {
            System.out.println("Starting the HTTP server..");

            this.server.start();
            this.serverRunning = true;
            result = true;
        } catch (Exception exception) {
            System.out.println("An error occurred while starting the HTTP server: " + exception.getMessage());
            result = false;
        }
        return result;
    }

    public void join() throws InterruptedException {
        this.server.join();
    }

    public void close() {
        try {
            this.server.stop();
            this.serverRunning = false;
        } catch (Exception exception) {
            System.out.println("An error occurred while stopping the HTTP server: " + exception);
        }
    }
}
