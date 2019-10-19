 java.util.Scanner;
// connect four
public class connectFour {

	public static boolean isNumeric(String strNum) {
   		try {
    	    double d = Double.parseDouble(strNum);
   		} catch (NumberFormatException | NullPointerException nfe) {
     		return false;
   		}
  		return true;
	}

	public static void main (String[] args) {

		Scanner scanner = new Scanner(System.in);
		int[][] board = new int[6][7];
		boolean gameFinished = false;
		boolean gameTie = false;
		boolean validInput = false;
		int currentPlayer = 1;
		int x = 0;
		int y = 0;
		int count = 1;
		String input;

		System.out.println("\nWelcome to Connect Four!\n");

		while (gameFinished == false) {

			/*
			----------------------------- 1+4n
			| 1 | 2 | 3 | 4 | 5 | 6 | 7 |
			----------------------------- 1+4n
			| 1 | 2 | 3 | 4 | 5 | 6 | 7 |
			----------------------------- 1+4n
			| 1 | 2 | 3 | 4 | 5 | 6 | 7 |
			----------------------------- 1+4n
			| 1 | 2 | 3 | 4 | 5 | 6 | 7 |
			----------------------------- 1+4n
			| 1 | 2 | 3 | 4 | 5 | 6 | 7 |
			----------------------------- 1+4n
			| 1 | 2 | 3 | 4 | 5 | 6 | 7 |
			----------------------------- 1+4n
			*/

			// Displaying board

			for (int i = 0; i < board.length; i++) {
				System.out.print("-");
				for (int j = 0; j < board[0].length; j++) {
					System.out.print("----");
				}
				System.out.println();
				for (int k = 0; k < board[0].length; k++) {
					if (board[i][k] == 1){
						System.out.print("| x ");
					}else if (board[i][k] == 2){
						System.out.print("| o ");
					}else {
						System.out.print("|   ");
					}
				}
				System.out.println("|");
			}
			System.out.print("-");
			for (int j = 0; j < board[0].length; j++) {
				System.out.print("----");
			}
			System.out.println();

			// Input Validation

			System.out.println("Player " + currentPlayer + ", please enter an integer corresponding to the position you'd like to mark. \n");

			while (validInput == false) {
				input = scanner.nextLine();
				if (isNumeric(input) == true) {
					x = Integer.parseInt(input) - 1;
					if (x > 7 || x < 0) {
						System.out.println("Please enter an integer between 1 and 7.\n");
					} else if (board[0][x] != 0) {
						System.out.println("That column is full! Please enter a different position.");
					} else {
						for (int i = board.length; i > 0; i--) {
							if (board[i-1][x] == 0) {
								board[i-1][x] = currentPlayer;
								y = i - 1;
								validInput = true;
							}
						}
					}
				} else {
					System.out.println("That input is not an integer. Please enter a valid integer.\n");
				}
			}
			validInput = false;

			// Win Condition validation

			for (int k = 1; k < 4; k++){
				if ((y+k) < board.length) {
					if (board[y+k][x] == board[y][x]) {
						count += 1;
					} else if ((y-k) <= 0){
						if (board[y-k][x] == board[y][x]) {
							count +=1;
						}
					}
				}
			}

			// No Winner validation

			for(int i = 0; i < 8; i++){
				if(array[i] && array[i+1]){
					gameTie = true;
				}else{
					gameTie = false;
					break;
				}
			}

			if(gameTie == true){
				System.out.println("No possible moves remain! It's a tie!\n");
				gameFinished = true;
			}

			// Changing of Players

			if (currentPlayer == 1){
				currentPlayer = 2;
			} else {
				currentPlayer = 1;
			}
		}

		System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
		System.out.println("-----------");
		System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
		System.out.println("-----------");
		System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + "\n");

	}
}

