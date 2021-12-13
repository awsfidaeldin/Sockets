import java.net.*;
import java.io.*;
public class Client {
public static void main(String[] args) {
	try{
		Socket Client = new Socket("localhost",1500);
		System.out.println("Connected with server " + 
				Client.getInetAddress()+ ":" +Client.getPort());
		BufferedReader from_server = new BufferedReader(new InputStreamReader(Client.getInputStream()));
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter to_server = new PrintWriter (Client.getOutputStream(),true);
		String in, from_user;
		while (true)
		{	in = from_server.readLine();
			if (in.equals("done"))
			{
	           		System.out.println(from_server.readLine());
	           		break;
			}
           		System.out.println(in);
           		from_user= input.readLine();
			to_server.println(from_user);
		}
	}
	catch (IOException ioe)
	{
		System.out.println("Error" + ioe);
	}

	
}
}
