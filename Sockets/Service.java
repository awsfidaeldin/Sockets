import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;


public class Service extends Thread {
	private Socket serv;
	public Service (Socket serv)
	{
		this.serv=serv;
	}
	
	public void run() {
		try
		{
			BufferedReader from_client = new BufferedReader(new InputStreamReader(serv.getInputStream()));
			PrintWriter to_client =new PrintWriter(serv.getOutputStream(),true);
			long start_time =  System.currentTimeMillis();
			int count=0;
			while (true)
			{
				long current_time =  System.currentTimeMillis();
				long diff =  current_time - start_time;
				if (diff>60000)
				{
					to_client.println("done");
					to_client.println("your score is  [ "+count+" ]\n");
					serv.close();
					break;
				}
				Random randomGenerator = new Random();
			    	int x= randomGenerator.nextInt(10);
			    	int y= randomGenerator.nextInt(10);
			    	int z =randomGenerator.nextInt(10);
			    	int sum = x+y+z;
				to_client.println(" sum these three integers " +x+ "\t" +y+ "\t" +z+ "=");
				String input_client= from_client.readLine();
				int user_sum = Integer.parseInt(input_client);
				if (sum == user_sum)
					count++;
				
			}
		}
		catch (IOException ioe)
		{
			System.out.println("Error" + ioe);
		}
		
	}
}
