package chess.Pe�a;

import TabuleiroGame.Tabuleiro;
import chess.ChessPe�a;
import chess.Color;

public class Torre extends ChessPe�a {

	public Torre(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}

	@Override
	public String toString() {
		return "T";
	}
}
