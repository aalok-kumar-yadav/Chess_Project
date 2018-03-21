package chess_package;
public interface Rook_Class {

	default boolean move_rook(int us,int x1,int y1,int x2,int y2,char ty){ //move_e method defined here
		
		Board_Class temp_object=new Board_Class(); //making composition of board class
		char array_2d_piece1[][]=temp_object.get_board(); //getting board from board class
		
		int count=0;
		boolean flag=false;
		 
		if(x1==x2){ //Elephant move defined in y direction
			flag=true;
			if(y2>y1){ 
				 count=y1+1;
				while(count<=y2){
				if(array_2d_piece1[x1][count]==0){
					count++;
					continue;
					}else{
						count--;
					break;
				}
				}
			}	
				else{
					 count=y1-1;
						while(count>=y2){
						if(array_2d_piece1[x1][count]==0){
							count--;
							continue;
						}else{
							count++;
							break;
						}
						
					}
				}
				
			}
		
		else if(y1==y2){ //elephant move in x direction
			flag=true;
			if(x2>x1){
				 count=x1+1;
				while(count<=x2){
				if(array_2d_piece1[count][y1]==0){
					count++;
					continue;
				}else{
					count--;
					break;
				}
				}
			}
				else{
					 count=x1-1;
					while(count>=x2){
						if(array_2d_piece1[count][y1]==0){
							count--;
							continue;
						}else{
							count++;
							break;
						}
						
					}
				}
				
			}
		

		if(flag==true){//flag confirmation for valid input for camel or not
			
		boolean cnfr=change_status_e(us,x1,y1,x2,y2,ty,count,array_2d_piece1); //calling change status method for status changing
		if(cnfr==true){
			
			if(temp_object.get_flag_check()!=true){ //only move are allowed to set any one (is_check_mate) not
				array_2d_piece1[x2][y2]=ty;
				array_2d_piece1[x1][y1]=0;
				temp_object.set_board(array_2d_piece1);
			}
			
			return true;
		 }else{
			
			return false;
		 }
	   }else{

		return false;
	}
		
	}
	//status changing method defined and also passing board via move_e
	default boolean change_status_e(int usr,int x1,int y1,int x2,int y2,char ty,int count,char array_2d_piece2[][]){
		
		Board_Class change_object=new Board_Class();
		
		if(usr==1){ //user first working here
		
		if(((x1==x2)&&(count==(y2+1)||count== (y2-1)))||((y1==y2)&&(count== (x2+1)||count== (x2-1))) )
	
		{
			if(change_object.get_flag_check()!=true){
				array_2d_piece2[x2][y2]=ty;
				array_2d_piece2[x1][y1]=0;
				change_object.set_board(array_2d_piece2);
			}
	
			return true;
		}else if((count==y2||count==x2)&&(change_object.is_white(array_2d_piece2[x2][y2] ))){
			
			
			if(change_object.get_flag_check()!=true){ //only move_e is allowed to change ,is_check_mate is not allowed to change
				array_2d_piece2[x2][y2]=ty;
				array_2d_piece2[x1][y1]=0;
				change_object.set_board(array_2d_piece2);
			}
			
			 return true;
		}else{
			
			return false;
		}
		}//user first end their work
		
		else{//second user invoked for working

			if(((x1==x2)&&(count== (y2+1)||count== (y2-1)))||((y1==y2)&&(count== (x2+1)||count== (x2-1))) )
		
			{
				if(change_object.get_flag_check()!=true){ //only move_e is allowed to change ,is_check_mate is not allowed to change
					array_2d_piece2[x2][y2]=ty;
					array_2d_piece2[x1][y1]=0;
					change_object.set_board(array_2d_piece2);
				}
			
			
				return true;
			}else if((count==y2||count==x2)&&(change_object.is_white(array_2d_piece2[x2][y2] ))){
				
				if(change_object.get_flag_check()!=true){
					array_2d_piece2[x2][y2]=ty;
					array_2d_piece2[x1][y1]=0;
					change_object.set_board(array_2d_piece2);
				}
				
				 return true;
			}else{
			
				return false;
			}
		
		
		}
	}
	
	}
