package chess.Pe�a;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessPe�a;
import chess.Color;

public class Bispo extends ChessPe�a {

	public Bispo(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}

	@Override
	public String toString() {
		return "B";
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		//noroeste
		p.setValues(posicao.getLinha() - 1, posicao.getColuna()-1);
		while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPe�a(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha()-1, p.getColuna()-1);;
		}
		
		if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		
		//nordeste
		p.setValues(posicao.getLinha()-1, posicao.getColuna() +1);
		while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPe�a(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha()-1, p.getColuna()+1);;
		}
		
		if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//sudeste
		p.setValues(posicao.getLinha()+1, posicao.getColuna() +1);
		while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPe�a(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha()+1, p.getColuna()+1);
		}
		
		if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//sudoeste
		p.setValues(posicao.getLinha() + 1, posicao.getColuna()-1);
		while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPe�a(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha()+1, p.getColuna()-1);
		}
		
		if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		return mat;
	}
}
