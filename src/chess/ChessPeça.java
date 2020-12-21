package chess;

import TabuleiroGame.Pe�a;
import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;

public abstract class ChessPe�a extends Pe�a{

	private Color color;
	private int moveCount;

	public ChessPe�a(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public void increaseMove() {
		moveCount++;
	} 
	
	public void decreaseMove() {
		moveCount--;
	} 
	
	
	
	public ChessPosi�ao getChessPosi�ao() {
		return ChessPosi�ao.fromPosi�ao(posicao);
	}

	protected boolean isThereOpponentPiece(Posicao posicao) {
		ChessPe�a p = (ChessPe�a)getTabuleiro().pe�a(posicao);
		return p != null && p.getColor() != color;
	}
	
}
