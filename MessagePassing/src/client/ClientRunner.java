package client;

import java.util.Scanner;
import client.client;
import client.TemperatureGenerator;
// LP laver noget på client, så den connecter igen og igen og igen og igen.
public class ClientRunner {
	client client = new client();
	Scanner scanner = new Scanner(System.in);
	String read_from_kb = null;
	TemperatureGenerator tempGen = new TemperatureGenerator();
	int temp;
	boolean program_start = false;
	
	public void run() {
		System.err.println("press: \t s + enter to start the program \n \t enter to give a temperature to the server \n \t c + enter to close the program \n");
		while(true){
			read_from_kb = scanner.nextLine();
			if(read_from_kb.equals("s")){
				client.open_socket();
				client.input_stream();
				client.output_stream();
				System.out.print("program startet");
				program_start = true;
			}
			
			else if(read_from_kb.equals("") && program_start){
				temp = tempGen.temperatureGen();
				client.output.write(temp);
				System.out.print("the temperature is " + temp + " \260" +"C");
			}
			
			else if(read_from_kb.equals("c") && program_start){
				client.output.write(-1);
				client.close_socket();
				program_start = false;
				System.err.println("program and server terminated");
				break;
			}
		}
	}
}
