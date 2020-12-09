package chess;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.Peça.Rei;
import chess.Peça.Torre;

public class ChessPartida {
	
	private Tabuleiro tabuleiro;

	public ChessPartida() {
		tabuleiro = new Tabuleiro(8, 8); 
		InicioSetup();
	}
	
	public ChessPeça[][] getPeças(){
		ChessPeça[][] mat = new ChessPeça[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i = 0;i<tabuleiro.getLinhas();i++) {
			for(int j = 0; j<tabuleiro.getColunas();j++) {
				mat[i][j]= (ChessPeça) tabuleiro.peça(i, j ) ;
			}
		}
		return mat;
	}
	private void InicioSetup() {
		tabuleiro.placePeça(new Torre(tabuleiro, Color.WHITE), new Posicao(2, 1));
		tabuleiro.placePeça(new Rei(tabuleiro, Color.BLACK), new Posicao(0, 4));
		tabuleiro.placePeça(new Rei(tabuleiro, Color.WHITE), new Posicao(7, 4));
	}
	

}
