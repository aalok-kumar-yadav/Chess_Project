package chess_package;

public class Chess_piece_class implements Chess_camel_class,Chess_elephant_class{
	
			
	public static boolean find_bool(boolean b1,boolean b2){// method defined for finding boolean of conditional operator
		
		if(b1==false){
			return false;
		}else{
			
			if(b2==false){
				return true;
			}
			else{
				return false;
			}
			
		}	
	
	}
	
	
	public static  boolean is_our_type(int user_type,char type_char){  //is our method for condition to behave like one type
	
		if((user_type==1)&&((type_char=='P')||(type_char=='Q')||(type_char=='N')||
				(type_char=='B')||(type_char=='R')||(type_char=='K')))
			{
			return true;
			}
		else if((user_type==2)&&((type_char=='p')||(type_char=='q')||(type_char=='k')||
				(type_char=='b')||(type_char=='r')||(type_char=='n')))
			{
			
			return true;
			}
		else
		{
			return false;
		}
	
	}
	

	public boolean move_pc(int us_cnf,int x1,int y1,int x2,int y2,char ty){  // method defined for move function of type piece
		
		Chess_piece_class temp_obj1=new Chess_piece_class();
		Chess_board_class object_of_board=new Chess_board_class();
	
		//for user one or user two turn
			boolean temp_bool;
			
			if((ty=='p')||(ty=='P')){ //calling method of piddi class for move
				
				final char my_buff[][]=object_of_board.get_board(); //getting board before invoked move method
				Chess_piddi_class temp_obj=new  Chess_piddi_class();
				
				temp_bool=temp_obj.move_piddi(us_cnf,x1,y1,x2,y2,ty); //calling move piddi function

				final char buff[][]=object_of_board.get_board(); // calling get board function
					
			object_of_board.set_flag_check( true);
			boolean foo= temp_obj1.is_check_Mate('z',us_cnf,ty); //calling is_check_mate method that return boolean type
			object_of_board.set_flag_check(false);
			  
			object_of_board.set_board(buff);
			
			object_of_board.set_board( my_buff);
			
			 
			  //setting board to my_self 
			  if(temp_bool==true&&foo==false)
			  {
				  object_of_board.set_board(buff);
				 
			  }else{
				  object_of_board.set_board( my_buff);
				
			  }
			  
				 boolean aky=find_bool( temp_bool,foo);
				
				return aky; 
				 	
			} //piddi type end
			
			else if((ty=='r')||(ty=='R'))   //calling method of Elephant class for move
			{  
				char my_buff[][]=object_of_board.get_board();  // getting board from board class
				
				 temp_bool=temp_obj1.move_e(us_cnf, x1, y1, x2, y2, ty);
				 char buff[][]=object_of_board.get_board();
				 
				 object_of_board.set_flag_check( true);
				 boolean foo= is_check_Mate('z',us_cnf,ty);  //calling is_check_mate method that return boolean type
				 object_of_board.set_flag_check( false);
				 
				 object_of_board.set_board( buff);
				 
				 boolean aky=find_bool( temp_bool,foo);
				
				  if(temp_bool==true&&foo==false)   //setting board to my_self 
				  {
					  object_of_board.set_board(buff);
					  
				  }else{
					  object_of_board.set_board( my_buff);
		
				  }
				  
				return aky; 
			
			}
			
			
			else if((ty=='N')||(ty=='n')) {
				char my_buff[][]=object_of_board.get_board();  
				Chess_horse_class temp_obj=new  Chess_horse_class();
			
				 temp_bool=temp_obj.move_horse(us_cnf,x1,y1,x2,y2,ty);  //calling method of Horse class for move
					{
				 char buff[][]=object_of_board.get_board();
				 
				 object_of_board.set_flag_check( true);
				 boolean foo= is_check_Mate('z',us_cnf,ty);  //calling is_check_mate method that return boolean type
				 object_of_board.set_flag_check( false);
				 
				 object_of_board.set_board( buff);
				 //setting board to my_self 
				  if(temp_bool==true&&foo==false){
					  object_of_board.set_board(buff);
					  
				  }else{
					  object_of_board.set_board( my_buff);
		
				  }
				  
				 boolean aky=find_bool( temp_bool,foo);
				
				return aky; 
				 
			}}
			
		  else if((ty=='b')||(ty=='B')){ //checking for camel
			  
			  char my_buff[][]=object_of_board.get_board();
			  boolean temp_b=temp_obj1.move_c(us_cnf,x1,y1,x2,y2,ty);  //calling method of camel class for move
			  
			  char buff[][]=object_of_board.get_board();
			  
			  object_of_board.set_flag_check( true);
			 boolean foo= is_check_Mate('z',us_cnf,ty);  //calling is_check_mate method that return boolean type
			 object_of_board.set_flag_check( false);
			 
			 object_of_board.set_board( buff);
			 //setting board to my_self 
			 
			  if(temp_b==true&&foo==false)
			  {
				  object_of_board.set_board(buff);
				  
			  }else{
				  object_of_board.set_board( my_buff);
	
			  }
			 boolean aky=find_bool( temp_b,foo);
				
				return aky;  
	
		  		}
			
			
		  else if((ty=='q')||(ty=='Q')){ //checking for queen
			  
			  char my_buff[][]=object_of_board.get_board();
			  Chess_queen_class temp_obj=new  Chess_queen_class();
			  
			  temp_bool=temp_obj.move_queen(us_cnf,x1,y1,x2,y2,ty);  //calling method of Queen class for move
			  char buff[][]=object_of_board.get_board();
			  
			  object_of_board.set_flag_check( true);
		 boolean foo= is_check_Mate('z',us_cnf,ty);   //calling is_check_mate method that return boolean type
		 object_of_board.set_flag_check( false);
		 
		 object_of_board.set_board( buff);
		//setting board to my_self 
		 
		  if(temp_bool==true&&foo==false)
		  {
			  object_of_board.set_board(buff);
			  
		  }else{
			  object_of_board.set_board( my_buff);

		  }
				 boolean aky=find_bool( temp_bool,foo);
				
				return aky;   
			 
		 }
			
		  else {
			  
			  char my_buff[][]=object_of_board.get_board();
			  Chess_king_class temp_obj=new  Chess_king_class();
			  
			  temp_bool=temp_obj.move_king(us_cnf,x1,y1,x2,y2,ty);  //calling method of king class for move
			  char buff[][]=object_of_board.get_board();
			  
			  object_of_board.set_flag_check( true);
				 boolean foo= is_check_Mate('z',us_cnf,ty);  //calling is_check_mate method that return boolean type
				 object_of_board.set_flag_check( false);
				 
				 object_of_board.set_board( buff);
				//setting board to my_self 
				  if(temp_bool==true&&foo==false){
					  object_of_board.set_board(buff);
					  
				  }else{
					  object_of_board.set_board( my_buff);

				  }
				 boolean aky=find_bool( temp_bool,foo);
				
				return aky;  
			  
		}
		
	}
	
	
	 boolean is_check_Mate(char who ,int User,char ty){  //method of checking chech_mate condition
		
		Chess_board_class object=new Chess_board_class();
		int pmf=0;
		//best schenerio
		if(who=='z'){
		
				if(User==1){ //changing user type
					
					pmf=object.get_index_piece('K'); //getting location of this piece
					User=2;
				}else{
			
					pmf=object.get_index_piece('k');  //getting location of this piece
					User=1;
				}
		}else{
			
			if(User==1){ //changing user type
				
				pmf=object.get_index_piece('k'); //getting location of this piece
			
			}else{
		
				pmf=object.get_index_piece('K');  //getting location of this piece
				
			}
		}
		//best end
		Chess_piece_class temp_obj1=new Chess_piece_class();
	
		char temp_board[][]=object.get_board();
		
		 int x2=(pmf/8); //getting index 
		int y2=(pmf%8)-1;
		
		boolean flag_for=false; //flag initialization of various type
		boolean flag_return=false;
		boolean my_love=false;
		
		
		for(int i=0;i<8;i++){  //for loop for accessing every element for checking 
			for(int j=0;j<8;j++){
				char find=temp_board[i][j];
		
	if((find=='p')||(find=='P')){  //for piddi class validating
					boolean bulleya=false;
					Chess_piddi_class temp_obj=new  Chess_piddi_class();
					
					boolean aman=is_our_type(User,find);  //calling is_our_type method
					
					if(aman==true){
					 bulleya=temp_obj.move_piddi(User,i,j,x2,y2,find); //calling piddi move method
				}
					flag_return= bulleya; //assigning flag
					
				}
				
	if((find=='n')||(find=='N'))  //for horse class validating
				{
					Chess_horse_class temp_obj=new  Chess_horse_class();
					boolean bulleya=false;
					
					boolean aman=is_our_type(User,find);  //calling is_our_type method
					
					if(aman==true){
					 bulleya=temp_obj.move_horse(User,i,j,x2,y2,find);  //calling horse move method
					 
					flag_return=bulleya;  //assigning flag
					}
				}
				
	if((find=='k')||(find=='K'))  //for king class validating
				{
					Chess_king_class temp_obj=new  Chess_king_class();
					boolean bulleya=false;
					
					boolean aman=is_our_type(User,find); //calling is_our_type method
					
					if(aman==true){
					 bulleya=temp_obj.move_king(User,i,j,x2,y2,find);  //calling king move method
					 
					flag_return= bulleya;  //assigning flag
					}
				}
				
	if((find=='q')||(find=='Q')) //for queen class validating
				{
					  Chess_queen_class temp_obj=new  Chess_queen_class();
					  boolean bulleya=false;
					  
						boolean aman=is_our_type(User,find);  //calling is_our_type method
						
						if(aman==true){
					 bulleya=temp_obj.move_queen(User,i,j,x2,y2,find);  //calling  queen move method
					 
					  flag_return=bulleya; //assigning flag
						}
				}
				  
	if((find=='B')||(find=='b'))  //camel validating
				{
					boolean bul=false;
					
					boolean aman=is_our_type(User,find);  //calling is_our_type method
					
					if(aman==true){
					 bul=temp_obj1.move_c(User,i,j,x2,y2,find);   //calling  camel move method
					 
					  flag_return= bul; // assigning flag
				}
				}
	
	if((find=='r')||(find=='R')) //Elephant validating
				{
					boolean bul=false;
					
					boolean aman=is_our_type(User,find);  //calling is_our_type method
					if(aman==true){
					  bul=temp_obj1.move_e(User,i,j,x2,y2,find);  //calling  elephant  move method
					  
					  flag_return= bul;   // assigning flag
				}
				}
				if(flag_return==true){ //checking flag if true then assign
					my_love=true;
					break;
				}
				
			}
			if(my_love==true){ //checking  my_love flag
				break;
			}
		}

	return flag_return; //final return of flag
		
	} //is_check_mate end method end
	

} //piece class end
