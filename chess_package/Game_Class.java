package chess_package;  //chess package
import java.util.*;

public class Game_Class {		//game class for start game
	
	static Piece_Class you_r_not[][]=new Piece_Class[8][8];
		public static void main(String arg[]){//main method defined
			Scanner input=new Scanner(System.in);
			 Board_Class object_board=new Board_Class();//board class composition
			 
	object_board.set_chess_board();  //working with board class set board color
	System.out.println("Instruction--->>>");
	System.out.println("1. Capital letter pieces are 'WHITE' pices");
	System.out.println("2. small letter pieces are 'BLACK' pices");
	System.out.println("3. USER-1 Assigned to WHITE ");
	System.out.println("4. USER-2 Assigned to BLACK ");
	System.out.println();
	object_board.show_board();        //showing whole 2d board
	object_board.get_board();
	
	System.out.println("USER-1 TURN");
	System.out.println("Enter source's 'x' cordinate ");//taking source coordinate(x1,y1) form from user
		
	    int x1=input.nextInt();
		System.out.println("Enter source's 'y' cordinate ");
		int y1=input.nextInt();
		System.out.println("Enter destination's 'x' cordinate ");
		
			int x2=input.nextInt();
			System.out.println("Enter destination's 'y' cordinate ");
			int y2=input.nextInt();
		    
		    Piece_Class obj_type;
		    object_board.set_chess_board();
		    
	    User_Class usr_obj=new User_Class();  //composition of user class object making

		int count=1;
		while(count<500){//while loop of many times for turn
			
			you_r_not=	object_board.get_board();
		if(((x1>=0&&x1<=7) &&(y1>=0&&y1<=7)&& (x2>=0&&x2<=7)&&(y2>=0&&y2<=7))&&you_r_not[x1][y1].symbol!=0){//if else for checking valid coordinate or not
		
	    obj_type=object_board.get_loc_piece(x1,y1);  //getting source position's piece type
	    
		//boolean confirm=usr_obj.start(1,x1,y1,x2,y2,obj_type);  //start method for start game ,calling user class method
		
		
				int result=object_board.is_king_alive();  // method calling for king alive condition
				
				if(result==1){
					System.out.println("USER-1 KING NO MORE EXIST");
					System.out.println("USER-2 IS WINNER.....@#$%^&*");
					break;
				}else if(result==2){
					System.out.println("USER-2 KING NO MORE EXIST");
					System.out.println("USER-1 IS WINNER.....@#$%^&*");
					break;
				}else{
					System.out.println("continue----->>>>>");
				}
				
	}else{
		System.out.println("Wrong Cordinate Please Re-Enter-->> OR empty location");
		System.out.println();
		
		
	}
		System.out.println("Enter source's 'x' cordinate ");//taking source coordinate(x1,y1) form from user
		
		   x1=input.nextInt();
			System.out.println("Enter source's 'y' cordinate ");
			y1=input.nextInt();
			System.out.println("Enter destination's 'x' cordinate ");
			
			x2=input.nextInt();
			System.out.println("Enter destination's 'y' cordinate ");
		    y2=input.nextInt();
				    
		count++;
				}//end while loop
		
		}//end main method
		
	}//end Chess piece class 
