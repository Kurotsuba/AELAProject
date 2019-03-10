import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.*;

public class ExpressServer{
    public static void main(String[] args) throws RemoteException, NamingException {
        System.out.println("Constructing server implementation...");
        ExpressImpl DHL = new ExpressImpl();

        System.out.println("Binding server implementation to registry...");
        Context namingContext = new InitialContext();
        namingContext.bind("rmi:dhl", DHL);

        System.out.println("Waiting for invocations from clients...");
    }
}