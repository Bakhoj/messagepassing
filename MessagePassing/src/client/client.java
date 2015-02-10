package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.io.*;

public class client {
int PortNumber = 1111;
Socket MyClient;
DataInputStream input;
PrintStream output;
//DataOutputStream output;

	public void open_socket(){
		try{
			MyClient = new Socket("Machine name", PortNumber);
		}
		catch(IOException e){
			System.out.println(e);
		}
		
	}
	
	public void input_stream(){
		try{
			input = new DataInputStream(MyClient.getInputStream());
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void output_stream(){
		try{
			output = new PrintStream(MyClient.getOutputStream());
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
/*	public void output_stream(){
		try{
			output = new DataOutputStream(MyClient.getOutputStream());
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
*/

}
