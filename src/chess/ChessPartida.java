package chess;

import java.util.ArrayList;
import java.util.List;

import TabuleiroGame.Peça;
import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.Peça.Rei;
import chess.Peça.Torre;

public class ChessPartida {
	
	private Tabuleiro tabuleiro;
	private int turno;
	private Color currentPlayer;
	
	private List<Peça> peçasNoTabuleiro = new ArrayList<>();
	private List<Peça> peçasCapturadas = new ArrayList<>();


	public ChessPartida() {
		tabuleiro = new Tabuleiro(8, 8); 
		turno = 1;
		currentPlayer = Color.WHITE;
		InicioSetup();
	}
	
	public int getTurno() {
		return turno;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
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
	
	public boolean[][] possibleMoves(ChessPosiçao sourcePosiçao){
		Posicao posicao = sourcePosiçao.toPosiçao();
		validarSourcePosiçao(posicao);
		return tabuleiro.peça(posicao).possibleMoves();
		
	}
	
	public ChessPeça performChessMove(ChessPosiçao sourcePosiçao, ChessPosiçao targetPosiçao) {
		Posicao source = sourcePosiçao.toPosiçao();
		Posicao target = targetPosiçao.toPosiçao();
		validarSourcePosiçao(source);
		validarTargetPosiçao(source, target);
		Peça capturarPeça= makeMove(source, target);
		proximoTurno();
		return (ChessPeça)capturarPeça;
	
	}
	private Peça makeMove(Posicao source, Posicao target) {
		Peça p = tabuleiro.removePeça(source);
		Peça capturaPeça = tabuleiro.removePeça(target);
		tabuleiro.placePeça(p, target);
		
		if(capturaPeça !=null) {
			peçasNoTabuleiro.remove(capturaPeça);
			peçasCapturadas.add(capturaPeça);
		}
		
		return capturaPeça;
	}
	
	private void validarSourcePosiçao(Posicao posicao) {
		if(!tabuleiro.thereIsAPeça(posicao)) {
			throw new ChessException("Nao existe peça na posição de origem");
		}
		if(currentPlayer != ((ChessPeça)tabuleiro.peça(posicao)).getColor()) {
			throw new ChessException("A peca escolhida nao e sua");
		}
		if(!tabuleiro.peça(posicao).IsThereAnyPossibleMove()) {
			throw new ChessException("Nao existe movimentos possiveis para a peça escolhida");
		}
		
	}
	
	private void validarTargetPosiçao(Posicao source, Posicao target) {
		
		if(!tabuleiro.peça(source).possibleMove(target)) {
			throw new ChessException("A peça escolhida nao pode se mover para a posicao de destino");
		}
		
	}
	
	private void proximoTurno() {
		turno++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private void PlaceNewPeça(char coluna, int linha , ChessPeça peça) {
		tabuleiro.placePeça(peça, new ChessPosiçao(coluna, linha).toPosiçao());
		peçasNoTabuleiro.add(peça);
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
