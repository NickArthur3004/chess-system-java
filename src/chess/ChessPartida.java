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
	
	private void PlaceNewPeça(char coluna, int linha , ChessPeça peça) {
		tabuleiro.placePeça(peça, new ChessPosiçao(coluna, linha).toPosiçao());
	}
	
	private void InicioSetup() {
		PlaceNewPeça('c', 1,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPeça('c', 2,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPeça('d', 2,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPeça('e', 2,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPeça('e', 1,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPeça('d', 1,new Rei(tabuleiro, Color.WHITE));
		
		PlaceNewPeça('c', 7,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPeça('c', 8,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPeça('d', 7,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPeça('e', 7,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPeça('e', 8,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPeça('d', 8,new Torre(tabuleiro, Color.BLACK));
	}
	

}
