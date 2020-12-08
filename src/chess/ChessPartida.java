package chess;

import TabuleiroGame.Tabuleiro;

public class ChessPartida {
	
	private Tabuleiro tabuleiro;

	public ChessPartida() {
		tabuleiro = new Tabuleiro(8, 8); 
	}
	
	public ChessPe�a[][] getPe�as(){
		ChessPe�a[][] mat = new ChessPe�a[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i = 0;i<tabuleiro.getLinhas();i++) {
			for(int j = 0; j<tabuleiro.getColunas();j++) {
				mat[i][j]= (ChessPe�a) tabuleiro.pe�a(i, j ) ;
			}
		}
		return mat;
	}
	

}
