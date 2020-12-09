package chess.Peça;

import TabuleiroGame.Tabuleiro;
import chess.ChessPeça;
import chess.Color;

public class Rei extends ChessPeça {

	public Rei(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}
	@Override
	public String toString() {
		return "K";
	}

}
