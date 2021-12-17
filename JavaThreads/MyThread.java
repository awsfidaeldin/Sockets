class MyThread implements Runnable
{
	public void run()
	{
		
		for(int i=1;i<=10;i++)
		{
			System.out.println("Sub Thread "+i);
		try
		{
			Thread.sleep(50);	
		}
		
		 catch(InterruptedException ie)
		{
			System.out.println("Error" + ie);
		}
		}
	}	
public static void main(String[] args)
{
	MyThread Obj1 = new MyThread();
	Thread t1= new Thread(Obj1);
	t1.start();
	for(int i=1;i<=10;i++)
	{
	System.out.println("Main Thread "+i);
	try
	{
		Thread.sleep(100);
	}
	 catch(InterruptedException ie)
	{
		System.out.println("Error" + ie);
	}
	}
}
}


