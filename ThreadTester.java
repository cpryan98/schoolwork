
public class ThreadTester 
{
	private static String name = "";
	public ThreadTester(String filename)
	{
		name = filename;
	}
	public void setName(String filename)
	{
		name = filename;
	}
	public static String getName()
	{
		return name;
	}
	public static void main(String[] args)
	{
		Runnable r1 = new Multi("words.txt");
		Thread t1 = new Thread(r1);
		t1.start();
		
	}
}
