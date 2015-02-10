package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.io.*;

public class server {
int PortNumber = 1111;
ServerSocket MyService;
Socket clientSocket = null;
Socket serviceSocket;
DataInputStream input;
PrintStream output;
//DataOutputStream output;

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
			serviceSocket = MyService.accept();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void input_stream(){
		try{
			input = new DataInputStream(serviceSocket.getInputStream());
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void output_stream(){
		try{
			output = new PrintStream(serviceSocket.getOutputStream());
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}
