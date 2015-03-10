package client;

	import java.rmi.registry.LocateRegistry;
	import java.rmi.registry.Registry;
	import compute.Compute;
	
public class ComputeClient {
	public static void main (String args[]){
		if (System.getSecurityManager() == null) {
	        System.setSecurityManager(new SecurityManager());
    	}
		try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);
            TemperatureGenerator task = new TemperatureGenerator();
            int temp = comp.executeTask(task);
            System.out.println(temp);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
}
