package client;

import java.io.IOException;
import java.net.Socket;

public class client {
int PortNumber = 1111;
	
	
	public void open_socket(){
		Socket MyClient;
		try{
			MyClient = new Socket("Machine name", PortNumber);
		}
		catch(IOException e){
			System.out.println(e);
		}
		
	}

}
