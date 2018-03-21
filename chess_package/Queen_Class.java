package chess_package;
import java.util.*;
import java.math.*;
//queen class implements camel and elephant class
public class Queen_Class implements Bishop_Class,Rook_Class 
{
	//method of queen piece for any user
	public static boolean move_queen (int usr,int x1,int y1,int x2,int y2,char ty){
		//making own class object
		Queen_Class obj_queen=new Queen_Class(); 
		
			int abs1=Math.abs(x2-x1); //absolute value finding
			int abs2=Math.abs(y2-y1);
			
			if(abs1==abs2){

			boolean cnfr =obj_queen.move_c(usr, x1,y1,x2,y2,ty);//calling camel function and assign boolean 
				return cnfr;
				
				}
			else if(abs2==0||abs1==0){
				
		boolean vgf=obj_queen.move_horse(usr, x1,y1,x2,y2,ty);//calling camel function and assign boolean 
		return vgf;
			}
			else{
	   
	    	return false;
	    }
	
		}//move_queen method end
} //queen class end