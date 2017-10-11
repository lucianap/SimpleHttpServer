import handlers.FaultyServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;


public class SimpleServer {

    public static void main( String[] args ) throws Exception
    {
        Server server = new Server(9090);
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(handler);
        handler.addServlet(FaultyServlet.class, "/faulty");
        server.start();
        server.dumpStdErr();
        server.join();
    }

}


