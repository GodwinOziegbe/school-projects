package tic_tac_toe;

import java.util.Random;
import java.util.Scanner;

public class Uppgift_1_tictactoe {

	public static void main(String[] args) {
		int playOn = 1;
		Scanner input = new Scanner(System.in);
		try {
			while (playOn > 0) {// Lets the user play the game again as long as desired
				int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
				int position1 = 0, position2 = 0, alreadySelected = 0, noOfPlayerMoves = 0, noOfPcMoves = 0,
						totalMoves = 0;
				int player = 10;
				int pc = 20;
				int index1 = 0, index2 = 0, index3 = 0;
				int fault = 0;
				boolean success = false;
				boolean gameOn = true;

				System.out.println();
				System.out.println("The player is (X) while the computer is (O)\n");
				while (gameOn == true) { /* checks that there is neither a draw nor a win */

					// Graphics Begins
					System.out.println();
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {

							if (arr[i][j] == player) {
								System.out.print(" [X]  ");
							} else if (arr[i][j] == pc) {
								System.out.print(" [O]  ");
							} else {
								System.out.print("[" + arr[i][j] + "]  ");
							}
						}
						System.out.println("\n");
					}
					// End of Graphics

					System.out.println("Select your position 1-9, 0 to terminate");
					int playerMove = Integer.parseInt(input.nextLine());
					do {
						if (alreadySelected > 0) {
							System.out.println("position: " + playerMove + "has" + "already been"
									+ " selected or invalid. Choose a different cell:");
							System.out.println("Select your position 0-9");
							playerMove = Integer.parseInt(input.nextLine());
						}

						switch (playerMove) {//switch case for the player
						case 0:
							System.out.println("Program terminated!");
							break;

						case 1:
							position1 = 0;
							position2 = 0;
							break;
						case 2:
							position1 = 0;
							position2 = 1;
							break;
						case 3:
							position1 = 0;
							position2 = 2;
							break;
						case 4:
							position1 = 1;
							position2 = 0;
							break;
						case 5:
							position1 = 1;
							position2 = 1;
							break;
						case 6:
							position1 = 1;
							position2 = 2;
							break;
						case 7:
							position1 = 2;
							position2 = 0;
							break;
						case 8:
							position1 = 2;
							position2 = 1;
							break;
						case 9:
							position1 = 2;
							position2 = 2;
							break;

						default:
							System.out.println("Wrong input");
							fault = 1;

							break;

						}

						alreadySelected++;

						if (playerMove == 0 || fault == 1) {
							break;
						}

					} while (arr[position1][position2] == player || arr[position1][position2] == pc);

					if (playerMove == 0 || fault == 1) {
						break;
					}
					alreadySelected = 0;

					noOfPlayerMoves++;

					arr[position1][position2] = player;

					if (noOfPlayerMoves < 2) {
						index2 = rand();
						index3 = rand();

						while (arr[index2][index3] == player || arr[index2][index3] == pc) {
							index2 = rand();
							index3 = rand();
						}

					}

					while (noOfPlayerMoves >= 2) {

						index1 = blockAndWin(arr);//Computer makes a selection or if a winner is found, return winner.
						if (index1 == 0) {//repeat if zero is returned
							index2 = rand();
							index3 = rand();

							while (arr[index2][index3] == player || arr[index2][index3] == pc) {//while the selection has already been made, make another
								index2 = rand();
								index3 = rand();
							}
							index1 = arr[index2][index3];
						}

						else if (index1 == player) {
							System.out.println("You are the winner(player)");
							success = true;
							gameOn = false;
							break;
						}

						System.out.println("Computer move is:" + index1);

						switch (index1) {//Switch case for computer selection

						case 1:
							position1 = 0;
							position2 = 0;
							break;
						case 2:
							position1 = 0;
							position2 = 1;
							break;
						case 3:
							position1 = 0;
							position2 = 2;
							break;
						case 4:
							position1 = 1;
							position2 = 0;
							break;
						case 5:
							position1 = 1;
							position2 = 1;
							break;
						case 6:
							position1 = 1;
							position2 = 2;
							break;
						case 7:
							position1 = 2;
							position2 = 0;
							break;
						case 8:
							position1 = 2;
							position2 = 1;
							break;
						case 9:
							position1 = 2;
							position2 = 2;
							break;

						}

						index2 = position1;
						index3 = position2;
						arr[index2][index3] = pc;
						success = true;
						break;
					}
					while (!success) {
						System.out.println("Computer move is:" + arr[index2][index3]);
						arr[index2][index3] = pc;
						success = true;
					}

					noOfPcMoves++;
					totalMoves = noOfPcMoves + noOfPlayerMoves;

					if (totalMoves < 8 && noOfPlayerMoves >= 3 && index1 != player) {
						index1 = blockAndWin(arr);// checking for a winner
						if (index1 == pc) {
							System.out.println("The computer is the winner!");
							gameOn = false;
							break;
						}
					}

					else if (totalMoves >= 8 && index1 != player) {
						index1 = blockAndWin(arr);// checking for a winner
						if (index1 == pc) {
							System.out.println("The computer is the winner!");
							break;
						} else {
							System.out.println("Draw!");
							break;
						}
					}

				}
				// Graphics Begins
				System.out.println();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {

						if (arr[i][j] == player) {
							System.out.print(" [X]  ");
						} else if (arr[i][j] == pc) {
							System.out.print(" [O]  ");
						} else {
							System.out.print("[" + arr[i][j] + "]  ");
						}
					}
					System.out.println("\n");
				}
				// End of Graphics

				System.out.println("Enter 1 to play again, 0 to quit...");
				playOn = Integer.parseInt(input.nextLine());

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Good bye!");

		input.close();
	}

