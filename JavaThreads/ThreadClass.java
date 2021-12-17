import java.util.Scanner;

// Excercise to illustrate Java Threads (Extending the Thread Class)
// Thread 1 printing the even numbers.
// Thread 2 printing the odd numbers.
// Using some usefull function members of class Thread.
public class ThreadClass
{
  public static void main(String argv[])
 {
 int xy;
   System.out.println("I'm the main Thread");
   System.out.println("Enter XY value ");
   Scanner scanner=new Scanner(System.in);
   xy=scanner.nextInt();
   for(xy=0;xy<=10;xy++)
   		System.out.println("xy = " + xy);
   t1 athread1=new t1();
   t2 athread2=new t2();
   athread1.start();
   athread2.start();
 }
}

class t1 extends java.lang.Thread
{
   public void run()
  {
     try
      {
	Thread.sleep(100);
      }
     catch(InterruptedException ie)
      {
	System.err.println("Thread was Interrupted");
      }

      int x;
      this.setPriority(Thread.MAX_PRIORITY);
      System.out.println("I'm the sub Thread 1 --> " + currentThread().getName());
      System.out.println("Thread Priority = " + this.getPriority() );
      for(x=0;x<=10;x++)
         if(x%2==0)
	  System.out.println("x = "+ x);
   }
}

class t2 extends java.lang.Thread
{
   public void run()
  {
     int y;
     this.setPriority(Thread.MIN_PRIORITY);
     System.out.println("I'm the sub Thread 2 --> " + currentThread().getName());
     System.out.println("Thread Priority = " + this.getPriority() );
     for(y=0;y<=10;y++)
         if(y%3==0)
	 System.out.println("y = "+ y);
  }
}
