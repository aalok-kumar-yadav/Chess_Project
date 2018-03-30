package chess_package;

public class Rook_Class extends Piece_Class {
	Rook_Class(String col, char sym){
		this.color=col;
		this.symbol=sym;
	}
	Rook_Class()
	{
	}
public boolean move_piece(int x1,int y1,int x2,int y2) {
		
		boolean mov_ret=false;
		Board_Class board_class_obj = new Board_Class();
		Piece_Class temp_board[][]= board_class_obj.get_board();
		
		int abs1=Math.abs(x2-x1);	//assigning absolute value of coordinate difference
		int abs2=Math.abs(y2-y1);
		
		if((abs1==0&&abs2!=0)||(abs1!=0&&abs2==0)) {
			
			int count=1;
			if(x2<x1&&y2<y1) {
				while(count<=abs1) {	// upper  direction
					if(temp_board[x1-count][y1].symbol==0) {
						count++;
					}else  {
						count--;
						break;
					}
					
				}
			}
			
			else if(x2<x1&&y2>y1) {
				while(count<abs1) {	// lower direction
					if(temp_board[x1+count][y1].symbol==0) {
						count++;
					}else {
						count--;
						break;
					}
					
				}
			}
			else if(x2>x1&&y2<y1) {
				while(count<abs1) {	// left direction
					if(temp_board[x1][y1-count].symbol==0) {
						count++;
					}else  {
						count--;
						break;
					}
				}
			}
			else if(x2>x1&&y2>y1) {
				while(count<abs1) {	// right direction
					if(temp_board[x1][y1+count].symbol==0) {
						count++;
					}else  {
						count--;
						break;
					}
				}
			}
		
			if(temp_board[x2][y2].symbol==0&&count==abs1+1) {
				mov_ret=true;
			}else if(temp_board[x2][y2].symbol!=0&&count==abs1&&board_class_obj.player_color!=temp_board[x2][y2].color) {
				mov_ret=true;
			}
		}
		
		return mov_ret;
	}
}
