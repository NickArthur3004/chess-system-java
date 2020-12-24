package chess.Peça;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessPartida;
import chess.ChessPeça;
import chess.Color;


public class Rei extends ChessPeça {
	
	private ChessPartida chessPartida;

	public Rei(Tabuleiro tabuleiro, Color color, ChessPartida chessPartida) {
		super(tabuleiro, color);
		this.chessPartida = chessPartida;
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Posicao posicao) {
		ChessPeça p = (ChessPeça)getTabuleiro().peça(posicao);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Posicao posicao) {
		ChessPeça p =(ChessPeça)getTabuleiro().peça(posicao);
		return p != null && p instanceof Torre && p.getColor() == getColor() && p.getMoveCount() == 0; 
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		//cima
		p.setValues(posicao.getLinha() - 1, posicao.getColuna());
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		//baixo
		p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		//esquerda
		p.setValues(posicao.getLinha(), posicao.getColuna()- 1);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		//direita
		p.setValues(posicao.getLinha(), posicao.getColuna()+ 1);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		//diagonal cima esquerda
		p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		//diagonal cima direita
		p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		//diagonal baixo esquerda
		p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		//diagonal baixo direita
		p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		//#Movimento especial Castling
		if(getMoveCount() == 0 && !chessPartida.getCheck()) {
			//#movimento especial castling kingside rook
			Posicao posT1 = new Posicao(posicao.getLinha(),posicao.getColuna()+3);
			if(testRookCastling(posT1)) {
				Posicao p1 = new Posicao(posicao.getLinha(),posicao.getColuna()+1);
				Posicao p2 = new Posicao(posicao.getLinha(),posicao.getColuna()+2);
				if(getTabuleiro().peça(p1) == null && getTabuleiro().peça(p2)== null) {
					mat[posicao.getLinha()][posicao.getColuna()+2] = true;
				}
			}
			//#movimento especial castling queenside rook
			Posicao posT2 = new Posicao(posicao.getLinha(),posicao.getColuna()-4);
			if(testRookCastling(posT2)) {
				Posicao p1 = new Posicao(posicao.getLinha(),posicao.getColuna()-1);
				Posicao p2 = new Posicao(posicao.getLinha(),posicao.getColuna()-2);
				Posicao p3 = new Posicao(posicao.getLinha(),posicao.getColuna()-3);
				if(getTabuleiro().peça(p1) == null && getTabuleiro().peça(p2)== null && getTabuleiro().peça(p3)== null) {
					mat[posicao.getLinha()][posicao.getColuna()-2] = true;
				}
			}
		}
		return mat;
	}

}
