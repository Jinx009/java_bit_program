package thread;

public class Testt
{
		public static void main(String[] args)
		{
			Sam sam = new Sam();
			
			Thread t = new Per(sam);
			
			Thread t1 = new Per1(sam);
			
			t1.start();
			t.start();
		}
}
