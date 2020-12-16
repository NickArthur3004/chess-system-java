package chess;

import TabuleiroGame.Pe�a;
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
	
	public ChessPe�a performChessMove(ChessPosi�ao sourcePosi�ao, ChessPosi�ao targetPosi�ao) {
		Posicao source = sourcePosi�ao.toPosi�ao();
		Posicao target = targetPosi�ao.toPosi�ao();
		validarSourcePosi�ao(source);
		validarTargetPosi�ao(source, target);
		Pe�a capturarPe�a= makeMove(source, target);
		return (ChessPe�a)capturarPe�a;
	
	}
	private Pe�a makeMove(Posicao source, Posicao target) {
		Pe�a p = tabuleiro.removePe�a(source);
		Pe�a capturaPe�a = tabuleiro.removePe�a(target);
		tabuleiro.placePe�a(p, target);
		return capturaPe�a;
	}
	
	private void validarSourcePosi�ao(Posicao posicao) {
		if(!tabuleiro.thereIsAPe�a(posicao)) {
			throw new ChessException("N�o existe pe�a na posi��o de origem");
		}
		if(!tabuleiro.pe�a(posicao).IsThereAnyPossibleMove()) {
			throw new ChessException("N�o existe movimentos possiveis para a pe�a escolhida");
		}
	}
	
	private void validarTargetPosi�ao(Posicao source, Posicao target) {
		
		if(!tabuleiro.pe�a(source).possibleMove(target)) {
			throw new ChessException("A pe�a escolhida n�o pode se mover para a posi��o de destino");
		}
		
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
