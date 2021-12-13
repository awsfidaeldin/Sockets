import java.net.*;
import java.io.*;

public class ServerT
{
public static void main(String args[])
{
  try{
    ServerSocket server=new ServerSocket(1300);
while(true)
{
  Socket serv=server.accept();
  new Service(serv).start();
}

  }
  catch(IOException ioe)
{
  System.out.println("Error"+ioe);
}
}
}
