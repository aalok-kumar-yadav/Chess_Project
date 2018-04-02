package chess_package;

public class King_Class extends Piece_Class {		//King class
	
	King_Class(String col,char sym, String name){		//King constructor
		this.color=col;
		this.symbol=sym;
		this.name=name;
	}
	
	public  boolean move_piece(int x1,int y1,int x2,int y2){		//move_piece function
		
		boolean mov_ret=false;
		Board_Class board_class_obj = new Board_Class();
		Piece_Class temp_board[][]= board_class_obj.get_board();
		
		int abs1=Math.abs(x2-x1);	//assigning absolute value of coordinate difference
		int abs2=Math.abs(y2-y1);
		
		if((abs1==1&&abs2==0)||(abs1==0&&abs2==1)||(abs1==1&&abs2==1)){
			if(temp_board[x2][y2]==null) {
				mov_ret=true;
			}
			else if((board_class_obj.player_color!=temp_board[x2][y2].color)&&(temp_board[x2][y2]!=null)) {
				mov_ret=true;
			}	
		}
		return mov_ret;
	}  
	
	} //end of king class
