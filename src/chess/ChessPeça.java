package chess;

import TabuleiroGame.Pe�a;
import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;

public abstract class ChessPe�a extends Pe�a{

	private Color color;

	public ChessPe�a(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	protected boolean isThereOpponentPiece(Posicao posicao) {
		ChessPe�a p = (ChessPe�a)getTabuleiro().pe�a(posicao);
		return p != null && p.getColor() != color;
	}
	
}
