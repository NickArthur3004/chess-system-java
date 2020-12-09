package chess.Pe�a;

import TabuleiroGame.Tabuleiro;
import chess.ChessPe�a;
import chess.Color;

public class Rei extends ChessPe�a {

	public Rei(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}
	@Override
	public String toString() {
		return "K";
	}

}
