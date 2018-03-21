package chess_package;

import java.util.Scanner;
import java.math.*;
public class Knight_Class {
	static char array_2d[][]=new char[8][8];
	static char array_2d_piece[][]=new char[8][8];
	
	
	
	public   boolean move_horse(int usr,int x1,int y1,int x2,int y2,char ty){ //move_horse method defined for 
		
		Board_Class temp_object=new Board_Class(); //making instance of board class
		char temp_2d_array[][]=temp_object.get_board(); //getting board from board class
		
		array_2d_piece=temp_2d_array;
		boolean flag=false; 
		
		int abs1=Math.abs(x2-x1); //absolute value assigning
		int abs2=Math.abs(y2-y1);
		
		
		//defining Move of Horse of big define
		if((abs2==1&&abs1==2)||(abs1==1&&abs2==2)){
		
			
		if(usr==1){  //for user first
			
			if((array_2d_piece[x2][y2]==0)|| (temp_object.is_black(array_2d_piece[x2][y2] ))){
			
				if(temp_object.get_flag_check()!=true){  //only movePc is allowed to change
					array_2d_piece[x2][y2]=ty;
					array_2d_piece[x1][y1]=0;
					temp_object.set_board(array_2d_piece);
				}
		

			return true;
			}
			else{
		
			
			return false;
				}
		
			}
		
		 else{  //second user start operation
			
			if(array_2d_piece[x2][y2]==0||(temp_object.is_white(array_2d_piece[x2][y2]))){
				
				if(temp_object.get_flag_check()!=true){  //only movePc is allowed to change
					array_2d_piece[x2][y2]=ty;
					array_2d_piece[x1][y1]=0;
					temp_object.set_board(array_2d_piece);
				}
				
				return true;
			}
			else{
				
				return false;
			 }
		 	}
			
			}else
			{
			return false;
			}
		
			}
	
	}// end horse class
