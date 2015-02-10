package server;

import java.io.IOException;
import java.net.*;

public class server {
int PortNumber = 1111;
	
	
	public void open_socket(){
		ServerSocket MyService;
		try{
			MyService = new ServerSocket(PortNumber);
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	public void 
}
