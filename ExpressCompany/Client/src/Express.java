import java.rmi.*;

public interface Express extends Remote {
    String Info(String description) throws RemoteException;
}
