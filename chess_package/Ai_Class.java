package chess_package;

import javax.xml.ws.Service.Mode;

class Node{			//Ai_Class constructor
	Piece_Class board_ins[][];
	int value;
	
	Node(Piece_Class state[][] ,int val){
		board_ins=state;
		this.value=val;
	}	
	
}		//end of node class



public class Ai_Class{		//Ai_Class 
	
	static String type_list[]= {"king","queen","bishop","rook","knight","pawn"};
	static int hvalue[]= {500,200,50,50,50,10};
	static int s;static int x1;static int x2;
	static int d;static int y1;static int y2;
	static Piece_Class ret_piece;
	
	
	public static int get_heuristic(Piece_Class piece) {		//heuristic function
		int ret_value=0;
		
		for(int i=0;i<6;i++) {
			if(type_list[i]==piece.name) {
				ret_value=hvalue[i];
			}
		}
		
		return ret_value;		//return the heuristic value
	}
	
	
	
	public static int minimax_algorithm(Node node,int depth) {		//method for minimax_algorithm
		
		System.out.println();
		if(depth==3) 	//base condition of recursion
		{		
			
			return get_heuristic(node.board_ins[s][d]);
			
		}else
		{
			
			Board_Class board_obj=new Board_Class();
			for(int i=0;i<8;i++) {			//loop for getting board piece
				for(int j=0;j<8;j++) {
					
				Piece_Class piece_obj=board_obj.get_board()[i][j];		//access piece from chess board
					
				if(piece_obj!=null)
				{
						
						for(int k=0;k<8;k++) {
							for(int m=0;m<8;m++){
								
								boolean valid_flag= false;
								if(piece_obj.color==board_obj.player_color) {
									valid_flag=piece_obj.move_piece(i, j, k, m);		//call move_piece function
								}
								
								if(valid_flag==true)
								{
									System.out.println("move is called for "+i+","+j+","+k+","+m);
									board_obj.set_piece(k, m, piece_obj);		//set the piece on board
									board_obj.set_piece(i, j, null);
									
									Node node_obj=new Node(board_obj.get_board(), get_assign_value(depth));
									s=k;d=m;
									
								
									
									if(depth%2==0) {		//maximum part
										System.out.println("val="+node_obj.value);
										
										System.out.println("max");
										int temp=node.value;
										node.value=Math.max(node.value, minimax_algorithm(node_obj,depth+1));	
										System.out.println("node_val="+node.value);
										
										if(node.value>temp) {
											x1=i;x2=k;
											y1=j;y2=m;
											ret_piece=piece_obj;
										}
										
										
									}
									else {		//minimum part
										System.out.println("val="+node_obj.value);
										
										System.out.println("min");
										int temp=node.value;
										node.value=Math.max(node.value, minimax_algorithm(node_obj,depth+1));
										System.out.println("node_val="+node.value);
										if(node.value>temp) {
											x1=i;x2=k;
											y1=j;y2=m;
											ret_piece=piece_obj;
										}
										
									
									}
									
								
									board_obj.set_piece(k, m, null);
									board_obj.set_piece(i, j, piece_obj);		//reset the piece on the board
								}			
							
						 }				
				      }	
				   }
			    }	
			 }
			return node.value;
				
		}		//end of outer else block
		
	}
	
	
	public static int get_assign_value(int d) {		//method for assigning default values in the node
	
		if(d%2==0) {
			return -1000;
		}else {
			return 1000;
		}
		
	}
	
}		//end of Ai_Class

