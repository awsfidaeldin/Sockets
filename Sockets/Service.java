import java.net.*;
import java.io.*;

class Service extends Thread
{

Socket serv;
public Service(Socket serv)
{
  this.serv=serv;
}

public void run()
{
  try
  {
        //Display connection details
        System.out.println("Receiving Request From"+serv.getInetAddress()+ ":" +serv.getPort());
        //Write the current time to the client socket

	PrintStream p=new PrintStream(serv.getOutputStream());
	p.println(new java.util.Date());

        //Close connection
        serv.close();
  }
  catch(IOException ioe)
  {
    System.out.println("Error "+ioe);
  }
}



}
