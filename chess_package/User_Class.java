package chess_package;

public class User_Class {  //user class invoked
	
	static int cow=0; //static variable
	static Piece_Class array_2d_pi[][]=new Piece_Class[8][8];
	
	public boolean start(int U,int x1,int y1,int x2,int y2,char ty){ //start method in user class
		
		
		Board_Class bo_obj=new Board_Class();
		
		array_2d_pi=bo_obj.get_board();
		Piece_Class cdf=bo_obj.get_loc_piece(x1, y1);  //getting location of this piece
		Piece_Class sjf=bo_obj.get_loc_piece(x2, y2);
		boolean is_alok=false;
		
	if(cow%2==0)
	{
		if(array_2d_pi[x1][y1].color=="white"){
	
	
	
	if(is_alok==true){
		
		System.out.println("Valid_in_my way");
		System.out.println("");
		bo_obj.set_flag_check(true);
		
		bo_obj.set_flag_check(false);
		
	}
	else
	{
		
		bo_obj.set_piece(x1, y1,'c');
		
		bo_obj.set_piece(x2, y2, 'v');
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
		
		if(array_2d_pi[x1][y1].color=="black"){
		
		
		if(is_alok==true){
			
			System.out.println("Valid_in_my way");
			System.out.println("");
			bo_obj.set_flag_check(true);
			
			bo_obj.set_flag_check(false);
			
		}
		else{
			
			
			bo_obj.set_piece(x2, y2,'b'); //setting last status  for both coordinate
			bo_obj.set_piece(x1, y1,'c');
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