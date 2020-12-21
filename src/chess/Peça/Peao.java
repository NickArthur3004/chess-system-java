package chess.Peça;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessPeça;
import chess.Color;

public class Peao extends ChessPeça {

	public Peao(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
		
	}
	
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		//Cima
		if(getColor() == Color.WHITE) {
			p.setValues(posicao.getLinha()-1, posicao.getColuna());
			if(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha()-2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha()-1, posicao.getColuna());
			if(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)&& getTabuleiro().PosicaoExistente(p2)&& !getTabuleiro().thereIsAPeça(p2) && getMoveCount() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
				p.setValues(posicao.getLinha()-1, posicao.getColuna()-1);
				if(getTabuleiro().PosicaoExistente(p)&& isThereOpponentPiece(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
			}
				p.setValues(posicao.getLinha()-1, posicao.getColuna()+1);
				if(getTabuleiro().PosicaoExistente(p)&& isThereOpponentPiece(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
			}
		}else {
			p.setValues(posicao.getLinha()+1, posicao.getColuna());
			if(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha()+2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha()+1, posicao.getColuna());
			if(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)&& getTabuleiro().PosicaoExistente(p2)&& !getTabuleiro().thereIsAPeça(p2) && getMoveCount() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
				p.setValues(posicao.getLinha()+1, posicao.getColuna()-1);
				if(getTabuleiro().PosicaoExistente(p)&& isThereOpponentPiece(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
			}
				p.setValues(posicao.getLinha()+1, posicao.getColuna()+1);
				if(getTabuleiro().PosicaoExistente(p)&& isThereOpponentPiece(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
			}
		}
		
		return mat;
	}

}
