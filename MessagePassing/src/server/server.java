package server;

import java.net.Socket;

public class server {
int PortNumber = 1111;
	
	
	public void open_socket(){
		Socket clientSocket = null;
		try{
			serviceSocket = MyService.accept();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}
