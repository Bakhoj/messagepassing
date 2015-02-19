package client;

import java.io.*;
import java.util.Scanner;
import java.net.*;
import client.client;
import client.TemperatureGenerator;


public class ClientRunner {
	client client = new client();
	Scanner scanner = new Scanner(System.in);
	String read_from_kb = scanner.nextLine();
	TemperatureGenerator tempGen = new TemperatureGenerator();
	int temp;
	boolean program_start = false;
	
	public void run() {
		
		if(read_from_kb.equals("s")){
			client.open_socket();
			System.out.println("program startet");
			program_start = true;
		}
		
		if(read_from_kb.equals("") && program_start){
			temp = tempGen.temperatureGen();
			client.output.write(temp);
			System.out.println(temp);
		}
		
		if(read_from_kb.equals("c") && program_start){
			client.output.write(-1);
			client.close_socket();
			program_start = false;
			System.out.println("program closed");
		}
	}
}
