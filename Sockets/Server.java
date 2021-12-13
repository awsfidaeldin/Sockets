import java.io.IOException;
import java.net.*;


public class Server {
public static void main(String[] args) {
	
		try
		{
		ServerSocket server = new ServerSocket(1500);
		while (true)
		{
			Socket serv=server.accept();
			new Service(serv).start();
		}
		
		}
		catch(IOException ioe)
		 {
			 System.out.println("Error" + ioe);
		 }
	
	
	
	
	
	
	
	
	
	
	
}
}
