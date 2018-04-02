package chess_package;

public class Pawn_Class extends Piece_Class{	//Pawn class
	
	public Pawn_Class(String col, char sym,String name){		//Pawn constructor
		this.color=col;
		this.symbol=sym;
		this.name=name;
	}
	
	public boolean move_piece(int x1,int y1,int x2,int y2)			//move_piece function
	{
		boolean mov_ret=false;
		Board_Class board_class_obj = new Board_Class();
		Piece_Class temp_board[][]= board_class_obj.get_board();
		
		int abs1=Math.abs(x2-x1);	//assigning absolute value of coordinate difference
		int abs2=Math.abs(y2-y1);
		
		if((abs1==1&&abs2==0)||(abs1==1&&abs2==1)){ 	//one cell move of pawn
			boolean flag=false;
			
			if((temp_board[x2][y2]==null)&&(abs1==1&&abs2==0)) {
				flag=true;
					
			}else if((abs1==1&&abs2==1)&&temp_board[x2][y2]!=null) {
				if((temp_board[x2][y2].color!=board_class_obj.player_color)) {
					flag=true;
				}
				
			}
			
			if(flag==true) {		//checking that a pawn can not move backward
				if((board_class_obj.player_color=="white"&&x2>x1)|| (board_class_obj.player_color=="black"&&x2<x1)) {
					mov_ret=true;
				}
			}
				
		}else if((abs1==2)&&(y2==y1)&&(temp_board[x2][y2]==null)&&(x1==6||x1==1)){  //two cell move of pawn 
			mov_ret=true;

		}
		
		return mov_ret;		//return mov_ret
	}
	
}		//end of Pawn class
