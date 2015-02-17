package server;
import java.io.*;

import server.server;

public class ServerRunner {
	server server = new server();
	int read = 0;
	int sum = 0;
	int amount = 0;
	double avg = 0;
	
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
		
		while( available() > 0 || true){
			temp_method();
			if(read == -1){
				server.close_socket();
				break;
			}
			calc_avg();
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
		System.out.println("The average temperatur is: " + avg + ".");
	}
}
