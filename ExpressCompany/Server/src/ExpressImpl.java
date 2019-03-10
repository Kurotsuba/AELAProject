import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class ExpressImpl extends UnicastRemoteObject implements Express{
    public ExpressImpl() throws RemoteException{

    }

    public String Info(String description) throws RemoteException{
        return description + " Processing";
    }
}