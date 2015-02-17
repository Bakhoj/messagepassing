import java.io.IOException;
import server.ServerRunner;

public class RunServer {
	public static void main(String[] args) throws IOException{
		ServerRunner server = new ServerRunner();
		server.run();
	}
}
