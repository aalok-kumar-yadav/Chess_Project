package chess_package;

public class Queen_Class extends Piece_Class
{
	 Queen_Class(String col, char sym,String name){
		 this.color=col;
		 this.symbol=sym;
		 this.name=name;
	 }
	
	public  boolean move_piece (int x1,int y1,int x2,int y2){
		
		boolean mov_ret=false;
		int abs1=Math.abs(x2-x1); //absolute value finding
		int abs2=Math.abs(y2-y1);
		
		if(abs1==abs2) {
			Bishop_Class bishop_obj=new Bishop_Class();
			mov_ret=bishop_obj.move_piece(x1, y1, x2, y2);
			
		}else if(abs2==0||abs1==0) {
			Rook_Class rook_obj=new Rook_Class();
			//System.out.println("index are "+x1+" "+ y1+ " "+ x2+" "+y2);
			mov_ret=rook_obj.move_piece(x1, y1, x2, y2);
			
		}
		
		return mov_ret;
	}
	
} //end of queen class