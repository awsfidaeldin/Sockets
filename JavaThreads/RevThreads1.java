import java.util.Scanner;

public class RevThreads1{

	public static void main(String args[])
	{

		try{
            // reading a single integer from System.in
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your array size: ");

            //This method scans the next token of the input as an int.
            //To retrieve a username I would probably use sc.nextLine().
			int size = scanner.nextInt();
            int array[] = new int [size];

   			int i,j;
			System.out.print("Enter your array elements: ");
			for (i=0;i<array.length;i++)
				array[i]=scanner.nextInt();
            //
			for (i=0,j=array.length-1;i<array.length/2;i++,j--){
				Thread t = new Thread(new Reverse(array,i,j));
                t.start();
				t.join();
			}

			System.out.print("The new reversed array is: ");
			for (i=0;i<array.length;i++)
				System.out.print(array[i] + "  ");
			System.out.println();
        }
		   catch(Exception e)
		   {
				System.out.println("Error" + e);
		   }
     }
}


class Reverse implements Runnable {
    int array[],i,j;
    public Reverse (int array[], int i, int j){
	this.array=array;
	this.i=i;
	this.j=j;
    }

    public void run () {

      try {
	    int temp=array[i];
	    array[i]=array[j];
	    array[j]=temp;
       } catch (Exception e) {
        System.out.println("Error" + e);
      }
    }
}
