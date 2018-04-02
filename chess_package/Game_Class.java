package chess_package;
import java.util.*;

public class Game_Class{
	
	public static boolean is_check() {		//is_check method for check condition in chess
	
		Board_Class board_obj=new Board_Class();
		boolean ret_flag=false;
		int x=0,y=0;
		
		for(int i=0;i<8;i++) {		// loop for getting king's location
			for(int j=0;j<8;j++) {
				
				if(board_obj.get_board()[i][j]!=null) {
					if(board_obj.get_board()[i][j].color!=board_obj.player_color&&board_obj.get_board()[i][j].name=="king") {
						x=i;y=j;
						//System.out.println("x="+x+"y="+y);
					}
				}	
			}
		}
		
		boolean bool=false;
		for(int i=0;i<8;i++) {		//loop for checking opposite can attack or not
			for(int j=0;j<8;j++) {
				
				if(board_obj.get_board()[i][j]!=null&&(board_obj.get_board()[i][j].color!=board_obj.get_board()[x][y].color)) {
					bool =board_obj.get_board()[i][j].move_piece(i, j, x, y);
					//System.out.println("i="+i+"j="+j);
					//System.out.println(bool);
					if(bool==true) {
						ret_flag=true;
						break;
					}
				}
				
			}
		}
		
		return ret_flag;
	}		//end of is_check function
	
	
	
	public static boolean is_checkmate() {		//method for is_method
		boolean ret_flag=false;
		Board_Class board_obj=new Board_Class();
		
		for(int i=0;i<8;i++) {			//loop for getting board piece
			for(int j=0;j<8;j++) {
				
			Piece_Class piece_obj=board_obj.get_board()[i][j];		//access piece from chess board
				
			if(piece_obj!=null) {
					
					for(int k=0;k<8;k++) {
						for(int m=0;m<8;m++) {
							//System.out.println("i called piece");
							//System.out.println("move is called for "+i+","+j+","+k+","+m+" piece type "+piece_obj.color);
							board_obj.change_turn();
							//System.out.println("Turn is :"+board_obj.player_color);
							
							boolean  flag=false;
							if(piece_obj.color==board_obj.player_color) {
								flag=piece_obj.move_piece(i, j, k, m);
							}
							
							//System.out.println(flag);
							
							if(flag==true) {
								
								//System.out.println("for a move is possible for: "+piece_obj.symbol +" turn is ="+board_obj.player_color);
								board_obj.set_piece(k, m, piece_obj);
								board_obj.set_piece(i, j, null);
								
								board_obj.change_turn();
								boolean temp_flag=is_check();
								
								
								if(temp_flag==true) {
									//System.out.println("can not prevent");
								}else {
									//System.out.println("we can prevent");
									ret_flag=true;
									//board_obj.show_board();
								}
								
								
								board_obj.set_piece(k, m, null);
								board_obj.set_piece(i, j, piece_obj);
								
								
							}else {
								board_obj.change_turn();
							}
								
						}
					}
							
			}
			
			}
		}
		
		if(ret_flag==true) {
			return false;
		}else {
			return true;
		}
	}		//end of checkMate function
	
	
	public static void main(String arg[]){			//main method defined
		
	Board_Class board_obj=new Board_Class();
	board_obj.set_chess_board();
	System.out.println("Capital Letter Pieces Are Black: ");
	System.out.println("Small Letter Pieces Are White: ");
	System.out.println();
	board_obj.show_board();
	
	Scanner input=new Scanner(System.in);
	while(true) {			//while loop for many player turn 
		
		System.out.println();
		System.out.println(board_obj.player_color+" Piece Turn -- ");
		
		System.out.println("Enter the position x1: ");
		int x1=input.nextInt();
		System.out.println("Enter the position y1: ");
		int y1=input.nextInt();
		System.out.println("Enter the position x2: ");
		int x2=input.nextInt();
		System.out.println("Enter the position y2: ");
		int y2=input.nextInt();
		Piece_Class pi=board_obj.get_loc_piece(x1, y1);
		
		if(pi.color==board_obj.player_color) {		//condition for checking valid or invalid move
			
			boolean bool=pi.move_piece(x1, y1, x2, y2);
			if(bool==false) {
				System.out.println();
				System.out.println("Invalid move -- Position Not valid !!");
				System.out.println("Again user "+board_obj.player_color+" turn");
				System.out.println();
			}else {
				
				board_obj.change_turn();
				//System.out.println("attacker is : "+board_obj.player_color);
				board_obj.set_piece(x2, y2, pi);
				board_obj.set_piece(x1, y1, null);
				
				boolean prev_check_flag=is_check();
				//System.out.println("prev_check_flag flag="+prev_check_flag);
				if(prev_check_flag==false){
					
				}else {
					board_obj.set_piece(x2, y2, null);
					board_obj.set_piece(x1, y1, pi);
				}
				board_obj.change_turn();
				
				boolean check_flag=is_check();
				
				//System.out.println(check_flag);
				if(check_flag==true) {
				
					
					//board_obj.show_board();
					//System.out.println(board_obj.player_color);
					boolean check_mate=is_checkmate();		//call checkmate fun ation
					
					if(check_mate==true) {
						System.out.println("CHECKMATE !!!! GAME OVER");
					}else {
						System.out.println("CHECK !! BE CAREFUL");
						board_obj.change_turn();
					}
					
				}else {
					if(prev_check_flag!=true) {		//checking that current no check condition on king
						
						board_obj.set_piece(x2, y2, pi);
						board_obj.set_piece(x1, y1, null);
						System.out.println();
						System.out.println("Sucessfully moved!!");
						System.out.println();
						board_obj.change_turn();
								
					}else {
						System.out.println("You Are In Check Cann't Move Piece ");
					}
								
				}	
			}
			
				board_obj.show_board();
		}else {
			System.out.println();
			System.out.println("Invalid Move --Not Your Piece:");
			continue;
		}
		
	}
		
	}		//end of main method

}		//end of game class
