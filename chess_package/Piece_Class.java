package chess_package;

abstract class Piece_Class {
	String color;
	char symbol;
	String name;
	
	abstract boolean move_piece(int x1,int y1,int x2,int y2);

}

