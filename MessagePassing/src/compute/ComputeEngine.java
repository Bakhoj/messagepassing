package compute;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import compute.ComputeSensor;
import compute.Task;

public class ComputeEngine implements ComputeSensor{
	public ComputeEngine() {
		super();
	}
	
	public <T> T executeTask(Task<T> t) {
		return t.execute();
	}
	
	public int run1(){
		try{
			String name = "run1";
			ComputeSensor engine = new ComputeEngine();
			ComputeSensor stub = (ComputeSensor) UnicastRemoteObject.exportObject(engine, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.out.println("ComputeEngine exception");
			e.printStackTrace();
		}

		return 0;
	}
	
	public static void main(String[] args){
		if(System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		}
		try{
			String name = "Compute";
			ComputeSensor engine = new ComputeEngine();
			ComputeSensor stub = (ComputeSensor) UnicastRemoteObject.exportObject(engine, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.out.println("ComputeEngine exception");
			e.printStackTrace();
		}
	}
}
