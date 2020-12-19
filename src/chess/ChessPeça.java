package chess;

import TabuleiroGame.Peça;
import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;

public abstract class ChessPeça extends Peça{

	private Color color;

	public ChessPeça(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public ChessPosiçao getChessPosiçao() {
		return ChessPosiçao.fromPosiçao(posicao);
	}

	protected boolean isThereOpponentPiece(Posicao posicao) {
		ChessPeça p = (ChessPeça)getTabuleiro().peça(posicao);
		return p != null && p.getColor() != color;
	}
	
}
