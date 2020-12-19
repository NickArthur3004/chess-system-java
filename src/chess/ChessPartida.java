package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import TabuleiroGame.Pe�a;
import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.Pe�a.Rei;
import chess.Pe�a.Torre;

public class ChessPartida {
	
	private Tabuleiro tabuleiro;
	private int turno;
	private Color currentPlayer;
	private boolean check;
	
	private List<Pe�a> pe�asNoTabuleiro = new ArrayList<>();
	private List<Pe�a> pe�asCapturadas = new ArrayList<>();


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
	
	public boolean getCheck() {
		return check;
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
	
	public boolean[][] possibleMoves(ChessPosi�ao sourcePosi�ao){
		Posicao posicao = sourcePosi�ao.toPosi�ao();
		validarSourcePosi�ao(posicao);
		return tabuleiro.pe�a(posicao).possibleMoves();
		
	}
	
	public ChessPe�a performChessMove(ChessPosi�ao sourcePosi�ao, ChessPosi�ao targetPosi�ao) {
		Posicao source = sourcePosi�ao.toPosi�ao();
		Posicao target = targetPosi�ao.toPosi�ao();
		validarSourcePosi�ao(source);
		validarTargetPosi�ao(source, target);
		Pe�a capturarPe�a= makeMove(source, target);
		
		if(testCheck(currentPlayer)) {
		  desfazerMove(source, target, capturarPe�a);
			throw new ChessException("Voce nao pode se colocar em check");
		}
		check = (testCheck(oponente(currentPlayer))) ? true : false;
		proximoTurno();
		return (ChessPe�a)capturarPe�a;
	
	}
	private Pe�a makeMove(Posicao source, Posicao target) {
		Pe�a p = tabuleiro.removePe�a(source);
		Pe�a capturarPe�a = tabuleiro.removePe�a(target);
		tabuleiro.placePe�a(p, target);
		
		if(capturarPe�a !=null) {
			pe�asNoTabuleiro.remove(capturarPe�a);
			pe�asCapturadas.add(capturarPe�a);
		}
		
		return capturarPe�a;
	}
	
	public void desfazerMove(Posicao source, Posicao target, Pe�a capturarPe�a) {
		Pe�a p = tabuleiro.removePe�a(target);
		tabuleiro.placePe�a(p, source);
		
		if(capturarPe�a != null) {
			tabuleiro.placePe�a(capturarPe�a, target);
			pe�asCapturadas.remove(capturarPe�a);
		    pe�asNoTabuleiro.add(capturarPe�a);
		}
	}
	
	private void validarSourcePosi�ao(Posicao posicao) {
		if(!tabuleiro.thereIsAPe�a(posicao)) {
			throw new ChessException("Nao existe pe�a na posi��o de origem");
		}
		if(currentPlayer != ((ChessPe�a)tabuleiro.pe�a(posicao)).getColor()) {
			throw new ChessException("A peca escolhida nao e sua");
		}
		if(!tabuleiro.pe�a(posicao).IsThereAnyPossibleMove()) {
			throw new ChessException("Nao existe movimentos possiveis para a pe�a escolhida");
		}
		
	}
	
	private void validarTargetPosi�ao(Posicao source, Posicao target) {
		
		if(!tabuleiro.pe�a(source).possibleMove(target)) {
			throw new ChessException("A pe�a escolhida nao pode se mover para a posicao de destino");
		}
		
	}
	
	private void proximoTurno() {
		turno++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private Color oponente(Color color) {
		return(color == color.WHITE) ? color.BLACK : color.WHITE;
	}
	
	private ChessPe�a rei(Color color){
		List<Pe�a> list = pe�asNoTabuleiro.stream().filter(x -> ((ChessPe�a)x).getColor() == color).collect(Collectors.toList());
		for(Pe�a p : list) {
			if(p instanceof Rei) {
				return (ChessPe�a)p;
			}
		}
		throw new IllegalStateException( "Nao existe o rei "+ color+ " no tabuleiro");
	}
	
	private boolean testCheck(Color color) {
		Posicao posicaoRei = rei(color).getChessPosi�ao().toPosi�ao();
		List <Pe�a> pe�aOponente = pe�asNoTabuleiro.stream().filter(x -> ((ChessPe�a)x).getColor() == oponente(color)).collect(Collectors.toList());
		for(Pe�a p : pe�aOponente) {
			boolean[][] mat = p.possibleMoves();
			if(mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;
			}
		}
		return false;
		}
	
	private void PlaceNewPe�a(char coluna, int linha , ChessPe�a pe�a) {
		tabuleiro.placePe�a(pe�a, new ChessPosi�ao(coluna, linha).toPosi�ao());
		pe�asNoTabuleiro.add(pe�a);
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
		PlaceNewPe�a('d', 8,new Rei(tabuleiro, Color.BLACK));
	}
	

}
