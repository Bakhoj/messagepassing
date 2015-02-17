package server;
import java.io.*;
import java.net.*;
import server.server;

public class ServerRunner {
	server server = new server();
	int read = 0;
	public void run(){
		server.open_socket();
		server.input_stream();
		server.output_stream();
		try{
			server.clientSocket = server.MyService.accept();
		}
		catch(IOException e){
			System.out.println(e);
		}
		
		temp_method();
		
		server.close_socket();
	}
	
	public void temp_method(){
		try{
			read = server.input.readByte();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}
