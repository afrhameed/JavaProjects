//Project 8
//Afreen Hameed 

/*Project Info
	This code was used to generate a TicTacToe player that never loses.
*/



public class TTT_ah104 implements TicTacToe {
	
	private int[] board;
	private int[] vboard;
	
    public void game(){
    	board = new int[10];
    	board[0]=-1;
    	vboard = new int[10];
    	vboard[0]=-1;
    	
    	//66 opponent
    	//99 me
    }
	
	public int move(int loc){
		
		if(loc==0){
			board[5]=99;
			return 5;
		}
		
		else {
			
			board[loc] =66 ;
		}
		loc=lose(99);
		if(loc>0){
			board[loc]=99;
			return loc;
		}
		loc=lose(66);
		if(loc>0){
			board[loc]=99;
			return loc;
		}
		if (board[5]==0){
			board[5]=99;
			return 5;
		}
		int[] row={1,3,7,9};
		for(int num:row){
			if (board[num]==0){
				board[num]=99;
				return num;
			}
		}
		for(int a=1;a<10;a++){
			if(board[a]==0){
				board[a]=99;
				return a;
			}
		}
		
		

		return 1;
	}
	
	private int lose(int player){ 
		
	
    for(int i=1;i<10;i++){
			
			for(int c=0;c<10;c++){
				vboard[c]=board[c];
			}
			if(vboard[i]==0){
				vboard[i]=player;
				if(win()){
					return i;
			}
			
			}
    }
    return -1;
    
		
	}
	

	
	private boolean win(){ 
		if((vboard[1]==vboard[2] && vboard[2]==vboard[3]  && vboard[1]!=0) ||
		   (vboard[4]==vboard[5] && vboard[5]==vboard[6]  && vboard[4]!=0) ||
		   (vboard[7]==vboard[8] && vboard[8]==vboard[9]  && vboard[7]!=0) ||
		   (vboard[1]==vboard[4] && vboard[4]==vboard[7]  && vboard[1]!=0) ||
		   (vboard[2]==vboard[5] && vboard[5]==vboard[8]  && vboard[2]!=0) ||
		   (vboard[3]==vboard[6] && vboard[6]==vboard[9]  && vboard[3]!=0) ||
		   (vboard[1]==vboard[5] && vboard[5]==vboard[9]  && vboard[1]!=0) ||
		   (vboard[3]==vboard[5] && vboard[5]==vboard[7]  && vboard[3]!=0) 
				){
			return true;
		}
		return false;
	}
	
	public boolean help(int player){//testing program
		if((board[1]==board[2] && board[2]==board[3]  && board[1]!=0) ||
				   (board[4]==board[5] && board[5]==board[6]  && board[4]==player) ||
				   (board[7]==board[8] && board[8]==board[9]  && board[7]==player) ||
				   (board[1]==board[4] && board[4]==board[7]  && board[1]==player) ||
				   (board[2]==board[5] && board[5]==board[8]  && board[2]==player) ||
				   (board[3]==board[6] && board[6]==board[9]  && board[3]==player) ||
				   (board[1]==board[5] && board[5]==board[9]  && board[1]==player) ||
				   (board[3]==board[5] && board[5]==board[7]  && board[3]==player) 
						){
					return true;
				}
				return false;
		
	}

}