package chess.Peça;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessPeça;
import chess.Color;


public class Rei extends ChessPeça {

	public Rei(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Posicao posicao) {
		ChessPeça p = (ChessPeça)getTabuleiro().peça(posicao);
		return p == null || p.getColor() != getColor();
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
		return mat;
	}

}
