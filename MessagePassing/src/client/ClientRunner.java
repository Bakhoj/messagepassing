package client;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import client.client;
import client.TemperatureGenerator;
import java.io.Serializable;
import compute.Task;

// LP laver noget på client, så den connecter igen og igen og igen og igen.
public class ClientRunner {
	client client = new client();
	Scanner scanner = new Scanner(System.in);
	String read_from_kb = null;
	TemperatureGenerator tempGen = new TemperatureGenerator();
	int temp;
	boolean program_start = false;
	
	public void run() {
		System.err.println("Press: \t s + Enter to start the program \n \t The temperature is then sent to the server \n \t u + enter to get the average \n \t c + enter to close the program \n");
		while(true){
			read_from_kb = scanner.nextLine();
			if(read_from_kb.equals("s")){
				client.open_socket();
				client.input_stream();
				client.output_stream();
				System.out.print("program startet");
				program_start = true;
			
					while (program_start){
						
						temp = tempGen.temperatureGen();
						client.output.write(temp);
						System.out.print("the temperature is " + temp + " \260" +"C");

					if(read_from_kb.equals("u")){
						//get avg
					}
					
					else if (read_from_kb.equals("c")){
						client.output.write(-1);
						client.close_socket();
						program_start = false;
						System.err.println("program and server terminated");
						break;
						
					}
					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

