package chess_package;
import java.math.*;

public interface Chess_camel_class{

	  
	default boolean move_c(int us,int x1,int y1,int x2,int y2,char ty){ //method define of moving camel piece
		
		Chess_board_class temp_object=new Chess_board_class();
		char array_2d_piece2[][]= temp_object.get_board(); //getting board from board class
	
		boolean flag=false;
		int abs1=Math.abs(x2-x1);//absolute value finding
		int abs2=Math.abs(y2-y1);

		if(abs1==abs2){ //initialization of method
		
		int count; 
		int req;
		if(y2>y1){
			flag=true;
			 req=y2-y1;
			if(x2>x1){
	
			count=1;
			while(count<=req){ //while loop for both increment direction
				if(array_2d_piece2[x1+count][y1+count]==0){
					count++;
					continue;
				}else{
					count--;
					break;
				}
			}
			}else{
		
				count=1;
				while(count<=req){  //while loop for one decrement and one increment direction
					if(array_2d_piece2[x1-count][y1+count]==0){
						count++;
						continue;
					}else{
						count--;
						break;
					}
				}
			}
		}//closing of first if  braces
		else{
			flag=true;
			 req =y1-y2;
			if(x2>x1){
	
			count=1;
			while(count<=req){ //while loop for one increment  and one  decrement direction
				if(array_2d_piece2[x1+count][y1-count]==0){
					count++;
					continue;
				}else{
					count--;
					break;
				}
			}
			}else{
		
				count=1;
		
				while(count<=req){ //while loop for both increment direction
					if(array_2d_piece2[x1-count][y1-count]==0){
						count++;
						
						continue;
					}else{
					
						count--;
						break;
					}
				}
			}
		}//closing of else  braces 
		if(flag==true){
			if(count==req+1){ //checking destination is empty or not
				
				if(temp_object.get_flag_check()!=true){  //only move are allowed not check_mate call
					array_2d_piece2[x2][y2]=ty;
					array_2d_piece2[x1][y1]=0;
					temp_object.set_board(array_2d_piece2);
				}
			
				return true;
			}
			else{
				
			boolean cnf=change_status_c(us,x1,y1,x2,y2,ty,count,req,array_2d_piece2); //calling check_status method for status
			if(cnf==true){
		
				if(temp_object.get_flag_check()!=true){ //also here only move are allowed not check_mate move
					array_2d_piece2[x2][y2]=ty;
					array_2d_piece2[x1][y1]=0;
					temp_object.set_board(array_2d_piece2);
				}
				
				return true;
			}else{
		
				return false;
			}
			}
		}else{
			
			return false;
		}

		}//first absolute if end here
		else{
		
			return false;
		}//
		
	}// move_c method end 
	
		default boolean change_status_c(int usr,int x1,int y1,int x2,int y2,char ty,int count,
				int req,char array_2d_piece[][]){	//method for changing location
		 
	Chess_board_class change_obj=new Chess_board_class(); //making instance of board class
	
		if(usr==1){ //for user one 
			
		if((count==req-1)&&(change_obj.is_black(array_2d_piece[x2][y2]))){
			
			return true;
	
				}
			else{
		
				change_obj.set_board(array_2d_piece);
				return false;
				}
		
		}//user one end
		
		else{//SECOND USER invoked
			if((count==req-1)&&(change_obj.is_white(array_2d_piece[x2][y2]))){
				
				return true;
		
		}else{
			
			return false;
			}
		}
	   }// change status method end here

	} //camel class end here
