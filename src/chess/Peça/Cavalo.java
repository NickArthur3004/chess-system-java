package chess.Pe�a;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessPe�a;
import chess.Color;


public class Cavalo extends ChessPe�a {

	public Cavalo(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}
	
	@Override
	public String toString() {
		return "C";
	}
	
	private boolean canMove(Posicao posicao) {
		ChessPe�a p = (ChessPe�a)getTabuleiro().pe�a(posicao);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		
		p.setValues(posicao.getLinha() - 1, posicao.getColuna()-2);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		
		p.setValues(posicao.getLinha() - 2, posicao.getColuna()-1);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		
		p.setValues(posicao.getLinha()-2, posicao.getColuna()+1);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		
		p.setValues(posicao.getLinha()-1, posicao.getColuna()+ 2);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		p.setValues(posicao.getLinha() + 1, posicao.getColuna() +2);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		p.setValues(posicao.getLinha() +2, posicao.getColuna() +1);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		
		p.setValues(posicao.getLinha() +2, posicao.getColuna() - 1);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		
		p.setValues(posicao.getLinha() + 1, posicao.getColuna() -2);
		if(getTabuleiro().PosicaoExistente(p) && canMove(p) ) {
			mat[p.getLinha()][p.getColuna()] = true;
			
		}
		return mat;
	}

}
