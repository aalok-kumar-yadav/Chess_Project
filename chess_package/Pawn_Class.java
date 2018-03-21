package chess_package;

import java.util.Scanner;
import java.math.*;

public class Pawn_Class{
	
	static char array_2d[][]=new char[8][8];
	static char array_2d_piece[][]=new char[8][8];
	
	public static boolean move_pawn(int user,int x1,int y1,int x2,int y2,char ty){//method of moving piddi
		
		Board_Class temp_object=new Board_Class();
		char temp_2d_array[][]=temp_object.get_board();//getting board from board class
		
		array_2d_piece=temp_2d_array;
		boolean b=false;
		
		int abs1=Math.abs(x2-x1);//assigning absolute value of cordinate
		int abs2=Math.abs(y2-y1);
		
		if((abs1==1&&abs2==0)||(abs1==1&&abs2==1)){ //checking first only one box moving but not first
			
			boolean cnf	=change_status(user,x1,y1,x2,y2,ty);
			if(cnf==true){
				
				return true;
			}
			else{
	
				return false;
			}
		
		}else if((Math.abs(x2-x1)==2)&&(y2==y1)&&(array_2d_piece[x2][y2]==0)){  //condition of two box moving only first time 
			
			if(x1==6||x1==1){
				
				boolean cnf	=change_status(user,x1,y1,x2,y2,ty); //change_status method calling
			
				return true;
			}else{
			
				return false;
			}
			
		}
		else{
		
			return false;
		}
		
	}
	
	public static boolean change_status(int u,int x1,int y1,int x2,int y2,char ty){ //change status method defined
		
		Board_Class temp_object1=new Board_Class(); //making board class instance
		
		if(u==1){ //user 1 getting our different change
			
		if((array_2d_piece[x2][y2]==0)||(temp_object1.is_black(array_2d_piece[x2][y2]))){
			
			if(((((y2==y1&&x2==x1-1)||((x2==x1+1)&&(y2==y1+1||y2==y1-1)))&&(temp_object1.is_black(array_2d_piece[x2][y2]))
					&&array_2d_piece[x2][y2]==0))){
				
				return false;
			}else{
				
				if(temp_object1.get_flag_check()!=true){  //not for is_check_mate method
					array_2d_piece[x2][y2]=ty;
					array_2d_piece[x1][y1]=0;
					temp_object1.set_board(array_2d_piece);
				}
			
			return true;
			}
		}else{
		
			return false;
		}
		}else  //second user defining for type move
			{  
			if((array_2d_piece[x2][y2]==0)||(temp_object1.is_white(array_2d_piece[x2][y2]))){
				
				if(((y2==y1&&x2==x1+1)&&((temp_object1.is_white(array_2d_piece[x2][y2]))))||
						(((y2==y1+1||y2==y1-1)&&x2==x1-1)&&array_2d_piece[x2][y2]==0)){
		
					return false;
				}else{
				
					if(temp_object1.get_flag_check()!=true){ // not for is_check_mate method
						array_2d_piece[x2][y2]=ty;
						array_2d_piece[x1][y1]=0;
						temp_object1.set_board(array_2d_piece);
					}
				return true;
				}
			}else{
			
				return false;
			}
		}
	
	}
	
	
	
}
