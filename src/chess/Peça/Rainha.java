package chess.Peça;

import TabuleiroGame.Posicao;
import TabuleiroGame.Tabuleiro;
import chess.ChessPeça;
import chess.Color;

public class Rainha extends ChessPeça {

	public Rainha(Tabuleiro tabuleiro, Color color) {
		super(tabuleiro, color);
	}

	@Override
	public String toString() {
		return "Q";
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		//cima
		p.setValues(posicao.getLinha() - 1, posicao.getColuna());
		while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha()-1);
		}
		
		if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		
		//esquerda
		p.setValues(posicao.getLinha(), posicao.getColuna() -1);
		while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna()-1);
		}
		
		if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//direita
		p.setValues(posicao.getLinha(), posicao.getColuna() +1);
		while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna()+1);
		}
		
		if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//baixo
		p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() +1);
		}
		
		if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//noroeste
				p.setValues(posicao.getLinha() - 1, posicao.getColuna()-1);
				while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
					p.setValues(p.getLinha()-1, p.getColuna()-1);;
				}
				
				if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
				
				
				//nordeste
				p.setValues(posicao.getLinha()-1, posicao.getColuna() +1);
				while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
					p.setValues(p.getLinha()-1, p.getColuna()+1);;
				}
				
				if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
				
				//sudeste
				p.setValues(posicao.getLinha()+1, posicao.getColuna() +1);
				while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
					p.setValues(p.getLinha()+1, p.getColuna()+1);
				}
				
				if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
				
				//sudoeste
				p.setValues(posicao.getLinha() + 1, posicao.getColuna()-1);
				while(getTabuleiro().PosicaoExistente(p)&& !getTabuleiro().thereIsAPeça(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
					p.setValues(p.getLinha()+1, p.getColuna()-1);
				}
				
				if(getTabuleiro().PosicaoExistente(p) && isThereOpponentPiece(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
		return mat;
	}
}
