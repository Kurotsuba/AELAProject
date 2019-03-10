import java.rmi.*;

public interface Express extends Remote{
    String Info(Order order) throws RemoteException;
}