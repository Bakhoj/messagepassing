package server;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import compute.ComputeSensor;

public class ServerNew implements ComputeSensor{
	public static final String RMISENSOR = "SensorPart";
	public static final String RMIOTHER = "OtherPart";
	int read = 0;
	double sum = 0;
	double amount = 0;
	double avg = 0;

	public ServerNew(){
		super();
	}
	public void run(){
		try{
			String name = RMISENSOR;
			//#########################
			//Valg af interface
			ComputeSensor engine = new ServerNew();
			ComputeSensor stub = (ComputeSensor) UnicastRemoteObject.exportObject(engine, 0);
			//#################
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("Server bound");
		} catch (Exception e) {
			System.out.println("Server exception");
			e.printStackTrace();
		}
		
//		while(true){
//			if(available() >0){
//				temp_method();
//				if(read == -1){
//					System.err.println("Server terminated");
//					server.close_socket();
//					break;
//				}
//				getAvg();
//			}
//		}
	}
//	public int available(){
//		try{
//			return server.input.available();
//		}
//		catch(IOException e){
//			System.out.println(e);
//		}
//		return 0;
//	}
//	public void temp_method(){
//		try{
//			read = 0;
//			if(available()>0) {read = server.input.readByte();}
//			if(read != -1 || read != 0){
//				sum = sum + read;
//				amount++;	
//			}
//		}
//		catch(IOException e){
//			System.out.println(e);
//		}
//	}

	@Override
	public double getAvg() {
		avg = (sum/amount);
		return avg;
	}
	@Override
	public String executeTask() {

		return null;
	}
}
