import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.*;

public class TestClient{
    public static void main(String[] args) throws NamingException, RemoteException{
        Context namingContext = new InitialContext();

        String url = "rmi://localhost/dhl";
        Express DHL = (Express) namingContext.lookup(url);

        Order order = new Order();
        String info = DHL.Info(order);
        System.out.println(info);
    }
}