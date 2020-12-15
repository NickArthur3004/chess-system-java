package chess;

import TabuleiroGame.Pe�a;
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

	
	
}
