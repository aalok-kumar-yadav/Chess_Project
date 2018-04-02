package chess_package;

public class Rook_Class extends Piece_Class {		//Rook class 
	
	Rook_Class(String col, char sym, String name){
		this.color=col;
		this.symbol=sym;
		this.name=name;
	}
	Rook_Class()
	{
	}
	
public boolean move_piece(int x1,int y1,int x2,int y2) {		//move_piece function
		
		boolean mov_ret=false;
		Board_Class board_class_obj = new Board_Class();
		Piece_Class temp_board[][]= board_class_obj.get_board();
		
		int abs1=Math.abs(x2-x1);	//assigning absolute value of coordinate difference
		int abs2=Math.abs(y2-y1);
		
		if((abs1==0&&abs2!=0)||(abs1!=0&&abs2==0)) {
		
			int count=1;
			while(count<=abs1) {	
				int row,col;
				if(x2<x1&&y2==y1) {		// upper left direction
					row=x1-count;
					col=y1;
				}else if(x2>x1&&y2==y1) {		// upper right direction
					row=x1+count;
					col=y1;
				}else if(x2==x1&&y2<y1) {		// lower left direction
					row=x1;
					col=y1-count;
				}else {						// lower right direction
					row=x1;
					col=y1+count;
				}
				//System.out.println("row="+row+"col="+col);
				if(temp_board[row][col]==null) {
					count++;
				}else  {
					count--;
					break;
				}
				
			}
			
			
			if(temp_board[x2][y2]==null&&count==abs1+1) {
				mov_ret=true;
			}else if(temp_board[x2][y2]!=null&&count==abs1-1&&board_class_obj.player_color!=temp_board[x2][y2].color) {
				mov_ret=true;
			}
		}
		
		return mov_ret;
	}
}
