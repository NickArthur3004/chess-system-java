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
	
	private void PlaceNewPe�a(char coluna, int linha , ChessPe�a pe�a) {
		tabuleiro.placePe�a(pe�a, new ChessPosi�ao(coluna, linha).toPosi�ao());
	}
	
	private void InicioSetup() {
		PlaceNewPe�a('c', 1,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPe�a('c', 2,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPe�a('d', 2,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPe�a('e', 2,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPe�a('e', 1,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPe�a('d', 1,new Rei(tabuleiro, Color.WHITE));
		
		PlaceNewPe�a('c', 7,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPe�a('c', 8,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPe�a('d', 7,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPe�a('e', 7,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPe�a('e', 8,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPe�a('d', 8,new Torre(tabuleiro, Color.BLACK));
	}
	

}
