package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import TabuleiroGame.Peça;
import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.Peça.Bispo;
import chess.Peça.Peao;
import chess.Peça.Rei;
import chess.Peça.Torre;

public class ChessPartida {
	
	private Tabuleiro tabuleiro;
	private int turno;
	private Color currentPlayer;
	private boolean check;
	private boolean checkMate;
	
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
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckMate() {
		return checkMate;
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
		
		if(testCheck(currentPlayer)) {
		  desfazerMove(source, target, capturarPeça);
			throw new ChessException("Voce nao pode se colocar em check");
		}
		check = (testCheck(oponente(currentPlayer))) ? true : false;
		if(testCheckMate(oponente(currentPlayer))) {
			checkMate = true;
			
		}else {
			proximoTurno();
		}
		
		return (ChessPeça)capturarPeça;
	
	}
	private Peça makeMove(Posicao source, Posicao target) {
		ChessPeça p = (ChessPeça)tabuleiro.removePeça(source);
		p.increaseMove();
		Peça capturarPeça = tabuleiro.removePeça(target);
		tabuleiro.placePeça(p, target);
		
		if(capturarPeça !=null) {
			peçasNoTabuleiro.remove(capturarPeça);
			peçasCapturadas.add(capturarPeça);
		}
		
		return capturarPeça;
	}
	
	public void desfazerMove(Posicao source, Posicao target, Peça capturarPeça) {
		ChessPeça p = (ChessPeça)tabuleiro.removePeça(target);
		p.decreaseMove();
		tabuleiro.placePeça(p, source);
		
		if(capturarPeça != null) {
			tabuleiro.placePeça(capturarPeça, target);
			peçasCapturadas.remove(capturarPeça);
		    peçasNoTabuleiro.add(capturarPeça);
		}
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
	
	private Color oponente(Color color) {
		return(color == color.WHITE) ? color.BLACK : color.WHITE;
	}
	
	private ChessPeça rei(Color color){
		List<Peça> list = peçasNoTabuleiro.stream().filter(x -> ((ChessPeça)x).getColor() == color).collect(Collectors.toList());
		for(Peça p : list) {
			if(p instanceof Rei) {
				return (ChessPeça)p;
			}
		}
		throw new IllegalStateException( "Nao existe o rei "+ color+ " no tabuleiro");
	}
	
	private boolean testCheck(Color color) {
		Posicao posicaoRei = rei(color).getChessPosiçao().toPosiçao();
		List <Peça> peçaOponente = peçasNoTabuleiro.stream().filter(x -> ((ChessPeça)x).getColor() == oponente(color)).collect(Collectors.toList());
		for(Peça p : peçaOponente) {
			boolean[][] mat = p.possibleMoves();
			if(mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;
			}
		}
		return false;
		}
	private boolean testCheckMate(Color color) {
		if(!testCheck(color)) {
			return false;
		}
		List<Peça> list = peçasNoTabuleiro.stream().filter(x -> ((ChessPeça)x).getColor() == color).collect(Collectors.toList());
		for(Peça p : list) {
			boolean[][] mat = p.possibleMoves();
			for(int i = 0; i<tabuleiro.getLinhas(); i ++) {
				for(int j = 0; j <tabuleiro.getColunas(); j ++) {
					if(mat[i][j]) {
						Posicao source = ((ChessPeça)p).getChessPosiçao().toPosiçao();
						Posicao target = new Posicao(i,j);
						Peça capturaPeça = makeMove(source, target);
						boolean testCheck = testCheck(color);
						desfazerMove(source, target, capturaPeça);
						if(!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	private void PlaceNewPeça(char coluna, int linha , ChessPeça peça) {
		tabuleiro.placePeça(peça, new ChessPosiçao(coluna, linha).toPosiçao());
		peçasNoTabuleiro.add(peça);
	}
	
	private void InicioSetup() {
		PlaceNewPeça('a', 1,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPeça('c', 1,new Bispo(tabuleiro, Color.WHITE));
		PlaceNewPeça('f', 1,new Bispo(tabuleiro, Color.WHITE));
		PlaceNewPeça('e', 1,new Rei(tabuleiro, Color.WHITE));
		PlaceNewPeça('h', 1,new Torre(tabuleiro, Color.WHITE));
		PlaceNewPeça('a', 2,new Peao(tabuleiro, Color.WHITE));
		PlaceNewPeça('b', 2,new Peao(tabuleiro, Color.WHITE));
		PlaceNewPeça('c', 2,new Peao(tabuleiro, Color.WHITE));
		PlaceNewPeça('d', 2,new Peao(tabuleiro, Color.WHITE));
		PlaceNewPeça('e', 2,new Peao(tabuleiro, Color.WHITE));
		PlaceNewPeça('f', 2,new Peao(tabuleiro, Color.WHITE));
		PlaceNewPeça('g', 2,new Peao(tabuleiro, Color.WHITE));
		PlaceNewPeça('h', 2,new Peao(tabuleiro, Color.WHITE));
		
		PlaceNewPeça('a', 8,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPeça('c', 8,new Bispo(tabuleiro, Color.BLACK));
		PlaceNewPeça('f', 8,new Bispo(tabuleiro, Color.BLACK));
		PlaceNewPeça('e', 8,new Rei(tabuleiro, Color.BLACK));
		PlaceNewPeça('h', 8,new Torre(tabuleiro, Color.BLACK));
		PlaceNewPeça('a', 7,new Peao(tabuleiro, Color.BLACK));
		PlaceNewPeça('b', 7,new Peao(tabuleiro, Color.BLACK));
		PlaceNewPeça('c', 7,new Peao(tabuleiro, Color.BLACK));
		PlaceNewPeça('d', 7,new Peao(tabuleiro, Color.BLACK));
		PlaceNewPeça('e', 7,new Peao(tabuleiro, Color.BLACK));
		PlaceNewPeça('f', 7,new Peao(tabuleiro, Color.BLACK));
		PlaceNewPeça('g', 7,new Peao(tabuleiro, Color.BLACK));
		PlaceNewPeça('h', 7,new Peao(tabuleiro, Color.BLACK));
	}
	

}
