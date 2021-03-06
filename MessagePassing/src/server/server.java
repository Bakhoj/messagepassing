package server;

import java.net.*;
import java.rmi.RemoteException;
//import java.util.concurrent.ThreadPoolExecutor;
import java.io.*;

import compute.ComputeEngine;
//import compute.Compute;
//import compute.Task;

public class server {
int PortNumber = 1111;
ServerSocket MyService;
Socket clientSocket = null;
//Socket serviceSocket;
DataInputStream input;
PrintStream output;
//DataOutputStream output;

//##############################
//Playing with RMI
ComputeEngine thread = new ComputeEngine();

	int i = thread.run1();
//##############################
	public void open_socket(){
		try{
			MyService = new ServerSocket(PortNumber);
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public void client_connect(){
		try{
			clientSocket = MyService.accept();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void input_stream(){
		try{
			input = new DataInputStream(clientSocket.getInputStream());
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void output_stream(){
		try{
			output = new PrintStream(clientSocket.getOutputStream());
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void close_socket(){
		try{
			output.close();
			input.close();
			clientSocket.close();
			MyService.close();
			
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}
