package client;

	import java.rmi.registry.LocateRegistry;
	import java.rmi.registry.Registry;
	import compute.ComputeSensor;
	import static server.ServerNew.RMISENSOR;
public class ComputeClient {
	public static void main (String args[]){
		try {
            String name = RMISENSOR;
            Registry registry = LocateRegistry.getRegistry(args[0]);
            ComputeSensor comp = (ComputeSensor) registry.lookup(name);
            TemperatureGenerator task = new TemperatureGenerator();
            int temp = comp.executeTask(task);
            System.out.println(temp);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
}
