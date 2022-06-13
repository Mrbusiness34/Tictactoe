package files;
//A method is void if we don't ask it a question or ask it to do something. If it does something, it isn't
//void. Can you make this a string? Then it's a toString. Is there a winner? Then it's a boolean true or false.
//An object is a whole game, it is the whole tic tac toe game. Pencils, rulebook, board, everything. 
import java.util.Scanner;
//package files;
public class Tictactoe {
	private char[][] board;
	public Tictactoe(char[][] board) {
		this.board=board;
	}
	//This constructor creates a blueprint for the board. No arguments
	public Tictactoe() {
		this.board = new char[3][3];
		for (int i=0; i<3; i++) {
			for (int t=0; t<3; t++) {
				this.board[i][t]= 'e';
			}
		}
	}
	public void toMove(int i,int t, char playerCharacter) {
		this.board[i][t] = playerCharacter;
	}
	//This is a tostring method which accesses the board and returns the board as a string
	public String toString() {
		String garbageReturn = "  012 \n";
		//This for loop accesses the rows on the board
		for (int i=0; i < 3; i++) { 
			garbageReturn+=i + " ";
			//This for loop accesses the individual spaces on the board
			for(int t=0; t<3; t++) {
				garbageReturn+=board[i][t];
			}
			garbageReturn+="\n";
		}
		return garbageReturn;
	}
	public boolean isAnythingEmpty() {
		for (int i=0; i <3; i++) {
			for(int t=0; t<3; t++) {
				if(board[i][t]=='e') {
					return true;
				}
				
			}
		}
		return false;
	}
	//All of these if statements ensure that the board is checked for a winner.
	// The first 3 are for checking rows, the next 3 are for checking columns and the 
	//last 2 are for checking diagonals. 
	public boolean didThisPlayerWin(char playerCharacter) {
			if (board[0][0]==playerCharacter && board[0][1]==playerCharacter && board[0][2]==playerCharacter)
				return true;
			if (board[1][0]==playerCharacter && board[1][1]==playerCharacter && board[1][2]==playerCharacter)
				return true;
			if (board[2][0]==playerCharacter && board[2][1]==playerCharacter && board[2][2]==playerCharacter)
				return true;
			if (board[0][0]==playerCharacter && board[1][0]==playerCharacter && board[2][0]==playerCharacter)
				return true;
			if (board[0][1]==playerCharacter && board[1][1]==playerCharacter && board[2][1]==playerCharacter)
				return true;
			if (board[0][2]==playerCharacter && board[1][2]==playerCharacter && board[2][2]==playerCharacter)
				return true;
			if (board[0][0]==playerCharacter && board[1][1]==playerCharacter && board[2][2]==playerCharacter)
				return true;
			if (board[0][2]==playerCharacter && board[1][1]==playerCharacter && board[2][0]==playerCharacter)
				return true;
			else 
				return false;
			
	}
	public void doTurn(char player) {
		Scanner input = new Scanner(System.in);
		 System.out.println("It is currently " + player + "'s turn");
		int Row = -2;
		int Column = -2;
		boolean keepAsking = true;
		do {
			//This toString prints the board!
			System.out.println(toString());
			
		
		do{
			System.out.println("Enter a row: ");
	 
			String userInputRow = input.nextLine();
	
			try{
				Row=Integer.parseInt(userInputRow);
				if(Row< 0 || Row >2 ) {
					System.out.println("That space is out of bounds and can't be used. Try again.");
				}
	 
			}
			catch(RuntimeException badInput) {
				System.out.println("Please enter a number between 0 and 2.");
		 
			}
		}
		while (Row < 0|| Row > 2);
 
		do{
			System.out.println("Enter a column: ");
			String userInputColumn = input.nextLine();
	
			try{
				Column=Integer.parseInt(userInputColumn);
				if(Column<0 || Column>2 ) {
					System.out.println("That space is out of bounds and can't be used. Try again.");
				}
			}
			catch(RuntimeException badInputForColumn) {
				System.out.println("Please enter a number between 0 and 2.");
		 
		 }
	 }
	 while (Column < 0|| Column > 2);
		if(board[Row][Column]=='e') {
			keepAsking=false;
			}
		else {
			System.out.println("That space isn't empty!");
		}
		}
		while (keepAsking);
		this.toMove(Row, Column, player);
	}
	public String letsPlay() {
		do{
			doTurn('X');
			if(!didThisPlayerWin('X')  && !didThisPlayerWin('O') && isAnythingEmpty())
			doTurn('O');
		}
		while (!didThisPlayerWin('X')  && !didThisPlayerWin('O') && isAnythingEmpty());
		if(didThisPlayerWin('X')) {
			return "X wins!";
		}
			else {
				if(didThisPlayerWin('O')) {
					return "O wins!";
				}
				else {
					return "Nobody wins!";
				}
				
			
			}
	}

	public static void main (String[] New) {
		Tictactoe first = new Tictactoe();
		System.out.println(first.letsPlay());
		System.out.println(first);
	}
}