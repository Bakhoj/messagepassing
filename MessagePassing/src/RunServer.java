import java.io.IOException;
import server.ServerNew;

public class RunServer {
	public static void main(String[] args) throws IOException{
//		ServerRunner server = new ServerRunner();
		ServerNew server = new ServerNew();
		server.run();
	}
}
