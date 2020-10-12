
public class HW8Drv 
{
	public static void main(String[] args) 
	{
		QueensPuzzle a = new QueensPuzzle(8,8);
		a.placeQueen(3,0);
		a.placeQueen(5,1);
		a.placeQueen(7,2);
		a.placeQueen(1,3);
		a.placeQueen(6,4);
		a.placeQueen(0,5);
		a.placeQueen(2,6);
		a.placeQueen(4,7);

		System.out.println("Queens safe : " + a.allQueensSafe());
		System.out.println(a.toString());
	}
}
