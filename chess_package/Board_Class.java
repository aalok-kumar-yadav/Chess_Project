package chess_package;		//chess package

public class Board_Class   {		//Board class
	
	static Piece_Class array_2d_piece[][]=new Piece_Class[8][8];
	
	static String player_color="black";
		
		public  void set_chess_board(){	  //set the pieces in the board
			for(int i=0;i<8;i++){
				Pawn_Class pawn_obj= new Pawn_Class("white",'p',"pawn");		//white pawn 
				array_2d_piece[1][i]=pawn_obj;
				}
			
				for(int i=0;i<8;i++){
					Pawn_Class pawn_obj= new Pawn_Class("black",'P',"pawn");		//black pawn
					array_2d_piece[6][i]=pawn_obj;				
				}
				
				for(int i=0;i<=7;i+=7) {
					Rook_Class rook_obj=new Rook_Class("white",'r',"rook");
					array_2d_piece[0][i]=rook_obj; //white Rook initialization
				}
				
				for(int i=1;i<=6;i+=5) {
					Knight_Class knight_obj=new Knight_Class("white",'n',"knight");
					array_2d_piece[0][i]=knight_obj; //white knight initialization
				}
				
				for(int i=2;i<=5;i++) {
					Bishop_Class bishop_obj=new Bishop_Class("white",'b',"bishop");
					array_2d_piece[0][i]=bishop_obj; //white bishop initialization
				}
				
				King_Class king_obj=new King_Class("white",'k',"king");
				Queen_Class queen_obj=new Queen_Class("white",'q',"queen");
						array_2d_piece[0][3]=king_obj;  //white king  and queen initialization
						array_2d_piece[0][4]=queen_obj;
							
				//black piece initialization
						
						for(int i=0;i<=7;i+=7) {
							Rook_Class rook_obj=new Rook_Class("black",'R',"rook");
							array_2d_piece[7][i]=rook_obj; //Rook initialization
						}
						
						for(int i=1;i<=6;i+=5) {
							Knight_Class knight_obj=new Knight_Class("black",'N',"knight");
							array_2d_piece[7][i]=knight_obj; //black knight initialization
						}
						
						for(int i=2;i<=5;i++) {
							Bishop_Class bishop_obj=new Bishop_Class("black",'B',"bishop");
							array_2d_piece[7][i]=bishop_obj; //black bishop initialization
						}
						
						King_Class black_king_obj=new King_Class("black",'K',"king");
						Queen_Class black_queen_obj=new Queen_Class("black",'Q',"queen");
						
						array_2d_piece[7][4]=black_king_obj;  //black king  and queen initialization
						array_2d_piece[7][3]=black_queen_obj;	
						
																						
			}
		
		
			public Piece_Class get_loc_piece(int p,int q){ //method of  location piece object to finding
			
				return array_2d_piece[p][q];
			}
		
		
		 	public Piece_Class[][] get_board(){ //get chess board when called
				
				return array_2d_piece;
		 	}
			 
			
		 	public void show_board(){	  //show current board function
		 		
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
				
					if(array_2d_piece[i][j]!=null) {
						System.out.printf(array_2d_piece[i][j].symbol+"  ");
					}else {
						System.out.printf('-'+"  ");
					}
					}
					System.out.println();;
				}
			}
			
			
			public void set_piece(int c,int d,Piece_Class type)		//set particular location in board with piece type
			{  
				array_2d_piece[c][d]=type;
			}
			
			public void set_player(String ply)			//method for set player
			{
				player_color=ply;
				
			}
			
			public String get_player(){			//method for get player
				
				return player_color;
			}
			
			public static void change_turn() {		//method for changing turn of user
				
				if(player_color=="white") {
					player_color="black";
				}else if(player_color=="black") {
					player_color="white";
				}
			}
								
}	//end board class

