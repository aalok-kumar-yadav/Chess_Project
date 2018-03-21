package chess_package;

public class User_Class {  //user class invoked
	
	static int cow=0; //static variable
	static char array_2d_pi[][]=new char[8][8];
	
	public boolean start(int U,int x1,int y1,int x2,int y2,char ty){ //start method in user class
		
		Piece_Class us_obj=new Piece_Class();  //Board class composition in this class
		Board_Class bo_obj=new Board_Class();
		
		array_2d_pi=bo_obj.get_board();
		char cdf=bo_obj.get_loc_piece(x1, y1);  //getting location of this piece
		char sjf=bo_obj.get_loc_piece(x2, y2);
		boolean is_alok=false;
		
	if(cow%2==0)
	{
		if(bo_obj.is_white(array_2d_pi[x1][y1])){
		

		
	 is_alok=us_obj.move_pc(1,x1,y1,x2,y2,ty); //calling move_pc method for move piece
	
	if(is_alok==true){
		
		System.out.println("Valid_in_my way");
		System.out.println("");
		bo_obj.set_flag_check(true);
		boolean you=us_obj.is_check_Mate('u', 1, ty);
		bo_obj.set_flag_check(false);
		if(you==true){
			System.out.println("CHECK FOR USER-2-->>>Be careful");
		}
	}
	else
	{
		bo_obj.set_board(array_2d_pi);
		bo_obj.set_parti(x1, y1,cdf);
		
		bo_obj.set_parti(x2, y2, sjf);
		System.out.println("Invalid_in_my way");
		System.out.println("");
		cow--;
	}
	cow++;
		bo_obj.show_board();
		if(is_alok==true){
		System.out.println("Next USER-2 TURN");
		}
		else
		{
			System.out.println("Again USER-1 TURN");
		}
		System.out.println("");
		
	}
		else{
				System.out.println("Invalid Move this is not your piece");
				bo_obj.show_board();
			}
		return is_alok;
	}
	else{
		
		if(bo_obj.is_black(array_2d_pi[x1][y1])){
		
		 is_alok=us_obj.move_pc(2,x1,y1,x2,y2,ty); //calling move_pc method
		
		if(is_alok==true){
			
			System.out.println("Valid_in_my way");
			System.out.println("");
			bo_obj.set_flag_check(true);
			boolean you=us_obj.is_check_Mate('u', 2, ty);
			bo_obj.set_flag_check(false);
			if(you==true){
				System.out.println("CHECK USER-1--->>Be careful");
			}
			
		}
		else{
			bo_obj.set_board(array_2d_pi); //setting board
			
			bo_obj.set_parti(x2, y2,sjf); //setting last status  for both coordinate
			bo_obj.set_parti(x1, y1,cdf);
			System.out.println("Invalid_in_my way");
			System.out.println("");
			cow--;
		}
		cow++;
		bo_obj.show_board();  //showing  board after move
		if(is_alok==true){
		System.out.println("Next USER-1 TURN");
		}else
		{
			System.out.println("Again USER-2 TURN");
		}
		System.out.println("");
		
		
	}
	else{
		System.out.println("Invalid move not your type");
		bo_obj.show_board();
	}
		 //returning boolean flag
	}
			
	
	return is_alok;
	}//end start method
}//end user class