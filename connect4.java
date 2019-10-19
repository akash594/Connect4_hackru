import java.util.Scanner;
// connect four\
public class connectFour {

	public static boolean isNumeric(String strNum) {
   		try {
    	    int d = Integer.parseInt(strNum);
   		} catch (NumberFormatException | NullPointerException nfe) {
     		return false;
   		}
  		return true;
	}

	public static void main (String[] args) {

		Scanner scanner = new Scanner(System.in);
		int[][] board = new int[6][7]; // 2d array for board
		boolean gameFinished = false; // while loop ends when gameFinished = true
		boolean gameTie = false; // gameTie = true: no additional moves can be made
		boolean validInput = false; // checking if user input is a numeric value
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
			for (int j = 1; j <= board[0].length; j++) {
				System.out.print("  " + j + " ");
			}
			System.out.println();

			// Input Validation

			System.out.println("Player " + currentPlayer + ", please enter an integer corresponding to the position you'd like to mark. \n");

			while (validInput == false) {
				input = scanner.nextLine();
				if (isNumeric(input) == true) {
					x = Integer.parseInt(input) - 1;
					if (x > 6 || x < 0) {
						System.out.println("Please enter an integer between 1 and 7.\n");
					} else if (board[0][x] != 0) {
						System.out.println("That column is full! Please enter a different position.");
					} else {
						for (int i = board.length; i > 0; i--) {
							if (board[i-1][x] == 0) {
								board[i-1][x] = currentPlayer;
								y = i - 1;
								validInput = true;
								break;
							}
						}
					}
				} else {
					System.out.println("That input is not an integer. Please enter a valid integer.\n");
				}
			}
			validInput = false;

			// Win Condition validation

			// check for y axis
			for (int k = 1; k < 4; k++) {
				if ((y-k) >= 0) {
					if (board[y - k][x] == board[y - k + 1][x]) {
						count += 1;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			for (int k = 1; k < 4; k++) {
				if ((y+k) < board.length) {
					if (board[y + k][x] == board[y + k - 1][x]) {
						count += 1;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			if (count > 3) {
				System.out.println("Player " + currentPlayer + " wins!");
				gameFinished = true;
				break;
			}

			count = 1;

			// check for x axis
			for (int k = 1; k < 4; k++) {
				if ((x+k) < board[0].length) {
					if (board[y][x+k] == board[y][x + k - 1]) {
						count += 1;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			for (int k = 1; k < 4; k++) {
				if ((x-k) >= 0) {
					if (board[y][x-k] == board[y][x - k + 1]) {
						count += 1;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			if (count > 3) {
				System.out.println("Player " + currentPlayer + " wins!");
				gameFinished = true;
				break;
			}

			count = 1;

			// check for ++ diagonal axis
			for (int k = 1; k < 4; k++) {
				if ((x+k) < board[0].length && (y+k) < board.length) {
					if (board[y + k][x + k] == board[y + k - 1][x + k - 1]) {
						count += 1;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			for (int k = 1; k < 4; k++) {
				if ((x-k) >= 0 && (y-k) >= 0) {
					if (board[y - k][x - k] == board[y - k + 1][x - k + 1]) {
						count += 1;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			if (count > 3) {
				System.out.println("Player " + currentPlayer + " wins!");
				gameFinished = true;
				break;
			}

			count = 1;

			// check for +- diagonal axis
			for (int k = 1; k < 4; k++) {
				if ((x + k) < board[0].length && (y - k) >= 0) {
					if (board[y - k][x + k] == board[y - k + 1][x + k - 1]) {
						count += 1;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			for (int k = 1; k < 4; k++) {
				if ((x - k) >= 0 && (y + k) < board.length) {
					if (board[y + k][x - k] == board[y + k - 1][x - k + 1]) {
						count += 1;
					} else {
						break;
					}
				} else {
					break;
				}
			}
			if (count > 3) {
				System.out.println("Player " + currentPlayer + " wins!");
				gameFinished = true;
				break;
			}

			count = 1;

			// No Winner validation

			moveCount += 1;
			if (moveCount == 42){
				System.outprintln("No possible moves remain! It's a tie!");
			}

			// Changing of Players

			if (currentPlayer == 1){
				currentPlayer = 2;
			} else {
				currentPlayer = 1;
			}
		}

		// displaying the board

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
		for (int j = 1; j <= board[0].length; j++) {
			System.out.print("  " + j + " ");
		}
		System.out.println();
	}
}
