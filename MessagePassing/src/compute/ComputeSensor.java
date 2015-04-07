package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ComputeSensor extends Remote{
	String executeTask() throws RemoteException;
	double getAvg() throws RemoteException;
}
