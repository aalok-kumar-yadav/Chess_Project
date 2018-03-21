package chess_package;

public class Board_Class {//chess board class
	static char array_2d_piece[][]=new char[8][8];
	static boolean flag_is_check=false;
		
		public  void set_chess_board(){  //set the whole chess board with pieces declared by myself
			for(int i=0;i<8;i++){
				array_2d_piece[1][i]='p';
				array_2d_piece[6][i]='P';
				}
				array_2d_piece[0][0]='r'; //Rook initialization
				array_2d_piece[0][7]='r';
				
				array_2d_piece[0][6]='n'; //Knight initialization
				array_2d_piece[0][1]='n';
							
						array_2d_piece[0][2]='b';  // bishop initialization
						array_2d_piece[0][5]='b';
						
						array_2d_piece[0][3]='q';  //king  and queen initialization
						array_2d_piece[0][4]='k';
							
				//second party initialization
								
						array_2d_piece[7][0]='R';  //Rook initialization
						array_2d_piece[7][7]='R';
								
							array_2d_piece[7][1]='N'; //Knight initialization
							array_2d_piece[7][6]='N';
									
							array_2d_piece[7][2]='B';  //Bishop initialization
							array_2d_piece[7][5]='B';
												
							array_2d_piece[7][4]='Q';  //king  and queen initialization
							array_2d_piece[7][3]='K';
																	
			}
		
		public char get_loc_piece(int p,int q){ //method of  location piece object to finding
			
				return array_2d_piece[p][q];
			}
		
		 public char[][] get_board(){ //get chess board when called
				
				return array_2d_piece;
			}
			 
		 public void set_board(char arr[][]){ //set board after valid move
			 
				array_2d_piece=arr;
			}
		 
			public int is_king_alive(){//king's status of alive or not 
				int count=0;
				int king1=0;
				int king2=0;
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						
						if(array_2d_piece[i][j]=='k')
						{//checking first king, i mean suppose white type
							king1=1;
							continue;
						}
						else if(array_2d_piece[i][j]=='K')
						{//checking first king, i mean suppose black type
						
								king2=2;
								continue;
							}else{  //none of found
								continue;
							
						}
					}
				}
				count=king1+king2;
				return count; //returning count
			}
			
			public void show_board(){  //show current board function
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
					System.out.printf(array_2d_piece[i][j]+"  ");
					}
					System.out.println();;
				}
			}
			
			public int get_index_piece(char f){  //getting location of type of piece
				boolean flag=false;
				int loc_type=0;
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						if(array_2d_piece[i][j]==f){
							loc_type=(8*i)+(j+1);  //converting index to location
                            flag=true;
							break;
						}else{
							continue;
						}	
					}
						if(flag==true){
							break;
						}else{
							continue;
						}
					}
				return loc_type;
			}
			
			public void  set_flag_check(boolean flg) //method of setting flag of is_check_mate class
			{  
			
				flag_is_check=flg;
			}
			
			public boolean  get_flag_check(){  //method of getting ic_check_mate class
				
				return flag_is_check;
			}
			
			public void set_parti(int c,int d,char type)
			{  //set particular location in board with piece type
				array_2d_piece[c][d]=type;
			}
			
			public boolean is_white(char ch){ //checking white type or not
				if((ch=='Q')||(ch=='K')||(ch=='P')||(ch=='B')||(ch=='N')||(ch=='R')){
					return true;
				}
				else{
					return false;
				}
				
			}
			
			public boolean is_black(char ch){   //checking black type or not
				
				if((ch=='q')||(ch=='k')||(ch=='p')||(ch=='b')||(ch=='n')||(ch=='r')){
					return true;
				}
				else{
					return false;
				}
			}
					
			
}//end board class

	
	