	private static int blockAndWin(int[][] arr) {//The computer uses this function to block or win the player
		int player = 10, pc = 20;
		// ************Beginning of Check for Win Scan*********
		// Horizontal Loop Scan
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j < 1; j++) {

				if (arr[i][j] == player && arr[i][j + 1] == player && arr[i][j + 2] == player) {
					return player;
				} else if (arr[i][j] == pc && arr[i][j + 1] == pc && arr[i][j + 2] == pc) {

					return pc;
				}
			} // end of j-loop
		} // end of i-loop
			// ************End of Horizontal loop scan**

		// ************Beginning of vertical loop scan************
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j <= 2; j++) {

				if ((arr[i][j] == player && arr[i + 1][j] == player) && arr[i + 2][j] == player) {

					return player;
				} else if ((arr[i][j] == pc && arr[i + 1][j] == pc) && arr[i + 2][j] == pc) {
					return pc;
				}
			} // end of j-loop
		} // end of i-loop

		// ************End of Vertical loop scan***********

		// ************Beginning of Left to right Diagonal scan*********
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {

				if ((arr[i][j] == player && arr[i + 1][j + 1] == player) && arr[i + 2][j + 2] == player) {
					return player;
				}

				else if ((arr[i][j] == pc && arr[i + 1][j + 1] == pc) && arr[i + 2][j + 2] == pc) {
					return pc;
				}

				// ************End of Left to right Diagonal scan****

				// ************Beginning of Right to Left Diagonal scan******

				else if ((arr[i][j + 2] == player && arr[i + 1][j + 1] == player) && arr[i + 2][j] == player) {
					return player;

				}

				else if ((arr[i][j + 2] == pc && arr[i + 1][j + 1] == pc) && arr[i + 2][j] == pc) {
					return pc;
				}

			} // end of j-loop
		} // end of i-loop

		// ************End of Right to Left Diagonal scan***********

		// ************End of check for Win scan**************

		// **The Beginning of the computer scan to try to win by selecting cell close to preselected cells
		// Horizontal Scan

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j < 1; j++) {

				if ((arr[i][j] == pc && arr[i][j + 1] == pc) && arr[i][j + 2] != player) {
					return arr[i][j + 2];

				}

				else if ((arr[i][j] == pc && arr[i][j + 2] == pc) && arr[i][j + 1] != player) {

					return arr[i][j + 1];

				}

				else if ((arr[i][j + 1] == pc && arr[i][j + 2] == pc) && arr[i][j] != player) {
					return arr[i][j];
				}

			} // end of j-loop
		} // end of i-loop
			// ***Horizontal Scan Ends*******

		// ***Vertical Scan begins****

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j <= 2; j++) {

				if ((arr[i][j] == pc && arr[i + 1][j] == pc) && arr[i + 2][j] != player) {
					return arr[i + 2][j];
				} else if ((arr[i][j] == pc && arr[i + 2][j] == pc) && arr[i + 1][j] != player) {
					return arr[i + 1][j];

				} else if ((arr[i + 1][j] == pc && arr[i + 2][j] == pc) && arr[i][j] != player) {
					return arr[i][j];
				}
			} // end of j-loop
		} // end of i-loop
			// ***Vertical Scan Ends****

		// ***Left to Right Diagonal Scan begins****

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {

				if ((arr[i][j] == pc && arr[i + 1][j + 1] == pc) && arr[i + 2][j + 2] != player) {
					return arr[i + 2][j + 2];
				} else if ((arr[i][j] == pc && arr[i + 2][j + 2] == pc) && arr[i + 1][j + 1] != player) {
					return arr[i + 1][j + 1];
				} else if ((arr[i + 2][j + 2] == pc && arr[i + 1][j + 1] == pc) && arr[i][j] != player) {
					return arr[i][j];
				}

				// ***Left to Right Diagonal Scan begins****

				// ***Right to Left Diagonal Scan begins****

				else if ((arr[i][j + 2] == pc && arr[i + 1][j + 1] == pc) && arr[i + 2][j] != player) {
					return arr[i + 2][j];
				} else if ((arr[i][j + 2] == pc && arr[i + 2][j] == pc) && arr[i + 1][j + 1] != player) {
					return arr[i + 1][j + 1];
				} else if ((arr[i + 1][j + 1] == pc && arr[i + 2][j] == pc) && arr[i][j + 2] != player) {
					return arr[i][j + 2];
				}

			} // end of j-loop
		} // end of i-loop

		// End of The computer tries to win by selecting cell close to preselected cells**

		// The Beginning of The computer trying to prevent the user from winning easily by selecting a close cell
		// Horizontal Loop Scan
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j < 1; j++) {

				if ((arr[i][j] == player && arr[i][j + 1] == player) && arr[i][j + 2] != pc) {
					return arr[i][j + 2];

				}

				else if ((arr[i][j] == player && arr[i][j + 2] == player) && arr[i][j + 1] != pc) {

					return arr[i][j + 1];

				}

				else if ((arr[i][j + 1] == player && arr[i][j + 2] == player) && arr[i][j] != pc) {
					return arr[i][j];
				}

			} // end of j-loop
		} // end of i-loop
			// End of The Horizontal Loop Scan******

		// ************Beginning of Vertical loop scan*****

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j <= 2; j++) {

				if ((arr[i][j] == player && arr[i + 1][j] == player) && arr[i + 2][j] != pc) {
					return arr[i + 2][j];
				} else if ((arr[i][j] == player && arr[i + 2][j] == player) && arr[i + 1][j] != pc) {
					return arr[i + 1][j];

				} else if ((arr[i + 1][j] == player && arr[i + 2][j] == player) && arr[i][j] != pc) {
					return arr[i][j];
				}

			} // end of j-loop

		} // end of i-loop

		// *************End of Vertical Scan**************

		// **************Beginning of the left to right Diagonal loop scan*******
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {

				if ((arr[i][j] == player && arr[i + 1][j + 1] == player) && arr[i + 2][j + 2] != pc) {
					return arr[i + 2][j + 2];
				} else if ((arr[i][j] == player && arr[i + 2][j + 2] == player) && arr[i + 1][j + 1] != pc) {
					return arr[i + 1][j + 1];
				} else if ((arr[i + 2][j + 2] == player && arr[i + 1][j + 1] == player) && arr[i][j] != pc) {
					return arr[i][j];
				}

				// ****End of Left to right Diagonal Scan***************

				// *******Beginning of right to left Diagonal loop scan*****

				else if ((arr[i][j + 2] == player && arr[i + 1][j + 1] == player) && arr[i + 2][j] != pc) {
					return arr[i + 2][j];
				} else if ((arr[i][j + 2] == player && arr[i + 2][j] == player) && arr[i + 1][j + 1] != pc) {
					return arr[i + 1][j + 1];
				} else if ((arr[i + 1][j + 1] == player && arr[i + 2][j] == player) && arr[i][j + 2] != pc) {
					return arr[i][j + 2];
				}

			} // end of j-loop
		} // end of i-loop
			// End of The computer trying to prevent the user from winning easily by
			// selecting a close cell

		return 0;

	}

	private static int rand() {//function to generate random number

		Random myrand = new Random();
		int myindex = myrand.nextInt(3);

		return myindex;

	}

}
