package client;

import java.net.*;
import java.io.*;

public class client {
int PortNumber = 1111;
String machine_Name1 = "Lars-Bærbar";
String machine_Name2 = "Bæk-Studie";
String machine_Name3 = "Gamer-Bæk";
Socket MyClient;
DataInputStream input;
PrintStream output;
//DataOutputStream output;

	public void open_socket(){
		try{
			// is machine_Name1 chosen - LP's com
			// is machine_Name2 chosen - Bæk's com
			MyClient = new Socket(machine_Name3, PortNumber);
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
	public void close_socket() {
		try {
			output.close();
			input.close();
		MyClient.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}

}
