package chess.Peça;

import TabuleiroGame.Tabuleiro;
import chess.ChessPeça;
import chess.Color;

public class Torre extends ChessPeça {

	public Torre(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}

	@Override
	public String toString() {
		return "T";
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return mat;
	}
}
