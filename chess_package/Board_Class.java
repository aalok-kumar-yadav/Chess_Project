package chess_package;		//chess package

public class Board_Class   {		//Board class
	
	static Piece_Class array_2d_piece[][]=new Piece_Class[8][8];
	static boolean flag_is_check=false;
	static String player_color="white";
		
		public  void set_chess_board(){	  //set the pieces in the board
			for(int i=0;i<8;i++){
				Pawn_Class pawn_obj= new Pawn_Class("white",'p');		//white pawn 
				array_2d_piece[1][i]=pawn_obj;
				}
			
				for(int i=0;i<8;i++){
					Pawn_Class pawn_obj= new Pawn_Class("black",'P');		//black pawn
					array_2d_piece[1][i]=pawn_obj;				
				}
				
				for(int i=0;i<=7;i+=7) {
					Rook_Class rook_obj=new Rook_Class("white",'r');
					array_2d_piece[0][i]=rook_obj; //white Rook initialization
				}
				
				for(int i=1;i<=6;i+=5) {
					Knight_Class knight_obj=new Knight_Class("white",'n');
					array_2d_piece[0][i]=knight_obj; //white knight initialization
				}
				
				for(int i=2;i<=5;i++) {
					Bishop_Class bishop_obj=new Bishop_Class("white",'b');
					array_2d_piece[0][i]=bishop_obj; //white bishop initialization
				}
				
				King_Class king_obj=new King_Class("white",'k');
				Queen_Class queen_obj=new Queen_Class("white",'q');
						array_2d_piece[0][3]=king_obj;  //white king  and queen initialization
						array_2d_piece[0][4]=queen_obj;
							
				//second party
						
						for(int i=0;i<=7;i+=7) {
							Rook_Class rook_obj=new Rook_Class("white",'R');
							array_2d_piece[7][i]=rook_obj; //Rook initialization
						}
						
						for(int i=1;i<=6;i+=5) {
							Knight_Class knight_obj=new Knight_Class("white",'N');
							array_2d_piece[7][i]=knight_obj; //black knight initialization
						}
						
						for(int i=2;i<=5;i++) {
							Bishop_Class bishop_obj=new Bishop_Class("white",'B');
							array_2d_piece[7][i]=bishop_obj; //black bishop initialization
						}
						
						King_Class black_king_obj=new King_Class("white",'K');
						Queen_Class black_queen_obj=new Queen_Class("white",'Q');
						
						array_2d_piece[0][3]=black_king_obj;  //black king  and queen initialization
						array_2d_piece[0][4]=black_queen_obj;				
						
																	
			}
		
		public Piece_Class get_loc_piece(int p,int q){ //method of  location piece object to finding
			
				return array_2d_piece[p][q];
			}
		
		 public Piece_Class[][] get_board(){ //get chess board when called
				
				return array_2d_piece;
			}
			 
		 
			public int is_king_alive(){//king's status of alive or not 
				int count=0;
				int king1=0;
				int king2=0;
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						
						if(array_2d_piece[i][j].symbol=='k')
						{		//checking white king
							king1=1;
							continue;
						}
						
						else if(array_2d_piece[i][j].symbol=='K')
						{		//checking black king
						
								king2=2;
								continue;
							}else{ 	 //none of found
								continue;
						}
					}
				}
				count=king1+king2;
				return count;	 //return count value
			}
			
			public void show_board(){	  //show current board function
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
				
					if(array_2d_piece[i][j].symbol!=0) {
						System.out.printf(array_2d_piece[i][j]+"  ");
					}else {
						System.out.printf('-'+"  ");
					}
					}
					System.out.println();;
				}
			}
			

			
			public void  set_flag_check(boolean flg) //method for set is_check_mate flag
			{  
				flag_is_check=flg;
			}
			
			public boolean  get_flag_check()		//method of getting is_check_mate flag
			{  
				return flag_is_check;
			}
			
			public void set_piece(int c,int d,char type)		//set particular location in board with piece type
			{  
				array_2d_piece[c][d].symbol=type;
			}
			
			public void set_player(String ply)			//method for set player
			{
				player_color=ply;
				
			}
			
			public String get_player(){			//method for get player
				
				return player_color;
			}
						
			
}	//end board class

