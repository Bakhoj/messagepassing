package server;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import compute.ComputeEngine;
import server.server;
// Anders laver en masse så server har masser og masser af threads.
public class ServerRunner extends UnicastRemoteObject{
	protected ServerRunner() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;
	server server = new server();
	int read = 0;
	double sum = 0;
	double amount = 0;
	double avg = 0;
	
	//##############################
	//Playing with RMI
	ComputeEngine thread = new ComputeEngine();

		int i = thread.run1();
	//##############################
	
	public void run(){
		server.open_socket();
		System.out.println("Server started");
		server.client_connect();
		server.input_stream();
		server.output_stream();
		System.out.println("Connected to client");
		
		while(true){
			if(available() >0){
				temp_method();
				if(read == -1){
					System.err.println("Server terminated");
					server.close_socket();
					break;
				}
				calc_avg();
			}
		}
	}
	
	
	public int available(){
		try{
			return server.input.available();
		}
		catch(IOException e){
			System.out.println(e);
		}
		return 0;
	}
	
	
	public void temp_method(){
		try{
			read = 0;
			if(available()>0) {read = server.input.readByte();}
			if(read != -1 || read != 0){
				sum = sum + read;
				amount++;	
			}
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void calc_avg(){
		avg = (sum/amount);
		System.out.printf("The average temperatur is: %.2f \260" + "C \n", avg);
	}
	
	public double get_avg(){
		return avg;
	}
}
