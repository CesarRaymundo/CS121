import java.awt.Point;

public class TicTacToeGame implements TicTacToe {

	private BoardChoice[][] gameGrid;
	private GameState winner;
	private Point[] movesHistory = new Point[9];
	private int moveCount = 0;
	private BoardChoice lastMove;

	/**
	 * The constructor for a new TicTacToe game
	 */
	public TicTacToeGame() {
		newGame();
	}

	/**
	 * Reset the game.
	 * All board positions are OPEN and the game is IN_PROGRESS.
	 */
	@Override
	public void newGame() {

		moveCount = 0;
		lastMove = null;
		for (int i = 0; i < 0; i++) {
			movesHistory[i] = null;
		}
		gameGrid = new BoardChoice[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				gameGrid[row][col] = TicTacToe.BoardChoice.OPEN;

			}
		}
		winner = GameState.IN_PROGRESS;
	}

	/**
	 * If the choice is invalid for any reason, return false.
	 * A choice is invalid if the game is over, the position is
	 * already claimed, or the player made the previous choice
	 * (no player can make two moves in a row). 
	 * If the chosen row, column position is not already claimed
	 * and the game is not already over, claim it for the player.
	 * A winning move or choosing the last open position ends
	 * the game.
	 * 
	 * @param player expecting either BoardChoice.X or BoardChoice.O
	 * @param row row to claim - value from 0 to 2
	 * @param col column to claim - value from 0 to 2
	 * @return true if the choice was a valid move, else false
	 */
	@Override
	public boolean choose(BoardChoice player, int row, int col) {

		if (gameGrid[row][col] == BoardChoice.OPEN && !this.gameOver() && lastMove == null) {
			gameGrid[row][col] = player;
			lastMove = player;
			Point plot = new Point(row, col);
			movesHistory[moveCount] = plot;
			moveCount++;
			return true;
		} 
		
		else if (gameGrid[row][col] == BoardChoice.OPEN && !this.gameOver() && lastMove != player) {
			gameGrid[row][col] = player;
			lastMove = player;
			Point plot = new Point(row, col);
			movesHistory[moveCount] = plot;

			moveCount++;
			return true;
		}

		else {
			return false;
		}

	}

	/**
	 * Will check if player X or O got 3 in a row in any way and give the gameState. 
	 * If there's no winner, GameState will be tied. 
	 *@return true if game is over or false if it's not.
	 */
	@Override
	public boolean gameOver() {
	/////// Possibilities for X
		/**
		 * Top horizontal option
		 */
		if (gameGrid[0][0] == BoardChoice.X) {
			if (gameGrid[0][1] == BoardChoice.X) {
				if (gameGrid[0][2] == BoardChoice.X) {
					winner = GameState.X_WON;
					return true;
				}

			}

		}
		/**
		 * Middle horizontal option
		 */
		if (gameGrid[1][0] == BoardChoice.X) {
			if (gameGrid[1][1] == BoardChoice.X) {
				if (gameGrid[1][2] == BoardChoice.X) {
					winner = GameState.X_WON;
					return true;
				}
			}

		}
		/**
		 * Bottom horizontal option
		 */
		if (gameGrid[2][0] == BoardChoice.X) {
			if (gameGrid[2][1] == BoardChoice.X) {
				if (gameGrid[2][2] == BoardChoice.X) {
					winner = GameState.X_WON;
					return true;
				}
			}

		}
		/**
		 * First vertical column option
		 */
		if (gameGrid[0][0] == BoardChoice.X) {
			if (gameGrid[1][0] == BoardChoice.X) {
				if (gameGrid[2][0] == BoardChoice.X) {
					winner = GameState.X_WON;
					return true;
				}
			}

		}
		/**
		 * Second vertical column option
		 */
		if (gameGrid[0][1] == BoardChoice.X) {
			if (gameGrid[1][1] == BoardChoice.X) {
				if (gameGrid[2][1] == BoardChoice.X) {
					winner = GameState.X_WON;
					return true;
				}
			}
		}

		/**
		 * Third vertical column option
		 */
		if (gameGrid[0][2] == BoardChoice.X) {
			if (gameGrid[1][2] == BoardChoice.X) {
				if (gameGrid[2][2] == BoardChoice.X) {
					winner = GameState.X_WON;
					return true;
				}
			}

		}
		/**
		 * First diagonal option
		 */
		if (gameGrid[0][0] == BoardChoice.X) {
			if (gameGrid[1][1] == BoardChoice.X) {
				if (gameGrid[2][2] == BoardChoice.X) {
					winner = GameState.X_WON;
					return true;
				}
			}

		}
		/**
		 * Second and last diagonal
		 */
		if (gameGrid[2][0] == BoardChoice.X) {
			if (gameGrid[1][1] == BoardChoice.X) {
				if (gameGrid[0][2] == BoardChoice.X) {
					winner = GameState.X_WON;
					return true;
				}
			}

		}
		
		/////// Possibilities for O
		/**
		 * Top horizontal option
		 */
		if (gameGrid[0][0] == BoardChoice.O) {
			if (gameGrid[0][1] == BoardChoice.O) {
				if (gameGrid[0][2] == BoardChoice.O) {
					winner = GameState.O_WON;
					return true;
				}
			}

		}
		/**
		 * Middle horizontal option
		 */
		if (gameGrid[1][0] == BoardChoice.O) {
			if (gameGrid[1][1] == BoardChoice.O) {
				if (gameGrid[1][2] == BoardChoice.O) {
					winner = GameState.O_WON;
					return true;
				}
			}

		}
		/**
		 * Bottom horizontal option
		 */
		if (gameGrid[2][0] == BoardChoice.O) {
			if (gameGrid[2][1] == BoardChoice.O) {
				if (gameGrid[2][2] == BoardChoice.O) {
					winner = GameState.O_WON;
					return true;
				}
			}

		}
		/**
		 * First vertical column option
		 */
		if (gameGrid[0][0] == BoardChoice.O) {
			if (gameGrid[1][0] == BoardChoice.O) {
				if (gameGrid[2][0] == BoardChoice.O) {
					winner = GameState.O_WON;
					return true;
				}
			}

		}
		/**
		 * Second vertical column option
		 */
		if (gameGrid[0][1] == BoardChoice.O) {
			if (gameGrid[1][1] == BoardChoice.O) {
				if (gameGrid[2][1] == BoardChoice.O) {
					winner = GameState.O_WON;
					return true;
				}
			}

		}

		/**
		 * Third vertical column option
		 */
		if (gameGrid[0][2] == BoardChoice.O) {
			if (gameGrid[1][2] == BoardChoice.O) {
				if (gameGrid[2][2] == BoardChoice.O) {
					winner = GameState.O_WON;
					return true;
				}
			}

		}
		/**
		 * First diagonal option
		 */
		if (gameGrid[0][0] == BoardChoice.O) {
			if (gameGrid[1][1] == BoardChoice.O) {
				if (gameGrid[2][2] == BoardChoice.O) {
					winner = GameState.O_WON;
					return true;
				}
			}

		}
		/**
		 * Second and last diagonal option
		 */
		if (gameGrid[2][0] == BoardChoice.O) {
			if (gameGrid[1][1] == BoardChoice.O) {
				if (gameGrid[0][2] == BoardChoice.O) {
					winner = GameState.O_WON;
					return true;
				}
			}

		}
		/**
		 *  For a tie
		 */
		if (gameGrid[0][0] != BoardChoice.OPEN && gameGrid[0][1] != BoardChoice.OPEN
				&& gameGrid[0][2] != BoardChoice.OPEN && gameGrid[1][0] != BoardChoice.OPEN
				&& gameGrid[1][1] != BoardChoice.OPEN && gameGrid[1][2] != BoardChoice.OPEN
				&& gameGrid[2][0] != BoardChoice.OPEN && gameGrid[2][1] != BoardChoice.OPEN
				&& gameGrid[2][2] != BoardChoice.OPEN) {
			winner = GameState.TIE;
			return true;
		}
		return false;
	}
	
	/**
	 * Return the winner (X, O, or TIE) if the game is over, or
	 * IN_PROGRESS if the game is not over.
	 * 
	 * @return the winner of a completed game or IN_PROGRESS
	 */
	@Override
	public GameState getGameState() {
		if (gameOver() == true) {
			return winner;
		} else {
			return GameState.IN_PROGRESS;
		}

	}

	/**
	 * Getting the current gameGrid and returning a copy of it 
	 * with the original information.
	 * 
	 * @return array showing the current game board
	 */
	@Override
	public BoardChoice[][] getGameGrid() {
		BoardChoice[][] copyGameGrid = new BoardChoice[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				copyGameGrid[row][col] = gameGrid[row][col];
			}
		}

		return copyGameGrid;
	}

	/**
	 * Get the sequence of moves, where even indexes correspond to the
	 * first player's moves and odd indexes correspond to the second
	 * player's moves.
	 * NOTE: Move rows are stored in the first coordinate, "x", and move
	 * columns are stored in the second coordinate, "y". While possibly
	 * counter-intuitive, it is intentional.
	 * Preserve encapsulation by returning a copy of the original data.
	 * 
	 * @return array showing the sequence of claimed positions
	 */
	@Override
	public Point[] getMoves() {
		Point[] moves = new Point[moveCount];
		for (int i = 0; i < moveCount; i++) {
			moves[i] = movesHistory[i];
		}

		return moves;

	}

}
