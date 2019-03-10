import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class ExpressImpl extends UnicastRemoteObject implements Express{
    public ExpressImpl() throws RemoteException{

    }

    public String Info(Order order) throws RemoteException{
        String result = order.getId() + " " + order.getTime() + " " + order.getStatus() + "\n";
        return result + "Processing";
    }
}