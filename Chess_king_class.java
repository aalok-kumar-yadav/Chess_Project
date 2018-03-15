package chess_package;
import java.math.*;
import java.util.*;
public class Chess_king_class {
	
	static char array_2d[][]=new char[8][8];
	static char array_2d_piece[][]=new char[8][8];
	
	public static boolean move_king(int user,int x1,int y1,int x2,int y2,char ty){//method of king move for both user
		
		Chess_board_class temp_object=new Chess_board_class(); //composition of board class
		char temp_2d_array[][]=temp_object.get_board(); //getting board from board class
		
		array_2d_piece=temp_2d_array;
		boolean b=false;
		
		int abs1=Math.abs(x2-x1);//absolute value defined
		int abs2=Math.abs(y2-y1);
		
		if((abs1==0&&abs2==1)||(abs2==0&&abs1==1)||(abs1==1&&abs2==1))
				{
			
				boolean cnf	=change_status(user,x1,y1,x2,y2,ty);
				if(cnf==true){
				
				if(temp_object.get_flag_check()!=true)
				{
					array_2d_piece[x2][y2]=ty;
					array_2d_piece[x1][y1]=0;
					temp_object.set_board(array_2d_piece);
				}
				
				return true;
							}
			else{
			
				return false;
				
				}
		
		}else{
			
			return false;
			
		}
	
	}
	
	public static boolean change_status(int user,int x1,int y1,int x2,int y2,char ty){ //change status method defined here
		Chess_board_class temp_object1=new Chess_board_class();
		if(user==1){
		if((array_2d_piece[x2][y2]==0)||(temp_object1.is_black(array_2d_piece[x2][y2])))
		{
		
			return true;
		}
		else{
			return false;
		}
	
		}else{
			if((array_2d_piece[x2][y2]==0)||(temp_object1.is_white(array_2d_piece[x2][y2]))){
				
				return true;
			}
			else{
				return false;
			}
		
		}
	}  // king_move method end 
	

	} //king class end

