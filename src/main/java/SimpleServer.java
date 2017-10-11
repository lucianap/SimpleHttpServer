import handlers.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;


public class SimpleServer {

    public static void main( String[] args ) throws Exception
    {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(handler);
        handler.addServlet(HelloServlet.class, "/*");
        server.start();
        server.dumpStdErr();
        server.join();
    }

}


