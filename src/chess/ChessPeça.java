package chess;

import TabuleiroGame.Peça;
import TabuleiroGame.Tabuleiro;

public class ChessPeça extends Peça{

	private Color color;

	public ChessPeça(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	
	
}
