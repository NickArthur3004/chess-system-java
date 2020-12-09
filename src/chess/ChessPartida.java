package chess;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.Pe�a.Rei;
import chess.Pe�a.Torre;

public class ChessPartida {
	
	private Tabuleiro tabuleiro;

	public ChessPartida() {
		tabuleiro = new Tabuleiro(8, 8); 
		InicioSetup();
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
	private void InicioSetup() {
		tabuleiro.placePe�a(new Torre(tabuleiro, Color.WHITE), new Posicao(2, 1));
		tabuleiro.placePe�a(new Rei(tabuleiro, Color.BLACK), new Posicao(0, 4));
		tabuleiro.placePe�a(new Rei(tabuleiro, Color.WHITE), new Posicao(7, 4));
	}
	

}
