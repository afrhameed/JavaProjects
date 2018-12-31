//knight's tour problem
//HELP FROM   http://algorithms.tutorialhorizon.com/backtracking-knights-tour-problem/
/*Project Info
	This code was used to solve the Knight's Tour problem:

	A knight's tour is a sequence of moves of a knight on 
	a chessboard such that the knight visits every square 
	only once.  -Wikipedia
*/


public class Knight {

	public static void main(String[] args){
		
		System.out.println(KT(0,0));
		
		for (int[] i : chessBoard) {
            for (int j : i) {
            	System.out.printf(" %2d ", j);
            }
            System.out.println();
        }
	}
	static int[][] chessBoard=new int[8][8];
	static int path=0;
	public static boolean KT(int x,int y){
		chessBoard[x][y]=0;
		return KT1(x,y,0);
	}
	private static boolean KT1(int x,int y, int n){
		if(chessBoard[x][y]!=0){
			return false;
		}
		chessBoard[x][y]=path++;
		//System.out.println(path+" x:"+x+" y:"+y);
		if(n==63){
			return true;
		}
		if (canMove(x + 2, y + 1)
				&& KT1(x + 2, y+ 1, n + 1)) {
			return true;
		}

		if (canMove(x + 1, y + 2)
				&& KT1(x + 1, y + 2, n + 1)) {
			return true;
		}

		if (canMove(x- 1, y + 2)
				&& KT1(x - 1, y + 2, n + 1)) {
			return true;
		}

		if (canMove(x- 2, y+ 1)
				&& KT1(x- 2, y + 1, n+ 1)) {
			return true;
		}

		if (canMove(x - 2, y- 1)
				&& KT1(x - 2, y - 1, n + 1)) {
			return true;
		}

		if (canMove(x - 1, y - 2)
				&& KT1(x - 1, y - 2, n + 1)) {
			return true;
		}

		if (canMove(x+ 1, y - 2)
				&& KT1(x+ 1, y - 2, n + 1)) {
			return true;
		}

		if (canMove(x + 2, y - 1)
				&& KT1(x+ 2, y- 1, n + 1)) {
			return true;
		}
		chessBoard[x][y]=0;
		path--;
		return false;		
	}
	public static boolean canMove(int x, int y) {
		if (x >= 0 && y >= 0 && x < 8 && y < 8) {
			return true;
		}
		return false;
	}	
}
