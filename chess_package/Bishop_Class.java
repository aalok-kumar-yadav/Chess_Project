package chess_package;

public class Bishop_Class extends Piece_Class {		// Bishop class
	
	Bishop_Class(String col,char sym,String name){
		this.color=col;
		this.symbol=sym;
		this.name=name;
	}
	Bishop_Class(){
		
	}
	
	public boolean move_piece(int x1,int y1,int x2,int y2) {
		
		boolean mov_ret=false;
		Board_Class board_class_obj = new Board_Class();
		Piece_Class temp_board[][]= board_class_obj.get_board();
		
		int abs1=Math.abs(x2-x1);	//assigning absolute value of coordinate difference
		int abs2=Math.abs(y2-y1);
		
		if(abs1==abs2) {
			
			int count=1;
			while(count<=abs1) {	
				int row,col;
				if(x2<x1&&y2<y1) {		// upper left direction
					row=x1-count;
					col=y1-count;
				}else if(x2<x1&&y2>y1) {		// upper right direction
					row=x1-count;
					col=y1+count;
				}else if(x2>x1&&y2<y1) {		// lower left direction
					row=x1+count;
					col=y1-count;
				}else {						// lower right direction
					row=x1+count;
					col=y1+count;
				}
				
				if(temp_board[row][col]==null) {
					count++;
				}else  {
					count--;
					break;
				}
				
			}
			
			//System.out.println("count is :"+count);
			if(temp_board[x2][y2]==null&&count==abs1+1) {
				mov_ret=true;
			}else if(temp_board[x2][y2]!=null&&count==abs1-1&&board_class_obj.player_color!=temp_board[x2][y2].color) {
				mov_ret=true;
			}
		}
		
		return mov_ret;
	}
		
}		//end of bishop class
