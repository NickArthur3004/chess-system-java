package chess;

import TabuleiroGame.Peça;
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
	
	public ChessPeça performChessMove(ChessPosiçao sourcePosiçao, ChessPosiçao targetPosiçao) {
		Posicao source = sourcePosiçao.toPosiçao();
		Posicao target = targetPosiçao.toPosiçao();
		validarSourcePosiçao(source);
		validarTargetPosiçao(source, target);
		Peça capturarPeça= makeMove(source, target);
		return (ChessPeça)capturarPeça;
	
	}
	private Peça makeMove(Posicao source, Posicao target) {
		Peça p = tabuleiro.removePeça(source);
		Peça capturaPeça = tabuleiro.removePeça(target);
		tabuleiro.placePeça(p, target);
		return capturaPeça;
	}
	
	private void validarSourcePosiçao(Posicao posicao) {
		if(!tabuleiro.thereIsAPeça(posicao)) {
			throw new ChessException("Não existe peça na posição de origem");
		}
		if(!tabuleiro.peça(posicao).IsThereAnyPossibleMove()) {
			throw new ChessException("Não existe movimentos possiveis para a peça escolhida");
		}
	}
	
	private void validarTargetPosiçao(Posicao source, Posicao target) {
		
		if(!tabuleiro.peça(source).possibleMove(target)) {
			throw new ChessException("A peça escolhida não pode se mover para a posição de destino");
		}
		
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
