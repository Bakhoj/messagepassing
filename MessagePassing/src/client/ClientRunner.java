package client;

import java.io.*;
import java.util.Scanner;
import java.net.*;
import client.client;
import client.TemperatureGenerator;


public class ClientRunner {
	client client = new client();
	Scanner scanner = new Scanner(System.in);
	String read_from_kb = null;
	TemperatureGenerator tempGen = new TemperatureGenerator();
	int temp;
	boolean program_start = false;
	
	public void run() {
		while(true){
			read_from_kb = scanner.nextLine();
			if(read_from_kb.equals("s")){
				client.open_socket();
				client.input_stream();
				client.output_stream();
				System.out.println("program startet");
				program_start = true;
//				read_from_kb = null;
			}
			
			else if(read_from_kb.equals("") && program_start){
				temp = tempGen.temperatureGen();
				client.output.write(temp);
				System.out.println("the temperature is " + temp + " degrees celcius");
//				read_from_kb = null;
			}
			
			else if(read_from_kb.equals("c") && program_start){
				client.output.write(-1);
				client.close_socket();
				program_start = false;
				System.out.println("program closed");
//				read_from_kb = null;
				break;
			}
		}
	}
}
