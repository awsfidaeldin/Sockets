class Root extends Thread
{
public void run()
{
try
{
Thread.sleep(1000);
for(int i=65; i<=90; ++i)
System.out.print(i);
System.out.println();
}
catch(InterruptedException ie)
{
System.out.println("Error "+ie); 
}
}
}
class Multithread
{
public static void main(String []arg)
{
Root a=new Root();
a.start();
for(int i=1; i<=20; ++i)
System.out.print(i);
}
}